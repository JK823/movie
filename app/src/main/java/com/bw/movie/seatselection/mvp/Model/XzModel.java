package com.bw.movie.seatselection.mvp.Model;


import com.bw.movie.base.BaseModel;
import com.bw.movie.seatselection.bean.BuyMovieTicketsBean;
import com.bw.movie.seatselection.bean.SeatInfoBean;
import com.bw.movie.seatselection.bean.WxPayBean;
import com.bw.movie.seatselection.movieSchedule.MovieScheduleBean;
import com.bw.movie.seatselection.mvp.Contract.XzContract;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;

/**
 * date:2020/5/7
 * author:王成虎(13671)
 * time:21:21
 * day:07
 * month:五月
 * function:
 */
public class XzModel extends BaseModel implements XzContract.Model {
    @Override
    public void movieSchedule(int movieId, int cinemaId, Result result) {
        Map<String,Integer> map = new HashMap<>();
        map.put("movieId",movieId);
        map.put("cinemaId",cinemaId);
        Observable<MovieScheduleBean> observable = apiService.getMovieSchedule(map);
        requestData(observable, new hehe() {
            @Override
            public void success(Object object) {
                result.success(object);
            }

            @Override
            public void error(String message) {
            }
        });
    }

    @Override
    public void seatInfo(int hallId, Result result) {
        Observable<SeatInfoBean> observable = apiService.getSeatInfo(hallId);
        requestData(observable, new hehe() {
            @Override
            public void success(Object object) {
                result.success(object);
            }

            @Override
            public void error(String message) {
                ;
            }
        });
    }

    @Override
    public void buyMovieTickets(Map<String, String> map, Result result) {
        Observable<BuyMovieTicketsBean> observable = apiService.setbuyMovieTickets(map);
        requestData(observable, new hehe() {
            @Override
            public void success(Object object) {
                result.success(object);
            }

            @Override
            public void error(String message) {
            }
        });
    }

    @Override
    public void setPay(int payType, String orderId, Result result) {

        Observable<WxPayBean> observable = apiService.setPay(payType,orderId);
        requestData(observable, new hehe() {
            @Override
            public void success(Object object) {
                result.success(object);
            }

            @Override
            public void error(String message) {
            }
        });

    }
}
