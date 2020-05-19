package com.bw.movie.mvp.yy.Presenter;


import com.bw.movie.base.BasePresenter;
import com.bw.movie.mvp.yy.Contract.FjContract;
import com.bw.movie.mvp.yy.Contract.RecomContract;
import com.bw.movie.mvp.yy.Model.FjModel;

/**
 * date:2020/4/17
 * author:王成虎(13671)
 * time:22:20
 * day:17
 * month:四月
 * function:
 */
public class FjPresenter extends BasePresenter<FjContract.View> implements FjContract.Presenter {

    private FjModel model;

    @Override
    protected void initModel() {
        model = new FjModel();
    }

    @Override
    public void nearby(int userId, String sessionId, int page, int count) {
        model.nearby(userId, sessionId, page, count, new RecomContract.Model.DataCallBack() {
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
