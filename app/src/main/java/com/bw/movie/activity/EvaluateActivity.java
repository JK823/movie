package com.bw.movie.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.bean.syBean.Details.MovieCommentBean;
import com.bw.movie.mvp.dy.Contract.DetailsContract;
import com.bw.movie.mvp.dy.Presenter.MovieCommentPresenter;
import com.bw.movie.util.EditText_jianPan;
import com.bw.movie.util.ToastShow;

import butterknife.BindView;
import butterknife.OnClick;


public class EvaluateActivity extends BaseActivity<MovieCommentPresenter> implements DetailsContract.MovieCommentView {

    @BindView(R.id.left_back)
    ImageView leftBack;
    @BindView(R.id.titleName)
    TextView titleName;
    @BindView(R.id.line1)
    LinearLayout line1;
    @BindView(R.id.movieName)
    TextView movieName;
    @BindView(R.id.score)
    TextView score;
    @BindView(R.id.ratingBar)
    RatingBar ratingBar;
    @BindView(R.id.edit_comment_movie)
    EditText editCommentMovie;
    @BindView(R.id.comment_size)
    TextView commentSize;
    @BindView(R.id.btn_comment)
    Button btnComment;
    private String movieId;

    @Override
    protected void initData() {
        movieId = getIntent().getStringExtra("movieId");
        presenter.movieComment(13874, "158883968028513874", movieId,"",1);
        String movieName = getIntent().getStringExtra("movieName");
        this.movieName.setText(movieName);

    }

    @Override
    protected MovieCommentPresenter initPresenter() {
        return new MovieCommentPresenter();
    }

    @Override
    protected void initView() {

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                score.setText("我的评分（" + rating * 2 + "）");
            }
        });

        editCommentMovie.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().length() <= 150) {
                    commentSize.setText(s.toString().length() + "/150");
                }
                if (s.toString().length() == 150) {
                    ToastShow.makeText("最多可评论150个字哦！", 500);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        EditText_jianPan.Listener(editCommentMovie,this);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_evaluate;
    }

    @Override
    public void movieCommentSuccess(MovieCommentBean bean) {

        ToastShow.makeText(bean.getMessage(),500);
        if (bean.getMessage().equals("0000")){
            finish();
        }

    }

    @Override
    public void movieCommentError(String msg) {

    }

    @OnClick({R.id.left_back, R.id.btn_comment})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.left_back:
                onBackPressed();
                break;
            case R.id.btn_comment:
                String[] s = editCommentMovie.getText().toString().split(" ");
                if (s.length > 0 && editCommentMovie.getText().toString().length() >= 15) {
                    presenter.movieComment(13874,"158883968028513874",movieId, editCommentMovie.getText().toString(), ratingBar.getRating());
                } else if (s.length == 0) {
                    ToastShow.makeText("说点什么吧！", 500);
                } else {
                    ToastShow.makeText("评论最少15个字！", 500);
                }
                break;
        }
    }


}
