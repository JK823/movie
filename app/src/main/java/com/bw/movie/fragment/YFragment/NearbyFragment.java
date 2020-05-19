package com.bw.movie.fragment.YFragment;

import android.os.Handler;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.adapter.yyAdapter.FjAdapter;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.bean.yyBean.FjBean;
import com.bw.movie.mvp.yy.Contract.FjContract;
import com.bw.movie.mvp.yy.Presenter.FjPresenter;

import java.util.List;

import butterknife.BindView;

/**
 * date:2020/4/17
 * author:王成虎(13671)
 * time:10:09
 * day:17
 * month:四月
 * function:附近影院
 */
public class NearbyFragment extends BaseFragment<FjPresenter> implements FjContract.View {

    public Handler handler = new Handler();
    @BindView(R.id.fj_rv)
    RecyclerView fjRv;

    @Override
    protected FjPresenter initPresenter() {
        return new FjPresenter();
    }

    @Override
    protected void initView(View inflate) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        fjRv.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected int initLayout() {
        return R.layout.yy_fj_layout;
    }

    @Override
    protected void initData() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                presenter.nearby(13874,"158587949432613874",1,10);
            }
        });
    }

    @Override
    public void success(Object obj) {
        if (obj instanceof FjBean) {
            FjBean fjBean = (FjBean) obj;
            List<FjBean.ResultBean> result = fjBean.getResult();
            FjAdapter adapter = new FjAdapter(result,getContext());
            fjRv.setAdapter(adapter);
        }
    }

    @Override
    public void filter(String msg) {

    }
}
