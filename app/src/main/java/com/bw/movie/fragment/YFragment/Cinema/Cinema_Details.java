package com.bw.movie.fragment.YFragment.Cinema;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.adapter.yyAdapter.Cinema.Details_Adapter;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.bean.yyBean.CineamdeBean;
import com.bw.movie.mvp.yy.Contract.CinemaContract;
import com.bw.movie.mvp.yy.Presenter.CinemaPresenter;

import butterknife.BindView;

/**
 * date:2020/5/10
 * author:王成虎(13671)
 * time:20:18
 * day:10
 * month:五月
 * function:
 */
public class Cinema_Details extends BaseFragment<CinemaPresenter> implements CinemaContract.View {

    @BindView(R.id.cinema_details_recycle)
    RecyclerView cinemaDetailsRecycle;

    @Override
    protected CinemaPresenter initPresenter() {
        return new CinemaPresenter();
    }

    @Override
    protected void initView(View inflate) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        cinemaDetailsRecycle.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected int initLayout() {
        return R.layout.cinema_details_layout;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void success(Object obj) {
        if (obj instanceof CineamdeBean){
            CineamdeBean cineamdeBean = (CineamdeBean)obj;
            CineamdeBean.ResultBean result = cineamdeBean.getResult();
            Details_Adapter adapter = new Details_Adapter(result,getContext());
            cinemaDetailsRecycle.setAdapter(adapter);
        }
    }

    @Override
    public void filter(String msg) {

    }
}
