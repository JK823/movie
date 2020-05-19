package com.bw.movie.mvp.yy.Contract;


import com.bw.movie.base.IBaseView;

/**
 * date:2020/4/17
 * author:王成虎(13671)
 * time:22:14
 * day:17
 * month:四月
 * function:
 */
public interface FjContract {

    interface View extends IBaseView {
        void success(Object obj);
        void filter(String msg);
    }
    interface Model{
        void nearby(int userId, String sessionId, int page, int count, RecomContract.Model.DataCallBack callBack);
        interface DataCallBack{
            void success(Object obj);
            void filter(String msg);
        }
    }
    interface Presenter{
        void nearby(int userId, String sessionId, int page, int count);
    }

}
