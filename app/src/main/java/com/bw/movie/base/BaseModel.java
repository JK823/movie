package com.bw.movie.base;



import com.bw.movie.util.ApiService;
import com.bw.movie.util.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public abstract class BaseModel {
    public ApiService apiService;

    public BaseModel() {
        Retrofit retrofit = RetrofitUtil.getInstance().getRetrofit();
        apiService = retrofit.create(ApiService.class);
    }

    public void requestData(Observable observable, final hehe hehe) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Object o) {
                        hehe.success(o);
                    }

                    @Override
                    public void onError(Throwable e) {
                        hehe.error(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public interface hehe {
        void success(Object object);

        void error(String message);
    }
}
