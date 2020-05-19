package com.bw.movie.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.bean.syBean.Details.DetailsBean;
import com.bw.movie.mvp.dy.Contract.DetailsContract;
import com.bw.movie.mvp.dy.Presenter.DetailsPresenter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;

import butterknife.BindView;
import butterknife.OnClick;

public class DetailsActivity extends BaseActivity<DetailsPresenter> implements DetailsContract.View {


    @BindView(R.id.image_vertical)
    SimpleDraweeView imageVertical;
    @BindView(R.id.left_back)
    ImageView leftBack;
    @BindView(R.id.line1)
    LinearLayout line1;
    @BindView(R.id.score)
    TextView score;
    @BindView(R.id.comment)
    TextView comment;
    @BindView(R.id.movie_Name)
    TextView movieName;
    @BindView(R.id.movie_Type_duration)
    TextView movieTypeDuration;
    @BindView(R.id.release_Time_placeOrigin)
    TextView releaseTimePlaceOrigin;
    @BindView(R.id.write_movie_comment)
    Button writeMovieComment;
    @BindView(R.id.buy_cinemaTicket)
    Button buyCinemaTicket;
    @BindView(R.id.btn_linearLayout)
    LinearLayout btnLinearLayout;
    @BindView(R.id.weight_linearLayout)
    LinearLayout weightLinearLayout;
    @BindView(R.id.xq)
    ImageView xq;
    @BindView(R.id.cb_gz)
    CheckBox cbGz;
    private String movieId;
    private DetailsBean.ResultBean result;
    private int follow;
    Bitmap bp = null;
    float scaleWidth;
    float scaleHeight;
    boolean num=false;

    @Override
    protected void initData() {
        movieId = getIntent().getStringExtra("movieId");
        presenter.deta(13874, "158764769507013874", movieId);
        /**/

    }

    @Override
    protected DetailsPresenter initPresenter() {
        return new DetailsPresenter();
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void initView() {

        cbGz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cbGz.isChecked()) {
                    cbGz.setChecked(true);
                    cbGz.setText("已关注");
                } else {
                    cbGz.setChecked(false);
                    cbGz.setText("未关注");
                }
            }
        });

    }

    @Override
    protected int initLayout() {
        return R.layout.activity_details;
    }

    @Override
    public void detasuccess(Object obj) {

        if (obj instanceof DetailsBean) {
            DetailsBean detailsBean = (DetailsBean) obj;
            result = detailsBean.getResult();
            follow = detailsBean.getResult().getWhetherFollow();
            Glide.with(this).load(result.getImageUrl()).into(imageVertical);
            score.setText("评分" + result.getScore() + "" + "分");
            comment.setText("评论" + result.getCommentNum() + "" + "万条");
            movieName.setText(result.getName());
            releaseTimePlaceOrigin.setText(result.getDuration());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MMM-dd");
            String format = simpleDateFormat.format(result.getReleaseTime());
            releaseTimePlaceOrigin.setText(format + "\t\t中国大陆上映");
        }

    }

    @Override
    public void detaFilter(String msg) {

    }


    @OnClick({R.id.left_back, R.id.write_movie_comment, R.id.buy_cinemaTicket})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.left_back:
                finish();
                break;
            case R.id.write_movie_comment:
                Intent intent = new Intent(DetailsActivity.this, EvaluateActivity.class);
                intent.putExtra("movieId", result.getMovieId() + "");
                intent.putExtra("movieName", result.getName());
                startActivity(intent);
                break;
            case R.id.buy_cinemaTicket:
                Intent intent1 = new Intent(DetailsActivity.this, XuanzuoActivity.class);
                intent1.putExtra("movieName", result.getName());
                intent1.putExtra("movieId", result.getMovieId() + "");
                startActivity(intent1);
                break;
        }
    }
}
