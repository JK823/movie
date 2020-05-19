package com.bw.movie.mvp.yy.Model;



import com.bw.movie.bean.yyBean.LeftBean;
import com.bw.movie.bean.yyBean.RightBean;
import com.bw.movie.mvp.yy.Contract.RegionContract;
import com.bw.movie.util.ApiService;
import com.bw.movie.util.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class RegionModelImpl implements RegionContract.Model {
    @Override
    public void left(LeftCallBack callBack) {
        Retrofit retrofit = RetrofitUtil.getInstance().getRetrofit();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<LeftBean> observable = apiService.getLeft();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LeftBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LeftBean leftBean) {
                        callBack.leftSuccess(leftBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.leftFilter(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void right(int regionId, RightCallBack callBack) {
        Retrofit retrofit = RetrofitUtil.getInstance().getRetrofit();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<RightBean> observable = apiService.getRight(regionId);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RightBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RightBean rightBean) {
                        callBack.rightSuccess(rightBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.rightFilter(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
