package com.bw.movie.mvp.wd.Model;


import com.bw.movie.bean.myBean.LoginBean;
import com.bw.movie.bean.myBean.RegionBean;
import com.bw.movie.bean.myBean.SendOutEmailCodeBean;
import com.bw.movie.mvp.wd.Contract.LoginContract;
import com.bw.movie.util.ApiService;
import com.bw.movie.util.RetrofitUtil;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * date:2020/4/18
 * author:王成虎(13671)
 * time:13:58
 * day:18
 * month:四月
 * function:登录  微信登陆  注册  邮箱验证码
 */
public class LoginModel implements LoginContract.Model {
    @Override
    public void login(String email, String pwd, LoginResult result) {
        RetrofitUtil instance = RetrofitUtil.getInstance();
        ApiService service = instance.createService();
        Observable<LoginBean> loginData = service.getLogin(email, pwd);
        loginData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {

                        result.success(loginBean);

                    }

                    @Override
                    public void onError(Throwable e) {

                        result.equals(e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void wxLogin(String code, LoginResult result) {
        RetrofitUtil instance = RetrofitUtil.getInstance();
        ApiService service = instance.createService();
        Observable<LoginBean> wxlogin = service.getWxlogin(code);
        wxlogin.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {

                        result.success(loginBean);

                    }

                    @Override
                    public void onError(Throwable e) {

                        result.equals(e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void register(Map<String, String> map, RegisterResult result) {
        RetrofitUtil instance = RetrofitUtil.getInstance();
        ApiService service = instance.createService();
        Observable<RegionBean> region = service.getRegion(map);
        region.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegionBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegionBean regionBean) {

                        result.success(regionBean);

                    }

                    @Override
                    public void onError(Throwable e) {
                        result.equals(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void code(String email, CodeResult result) {
        RetrofitUtil instance = RetrofitUtil.getInstance();
        ApiService service = instance.createService();
        Observable<SendOutEmailCodeBean> sebdcode = service.getSebdcode(email);
        sebdcode.subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SendOutEmailCodeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SendOutEmailCodeBean sendOutEmailCodeBean) {
                        result.success(sendOutEmailCodeBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        result.equals(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
