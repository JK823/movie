package com.bw.movie.mvp.wd.Presenter;

import com.bw.movie.base.BasePresenter;
import com.bw.movie.bean.myBean.LoginBean;
import com.bw.movie.mvp.wd.Contract.LoginContract;
import com.bw.movie.mvp.wd.Model.LoginModel;

/**
 * date:2020/4/18
 * author:王成虎(13671)
 * time:13:58
 * day:18
 * month:四月
 * function:
 */
public class LoginPresenter extends BasePresenter<LoginContract.LoginView> implements LoginContract.LoginPresenter {

    private LoginModel model;

    @Override
    protected void initModel() {
        model = new LoginModel();
    }

    @Override
    public void login(String email, String pwd) {
        model.login(email, pwd, new LoginContract.Model.LoginResult() {
            @Override
            public void success(LoginBean bean) {
                getView().success(bean);
            }
        });
    }

    @Override
    public void wxLogin(String code) {
        model.wxLogin(code, new LoginContract.Model.LoginResult() {
            @Override
            public void success(LoginBean bean) {
                if (getView()!=null){
                    getView().success(bean);
                }
            }
        });
    }
}
