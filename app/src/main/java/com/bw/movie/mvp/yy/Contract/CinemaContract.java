package com.bw.movie.mvp.yy.Contract;


import com.bw.movie.base.IBaseView;

/**
 * date:2020/5/8
 * author:王成虎(13671)
 * time:15:57
 * day:08
 * month:五月
 * function:
 */
public interface CinemaContract {

    interface View extends IBaseView {
        void success(Object obj);
        void filter(String msg);
    }
    interface Model{
        void cindetails(int userId, String sessionId, String cinemaId, CinemaDeCallBack cinemaDeCallBack);
        interface CinemaDeCallBack{
            void success(Object obj);
            void filter(String msg);
        }
    }
    interface Presenter{
        void cindetails(int userId, String sessionId, String cinemaId);
    }

}
