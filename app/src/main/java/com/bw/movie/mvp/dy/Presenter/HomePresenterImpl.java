package com.bw.movie.mvp.dy.Presenter;


import com.bw.movie.base.BasePresenter;
import com.bw.movie.mvp.dy.Contract.HomeContract;
import com.bw.movie.mvp.dy.Model.HomeModelImpl;

public class HomePresenterImpl extends BasePresenter<HomeContract.View> implements HomeContract.Presenter {

    private HomeModelImpl model;

    @Override
    protected void initModel() {
        model = new HomeModelImpl();
    }

    @Override
    public void hot(int page, int count) {
        model.hot(page, count, new HomeContract.Model.HotCallBack() {
            @Override
            public void hotSuccess(Object obj) {
                getView().hotSuccess(obj);
            }

            @Override
            public void hotFilter(String msg) {
                getView().hotFilter(msg);
            }
        });
    }

    @Override
    public void now(int page, int count) {
        model.now(page, count, new HomeContract.Model.NowCallBack() {
            @Override
            public void nowSuccess(Object obj) {
                getView().nowSuccess(obj);
            }

            @Override
            public void nowFilter(String msg) {
                getView().nowFilter(msg);
            }
        });
    }

    @Override
    public void gg(int page, int count) {
        model.gg(page, count, new HomeContract.Model.GGCallBack() {
            @Override
            public void ggSuccess(Object obj) {
                getView().ggSuccess(obj);
            }

            @Override
            public void ggFilter(String msg) {
                getView().ggFilter(msg);
            }
        });
    }
}
