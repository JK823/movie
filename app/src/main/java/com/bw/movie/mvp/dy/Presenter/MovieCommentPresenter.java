package com.bw.movie.mvp.dy.Presenter;


import com.bw.movie.base.BasePresenter;
import com.bw.movie.bean.syBean.Details.MovieCommentBean;
import com.bw.movie.mvp.dy.Contract.DetailsContract;
import com.bw.movie.mvp.dy.Model.DetailsModel;

/**
 * date:2020/5/7
 * author:王成虎(13671)
 * time:15:54
 * day:07
 * month:五月
 * function:
 */
public class MovieCommentPresenter extends BasePresenter<DetailsContract.MovieCommentView> implements DetailsContract.MovieCommentPresenter {

    private DetailsModel model;

    @Override
    protected void initModel() {
        model = new DetailsModel();
    }

    @Override
    public void movieComment(int userId,String sessionId,String movieId, String commentContent, double score) {
        model.movieComment(userId,sessionId,movieId, commentContent, score, new DetailsContract.Model.movieCommentResult() {
            @Override
            public void movieCommentSuccess(MovieCommentBean bean) {
                getView().movieCommentSuccess(bean);
            }

            @Override
            public void movieCommentError(String msg) {
                getView().movieCommentError(msg);
            }
        });
    }
}
