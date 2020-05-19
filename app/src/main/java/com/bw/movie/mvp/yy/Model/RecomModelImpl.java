package com.bw.movie.mvp.yy.Model;



import com.bw.movie.bean.yyBean.RecomBean;
import com.bw.movie.mvp.yy.Contract.RecomContract;
import com.bw.movie.util.ApiService;
import com.bw.movie.util.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class RecomModelImpl implements RecomContract.Model {
    @Override
    public void recom(int userId, String sessionId, int page, int count, DataCallBack callBack) {
        Retrofit retrofit = RetrofitUtil.getInstance().getRetrofit();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<RecomBean> observable = apiService.getRecom(userId, sessionId, page, count);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RecomBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RecomBean recomBean) {
                        callBack.success(recomBean);
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
