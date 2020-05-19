package com.bw.movie.mvp.yy.Contract;


import com.bw.movie.base.IBaseView;

public interface RecomContract {
    interface View extends IBaseView {
        void success(Object obj);
        void filter(String msg);
    }
    interface Model{
        void recom(int userId, String sessionId, int page, int count, DataCallBack callBack);
        interface DataCallBack{
            void success(Object obj);
            void filter(String msg);
        }
    }
    interface Presenter{
        void recom(int userId, String sessionId, int page, int count);
    }
}
