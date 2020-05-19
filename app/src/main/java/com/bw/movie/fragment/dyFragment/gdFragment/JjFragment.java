package com.bw.movie.fragment.dyFragment.gdFragment;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.adapter.dyAdapter.MoreAdapter.JJAdapter;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.bean.syBean.GGBean;
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
public class JjFragment extends BaseFragment<HomePresenterImpl> implements HomeContract.View {

    @BindView(R.id.jj_recycle)
    RecyclerView jjRecycle;

    @Override
    protected HomePresenterImpl initPresenter() {
        return new HomePresenterImpl();
    }

    @Override
    protected void initView(View inflate) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        jjRecycle.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected int initLayout() {
        return R.layout.gd_jj_layout;
    }

    @Override
    protected void initData() {
        presenter.gg(1, 5);
    }

    @Override
    public void hotSuccess(Object obj) {

    }

    @Override
    public void hotFilter(String msg) {

    }

    @Override
    public void nowSuccess(Object obj) {

    }

    @Override
    public void nowFilter(String msg) {

    }

    @Override
    public void ggSuccess(Object obj) {
        if (obj instanceof GGBean) {
            GGBean ggBean = (GGBean) obj;
            List<GGBean.ResultBean> result = ggBean.getResult();
            JJAdapter adapter = new JJAdapter(result, getContext());
            jjRecycle.setAdapter(adapter);
        }
    }

    @Override
    public void ggFilter(String msg) {

    }

}
