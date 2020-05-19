package com.bw.movie.fragment.YFragment;

import android.os.Handler;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.adapter.yyAdapter.RecomAdapter;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.bean.yyBean.RecomBean;
import com.bw.movie.mvp.yy.Contract.RecomContract;
import com.bw.movie.mvp.yy.Presenter.RecomPresenterImpl;

import java.util.List;

import butterknife.BindView;

/**
 * date:2020/4/17
 * author:王成虎(13671)
 * time:10:09
 * day:17
 * month:四月
 * function:推荐影院
 */
public class RecomFragment extends BaseFragment<RecomPresenterImpl> implements RecomContract.View {

    public Handler handler = new Handler();
    @BindView(R.id.tj_rv)
    RecyclerView tjRv;

    @Override
    protected RecomPresenterImpl initPresenter() {
        return new RecomPresenterImpl();
    }

    @Override
    protected void initView(View inflate) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        tjRv.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected int initLayout() {
        return R.layout.yy_tj_layout;
    }

    @Override
    protected void initData() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                presenter.recom(13874,"158587949432613874",1,10);
            }
        });
    }

    @Override
    public void success(Object obj) {
        if (obj instanceof RecomBean) {
            RecomBean recomBean = (RecomBean) obj;
            List<RecomBean.ResultBean> result = recomBean.getResult();
            RecomAdapter adapter = new RecomAdapter(result,getContext());
            tjRv.setAdapter(adapter);
        }
    }

    @Override
    public void filter(String msg) {

    }
}
