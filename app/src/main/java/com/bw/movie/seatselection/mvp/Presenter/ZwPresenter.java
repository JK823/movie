package com.bw.movie.seatselection.mvp.Presenter;


import com.bw.movie.base.BasePresenter;
import com.bw.movie.seatselection.mvp.Contract.XzContract;
import com.bw.movie.seatselection.mvp.Model.XzModel;

import java.util.HashMap;
import java.util.Map;

/**
 * date:2020/5/7
 * author:王成虎(13671)
 * time:21:57
 * day:07
 * month:五月
 * function:
 */
public class ZwPresenter extends BasePresenter<XzContract.View> implements XzContract.Presenter {

    private XzModel model;

    @Override
    protected void initModel() {
        model = new XzModel();
    }

    @Override
    public void movieSchedule(int movieId, int cinemaId) {
        model.movieSchedule(movieId, cinemaId, new XzContract.Model.Result() {
            @Override
            public void success(Object object) {
                if (getView() != null) {
                    getView().success(object);
                }
            }
        });
    }

    @Override
    public void seatInfo(int hallId) {
        model.seatInfo(hallId, new XzContract.Model.Result() {
            @Override
            public void success(Object object) {
                if (getView() != null) {
                    getView().success(object);
                }
            }
        });
    }

    @Override
    public void buyMovieTickets(String scheduleId, String seat, String sign) {
        Map<String, String> map = new HashMap<>();
        map.put("scheduleId", scheduleId);
        map.put("seat", seat);
        map.put("sign", sign);
        model.buyMovieTickets(map, new XzContract.Model.Result() {
            @Override
            public void success(Object object) {
                if (getView() != null) {
                    getView().success(object);
                }
            }
        });
    }

    @Override
    public void setPay(int payType, String orderId) {
        model.setPay(payType, orderId, new XzContract.Model.Result() {
            @Override
            public void success(Object object) {
                if (getView() != null) {
                    getView().success(object);
                }
            }
        });
    }
}
