package com.bw.movie.mvp.dy.Model;



import com.bw.movie.bean.syBean.GGBean;
import com.bw.movie.bean.syBean.HotBean;
import com.bw.movie.bean.syBean.NowBean;
import com.bw.movie.mvp.dy.Contract.HomeContract;
import com.bw.movie.util.ApiService;
import com.bw.movie.util.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class HomeModelImpl implements HomeContract.Model {
    @Override
    public void hot(int page, int count, final HotCallBack callBack) {
        Retrofit retrofit = RetrofitUtil.getInstance().getRetrofit();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<HotBean> observable = apiService.getHot(page, count);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HotBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HotBean hotBean) {
                        callBack.hotSuccess(hotBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.hotFilter(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void now(int page, int count, final NowCallBack callBack) {
        Retrofit retrofit = RetrofitUtil.getInstance().getRetrofit();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<NowBean> observable = apiService.getNow(page, count);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NowBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NowBean nowBean) {
                        callBack.nowSuccess(nowBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.nowFilter(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void gg(int page, int count, final GGCallBack callBack) {
        Retrofit retrofit = RetrofitUtil.getInstance().getRetrofit();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<GGBean> observable = apiService.getGG(page, count);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GGBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GGBean ggBean) {
                        callBack.ggSuccess(ggBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.ggFilter(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
