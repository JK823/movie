package com.bw.movie.mvp.wd.Contract;


import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.myBean.LoginBean;
import com.bw.movie.bean.myBean.RegionBean;
import com.bw.movie.bean.myBean.SendOutEmailCodeBean;

import java.util.Map;

/**
 * date:2020/4/18
 * author:王成虎(13671)
 * time:13:57
 * day:18
 * month:四月
 * function:
 */
public interface LoginContract {

    interface LoginView extends IBaseView {
        void success(LoginBean bean);
    }

    interface RegisterView extends IBaseView {
        void success(RegionBean bean);
        void codeSuccess(SendOutEmailCodeBean bean);
    }

    interface Model{
        void login(String email, String pwd, LoginResult result);
        interface LoginResult{
            void success(LoginBean bean);
        }

        void wxLogin(String code, LoginResult result);

        void register(Map<String, String> map, RegisterResult result);
        interface RegisterResult{
            void success(RegionBean bean);
        }

        void code(String email, CodeResult result);
        interface CodeResult{
            void success(SendOutEmailCodeBean bean);
        }
    }

    interface LoginPresenter{
        void login(String email, String pwd);
        void wxLogin(String code);
    }

    interface RegisterPresenter{
        void register(String nickName, String pwd, String eamil, String code);
        void code(String email);
    }

}
