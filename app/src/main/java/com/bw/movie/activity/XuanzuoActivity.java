package com.bw.movie.activity;

import android.os.Build;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.seatselection.Adapter;
import com.bw.movie.seatselection.bean.CinemaScheduleListBean;
import com.bw.movie.seatselection.bean.MoviesDetailBean;
import com.bw.movie.seatselection.mvp.Contract.XzContract;
import com.bw.movie.seatselection.mvp.Presenter.ZwPresenter;
import com.bw.movie.seatselection.zuo.ZuoWeiView;
import com.bw.movie.util.AppContext;
import com.bw.movie.util.MD5;
import com.bw.movie.util.ToastShow;
import com.facebook.drawee.backends.pipeline.Fresco;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class XuanzuoActivity extends BaseActivity<ZwPresenter> implements XzContract.View {


    @BindView(R.id.left_back)
    ImageView leftBack;
    @BindView(R.id.movieName)
    TextView movieName;
    @BindView(R.id.scrollView)
    HorizontalScrollView scrollView;
    @BindView(R.id.count)
    TextView count;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.zhiFu)
    Button zhiFu;
    @BindView(R.id.video)
    JCVideoPlayerStandard video;
    private Unbinder bind;
    private String cinemaId;
    private Adapter adapter = new Adapter();
    private int movieId;
    private PopupWindow popupWindow;
    private int popupWindowHeight;
    private double[] fore = new double[1];
    private String seat = "";
    private String scheduleid;
    private boolean popuWindonw_isShowing;
    private String imageUrl;
    private ZuoWeiView zuoView;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        //zuoView = findViewById(R.id.zuoWeiView);
        Fresco.initialize(this);
        bind = ButterKnife.bind(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);
        cinemaId = getIntent().getStringExtra("cinemaId");
        CinemaScheduleListBean.Result resultL = (CinemaScheduleListBean.Result) getIntent().getSerializableExtra("schedule_result");
        if (resultL != null) {
            movieId = resultL.getMovieId();
            movieName.setText(resultL.getName());
            video.setUp(resultL.getImageUrl(), JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "");
            Glide.with(this).load(resultL.getImageUrl()).centerCrop().into(video.thumbImageView);
        }
        presenter.movieSchedule(movieId, Integer.parseInt(cinemaId));
        View zhifuview = LayoutInflater.from(this).inflate(R.layout.zhifu_popuwindon, null);
        popupWindow = new PopupWindow(zhifuview, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        zhifuview.measure(0, 0);
        popupWindowHeight = zhifuview.getMeasuredHeight();
        adapter.setSeat(new Adapter.Seat() {
            @Override
            public void id(int hallId, int scheduleId, double price) {
                hallId = hallId;
                fore[0] = price;
                //zuoView.getSeat_buy().clear();
                seat = "";
                zhiFu.setText("￥" + 0.00);
                scheduleid = scheduleId + "";
                presenter.seatInfo(hallId);
            }
        });
        zuoView.setZuoWei(new ZuoWeiView.ZuoWei() {
            @Override
            public void zuowei(List<String> getSeat_buy) {
                zhiFu.setText("￥" + fore[0] * getSeat_buy.size());
                if (getSeat_buy.size() == 0) {
                    seat = "";
                } else {
                    for (int i = 0; i < getSeat_buy.size(); i++) {
                        if (i == 0) {
                            seat = getSeat_buy.get(0);
                        } else {
                            seat += "," + getSeat_buy.get(i);
                        }
                    }
                }
            }
        });
    }

    @Override
    protected ZwPresenter initPresenter() {
        EventBus.getDefault().register(this);
        zuoView.setScrollto(new ZuoWeiView.Scrollto() {
            @Override
            public void to(int width) {
                scrollView.scrollTo(width / 2, 0);
            }
        });
        return new ZwPresenter();
    }

    @Subscribe(sticky = true)
    public void hehe(MoviesDetailBean bean) {
        imageUrl = bean.getResult().getImageUrl();
        movieId = bean.getResult().getMovieId();
        movieName.setText(bean.getResult().getName());
        video.setUp(bean.getResult().getShortFilmList().get(0).getVideoUrl(), JCVideoPlayer.SCREEN_LAYOUT_NORMAL, "");
        Glide.with(this).load(bean.getResult().getShortFilmList().get(0).getImageUrl()).centerCrop().into(video.thumbImageView);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        bind.unbind();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayerStandard.releaseAllVideos();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @OnClick({R.id.zhiFu, R.id.left_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.left_back:
                onBackPressed();
                break;
            case R.id.zhiFu:
                if (popuWindonw_isShowing) {
                    if (seat.length() > 0) {
                        presenter.buyMovieTickets(scheduleid, seat, MD5.jiaMi(AppContext.preferences.getString("userId", "") + scheduleid + "movie"));
                    } else {
                        ToastShow.makeText("请先确认选座后进行支付", 500);
                    }
                } else {
                    popupWindow.showAsDropDown(zhiFu, 0, -popupWindowHeight - zhiFu.getLayoutParams().height, Gravity.TOP);
                    popuWindonw_isShowing = true;
                }
                break;
        }
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_xuan_zuo;
    }

    @Override
    public void success(Object object) {

    }

}
