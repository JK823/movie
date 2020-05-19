package com.bw.movie.mvp.yy.Presenter;


import com.bw.movie.base.BasePresenter;
import com.bw.movie.mvp.yy.Contract.RecomContract;
import com.bw.movie.mvp.yy.Model.RecomModelImpl;

public class RecomPresenterImpl extends BasePresenter<RecomContract.View> implements RecomContract.Presenter {

    private RecomModelImpl model;

    @Override
    protected void initModel() {
        model = new RecomModelImpl();
    }

    @Override
    public void recom(int userId, String sessionId, int page, int count) {
        model.recom(userId, sessionId, page, count, new RecomContract.Model.DataCallBack() {
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
