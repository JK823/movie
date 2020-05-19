package com.bw.movie.mvp.yy.Presenter;


import com.bw.movie.base.BasePresenter;
import com.bw.movie.mvp.yy.Contract.RegionContract;
import com.bw.movie.mvp.yy.Model.RegionModelImpl;

public class RegionPresenterImpl extends BasePresenter<RegionContract.View> implements RegionContract.Presenter {

    private RegionModelImpl model;

    @Override
    protected void initModel() {
        model = new RegionModelImpl();
    }

    @Override
    public void left() {
        model.left(new RegionContract.Model.LeftCallBack() {
            @Override
            public void leftSuccess(Object obj) {
                getView().leftSuccess(obj);
            }

            @Override
            public void leftFilter(String msg) {
                getView().leftFilter(msg);
            }
        });
    }

    @Override
    public void right(int regionId) {
        model.right(regionId, new RegionContract.Model.RightCallBack() {
            @Override
            public void rightSuccess(Object obj) {
                getView().rightSuccess(obj);
            }

            @Override
            public void rightFilter(String msg) {
                getView().rightFilter(msg);
            }
        });
    }
}
