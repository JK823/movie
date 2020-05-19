package com.bw.movie.seatselection.mvp.Contract;


import com.bw.movie.base.IBaseView;

import java.util.Map;

/**
 * date:2020/5/7
 * author:王成虎(13671)
 * time:21:20
 * day:07
 * month:五月
 * function:
 */
public interface XzContract {

    interface View extends IBaseView {
        void success(Object object);
    }

    interface Model{
        void movieSchedule(int movieId, int cinemaId, Result result);
        void seatInfo(int hallId, Result result);
        void buyMovieTickets(Map<String, String> map, Result result);
        void setPay(int payType, String orderId, Result result);
        interface Result{
            void success(Object object);
        }
    }

    interface Presenter{
        void movieSchedule(int movieId, int cinemaId);
        void seatInfo(int hallId);
        void buyMovieTickets(String scheduleId, String seat, String sign);
        void setPay(int payType, String orderId);
    }

}
