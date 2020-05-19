package com.bw.movie.mvp.dy.Presenter;


import com.bw.movie.base.BasePresenter;
import com.bw.movie.mvp.dy.Contract.DetailsContract;
import com.bw.movie.mvp.dy.Model.DetailsModel;

/**
 * date:2020/4/24
 * author:王成虎(13671)
 * time:15:41
 * day:24
 * month:四月
 * function:
 */
public class DetailsPresenter extends BasePresenter<DetailsContract.View> implements DetailsContract.Presenter {

    private DetailsModel model;

    @Override
    protected void initModel() {
        model = new DetailsModel();
    }

    @Override
    public void deta(int userId, String sessionId, String movieId) {
        model.deta(userId, sessionId, movieId, new DetailsContract.Model.DetaCallBack() {
            @Override
            public void detasuccess(Object obj) {
                getView().detasuccess(obj);
            }

            @Override
            public void detaFilter(String msg) {
                getView().detaFilter(msg);
            }
        });
    }


}
