package com.bw.movie.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.androidkun.xtablayout.XTabLayout;
import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.bean.syBean.Details.FollowMovieBean;
import com.bw.movie.bean.yyBean.CineamdeBean;
import com.bw.movie.bean.yyBean.DateListBean;
import com.bw.movie.fragment.YFragment.Cinema.Cinema_Details;
import com.bw.movie.fragment.YFragment.Cinema.Cinema_Evaluation;
import com.bw.movie.mvp.yy.Contract.CinemaContract;
import com.bw.movie.mvp.yy.Presenter.CinemaPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class CinemaDeActivity extends BaseActivity<CinemaPresenter> implements CinemaContract.View {


    @BindView(R.id.fan_hui)
    ImageView fanHui;
    @BindView(R.id.cinema_name)
    TextView cinemaName;
    @BindView(R.id.attention)
    ImageView attention;
    @BindView(R.id.tv_type1)
    TextView tvType1;
    @BindView(R.id.here)
    LinearLayout here;
    @BindView(R.id.cinema_tab)
    XTabLayout cinemaTab;
    @BindView(R.id.cinema_vp)
    ViewPager cinemaVp;
    @BindView(R.id.cinema_Schedule)
    Button cinemaSchedule;
    private String cinemaId;
    boolean isChanged = false;
    private int follow;
    private DateListBean dateListBean;

    private List<Fragment> fragments = new ArrayList<>();

    private List<String > strings = new ArrayList<>();
    private CineamdeBean.ResultBean result;

    @Override
    protected void initData() {
        cinemaId = getIntent().getStringExtra("cinemaId");
        presenter.cindetails(13874, "158883968028513874", cinemaId);
    }

    @Override
    protected CinemaPresenter initPresenter() {
        return new CinemaPresenter();
    }

    @Override
    protected void initView() {

        /*attention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == attention){
                    if (isChanged){
                        attention.setImageDrawable(getResources().getDrawable(R.mipmap.xihuan_false));
                    }else {
                        attention.setImageDrawable(getResources().getDrawable(R.mipmap.xihuan_true));
                    }
                }
            }
        });*/


        fragments.add(new Cinema_Details());
        fragments.add(new Cinema_Evaluation());

        strings.add("影院详情");
        strings.add("影院评价");

        cinemaVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return strings.get(position);
            }
        });

        cinemaVp.setOffscreenPageLimit(2);
        cinemaTab.setupWithViewPager(cinemaVp);

    }

    @Override
    protected int initLayout() {
        return R.layout.activity_cinema_de;
    }

    @Override
    public void success(Object bean) {

        if (bean instanceof FollowMovieBean) {
            if (((FollowMovieBean) bean).getMessage().equals("关注成功")) {
                follow = 1;
                attention.setImageResource(R.mipmap.xihuan_true);
            } else if (((FollowMovieBean) bean).getMessage().equals("取消关注成功")) {
                follow = 2;
                attention.setImageResource(R.mipmap.xihuan_false);
            }
        }
        if (bean instanceof CineamdeBean){
            CineamdeBean cineamdeBean = (CineamdeBean)bean;
            result = cineamdeBean.getResult();
            cinemaName.setText(result.getName());
            tvType1.setText(result.getLabel());
        }

        if (bean instanceof DateListBean){
            dateListBean = (DateListBean)bean;
        }

    }

    @OnClick({R.id.fan_hui, R.id.cinema_Schedule})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.left_back:
                onBackPressed();
                break;
            case R.id.cinema_Schedule:
                if (cinemaSchedule.getText().toString().equals("查看该影院电影排期")) {
                    Intent intent = new Intent(this, CinemaScheduleActivity.class);
                    intent.putExtra("cinemaId", cinemaId);
                    intent.putExtra("dateListBean", dateListBean);
                    startActivity(intent);
                } else if (cinemaSchedule.getText().toString().equals("去购票")) {
                    Intent intent = new Intent(this, XuanzuoActivity.class);
                    intent.putExtra("cinemaId", cinemaId);
                    startActivity(intent);
                }
                break;
        }
    }

    @Override
    public void filter(String msg) {

    }


}
