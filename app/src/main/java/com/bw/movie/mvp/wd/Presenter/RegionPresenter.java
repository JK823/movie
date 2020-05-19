package com.bw.movie.mvp.wd.Presenter;


import com.bw.movie.base.BasePresenter;
import com.bw.movie.bean.myBean.RegionBean;
import com.bw.movie.bean.myBean.SendOutEmailCodeBean;
import com.bw.movie.mvp.wd.Contract.LoginContract;
import com.bw.movie.mvp.wd.Model.LoginModel;

import java.util.HashMap;
import java.util.Map;

/**
 * date:2020/4/18
 * author:王成虎(13671)
 * time:15:39
 * day:18
 * month:四月
 * function:
 */
public class RegionPresenter extends BasePresenter<LoginContract.RegisterView> implements LoginContract.RegisterPresenter {

    private LoginModel model;

    @Override
    protected void initModel() {
        model = new LoginModel();
    }

    @Override
    public void register(String nickName, String pwd, String eamil, String code) {
        Map<String,String> map = new HashMap<>();
        map.put("nickName",nickName);
        map.put("pwd",pwd);
        map.put("email",eamil);
        map.put("code",code);
        model.register(map, new LoginContract.Model.RegisterResult() {
            @Override
            public void success(RegionBean bean) {
                getView().success(bean);
            }
        });
    }

    @Override
    public void code(String email) {

        model.code(email, new LoginContract.Model.CodeResult() {
            @Override
            public void success(SendOutEmailCodeBean bean) {
                getView().codeSuccess(bean);
            }
        });

    }
}
