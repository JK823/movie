package com.bw.movie.mvp.yy.Presenter;


import com.bw.movie.base.BasePresenter;
import com.bw.movie.mvp.yy.Contract.CinemaContract;
import com.bw.movie.mvp.yy.Model.CinemaModel;

/**
 * date:2020/5/8
 * author:王成虎(13671)
 * time:15:58
 * day:08
 * month:五月
 * function:
 */
public class CinemaPresenter extends BasePresenter<CinemaContract.View> implements CinemaContract.Presenter {

    private CinemaModel model;

    @Override
    protected void initModel() {
        model = new CinemaModel();
    }

    @Override
    public void cindetails(int userId, String sessionId, String  cinemaId) {

        model.cindetails(userId, sessionId, cinemaId, new CinemaContract.Model.CinemaDeCallBack() {
            @Override
            public void success(Object obj) {
                getView().success(obj);
            }

            @Override
            public void filter(String msg) {
                getView().filter(msg);
            }
        });

    }
}
