package com.bw.movie.mvp.yy.Model;


import com.bw.movie.bean.yyBean.CineamdeBean;
import com.bw.movie.mvp.yy.Contract.CinemaContract;
import com.bw.movie.util.ApiService;
import com.bw.movie.util.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * date:2020/5/8
 * author:王成虎(13671)
 * time:15:58
 * day:08
 * month:五月
 * function:
 */
public class CinemaModel implements CinemaContract.Model {
    @Override
    public void cindetails(int userId, String sessionId, String cinemaId, CinemaDeCallBack cinemaDeCallBack) {
        Retrofit retrofit = RetrofitUtil.getInstance().getRetrofit();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<CineamdeBean> observable = apiService.getCinde(userId, sessionId, cinemaId);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CineamdeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CineamdeBean cineamdeBean) {
                        cinemaDeCallBack.success(cineamdeBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        cinemaDeCallBack.filter(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
