package com.bw.movie.mvp.dy.Model;


import com.bw.movie.bean.syBean.Details.DetailsBean;
import com.bw.movie.bean.syBean.Details.MovieCommentBean;
import com.bw.movie.mvp.dy.Contract.DetailsContract;
import com.bw.movie.util.ApiService;
import com.bw.movie.util.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * date:2020/4/24
 * author:王成虎(13671)
 * time:15:40
 * day:24
 * month:四月
 * function:
 */
public class DetailsModel implements DetailsContract.Model {
    @Override
    public void deta(int userId, String sessionId, String  movieId, DetaCallBack callBack) {
        Retrofit retrofit = RetrofitUtil.getInstance().getRetrofit();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<DetailsBean> observable = apiService.getXq(userId, sessionId, movieId);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DetailsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DetailsBean detailsBean) {
                        callBack.detasuccess(detailsBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.detaFilter(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void movieComment(int userId, String sessionId, String movieId,String commentContent, double score, movieCommentResult result) {

        Retrofit retrofit = RetrofitUtil.getInstance().getRetrofit();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<MovieCommentBean> observable = apiService.getMovieComment(userId,sessionId,movieId, commentContent, score);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MovieCommentBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MovieCommentBean movieCommentBean) {

                        result.movieCommentSuccess(movieCommentBean);

                    }

                    @Override
                    public void onError(Throwable e) {
                        result.movieCommentError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }


}
