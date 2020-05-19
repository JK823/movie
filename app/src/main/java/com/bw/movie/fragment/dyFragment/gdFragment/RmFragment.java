package com.bw.movie.fragment.dyFragment.gdFragment;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.adapter.dyAdapter.MoreAdapter.RmAdapter;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.bean.syBean.NowBean;
import com.bw.movie.mvp.dy.Contract.HomeContract;
import com.bw.movie.mvp.dy.Presenter.HomePresenterImpl;

import java.util.List;

import butterknife.BindView;

/**
 * date:2020/4/21
 * author:王成虎(13671)
 * time:20:25
 * day:21
 * month:四月
 * function:
 */
public class RmFragment extends BaseFragment<HomePresenterImpl> implements HomeContract.View {


    @BindView(R.id.rm_recycle)
    RecyclerView rmRecycle;

    @Override
    protected HomePresenterImpl initPresenter() {
        return new HomePresenterImpl();
    }

    @Override
    protected void initView(View inflate) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rmRecycle.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected int initLayout() {
        return R.layout.gd_rm_layout;
    }

    @Override
    protected void initData() {
        presenter.now(1, 5);
    }

    @Override
    public void hotSuccess(Object obj) {

    }

    @Override
    public void hotFilter(String msg) {

    }

    @Override
    public void nowSuccess(Object obj) {
        if (obj instanceof NowBean) {
            NowBean nowBean = (NowBean) obj;
            List<NowBean.ResultBean> result = nowBean.getResult();
            RmAdapter adapter = new RmAdapter(result, getContext());
            rmRecycle.setAdapter(adapter);
        }
    }

    @Override
    public void nowFilter(String msg) {

    }

    @Override
    public void ggSuccess(Object obj) {

    }

    @Override
    public void ggFilter(String msg) {

    }

}
