package com.bw.movie.mvp.yy.Model;


import com.bw.movie.bean.yyBean.FjBean;
import com.bw.movie.mvp.yy.Contract.FjContract;
import com.bw.movie.mvp.yy.Contract.RecomContract;
import com.bw.movie.util.ApiService;
import com.bw.movie.util.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * date:2020/4/17
 * author:王成虎(13671)
 * time:22:14
 * day:17
 * month:四月
 * function:
 */
public class FjModel implements FjContract.Model {

    @Override
    public void nearby(int userId, String sessionId, int page, int count, RecomContract.Model.DataCallBack callBack) {
        Retrofit retrofit = RetrofitUtil.getInstance().getRetrofit();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<FjBean> observable = apiService.getNearby(userId, sessionId, page, count);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FjBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FjBean fjBean) {
                        callBack.success(fjBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.filter(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
