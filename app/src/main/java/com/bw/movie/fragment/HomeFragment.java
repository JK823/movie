package com.bw.movie.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.activity.MoreActivity;
import com.bw.movie.adapter.dyAdapter.GGAdapter;
import com.bw.movie.adapter.dyAdapter.HotAdapter;
import com.bw.movie.adapter.dyAdapter.NowAdapter;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.bean.syBean.GGBean;
import com.bw.movie.bean.syBean.HotBean;
import com.bw.movie.bean.syBean.NowBean;
import com.bw.movie.mvp.dy.Contract.HomeContract;
import com.bw.movie.mvp.dy.Presenter.HomePresenterImpl;
import com.stx.xhb.xbanner.XBanner;

import java.util.List;

import butterknife.BindView;

/**
 * date:2020/4/16
 * author:王成虎(13671)
 * time:21:23
 * day:16
 * month:四月
 * function:
 */
public class HomeFragment extends BaseFragment<HomePresenterImpl> implements HomeContract.View {


    @BindView(R.id.sy_dz)
    ImageView syDz;
    @BindView(R.id.sy_jt)
    TextView syJt;
    @BindView(R.id.sy_ss)
    ImageView sySs;
    @BindView(R.id.sy_xBanner)
    XBanner syXBanner;
    @BindView(R.id.rv1)
    RecyclerView rv1;
    @BindView(R.id.rv2)
    RecyclerView rv2;
    @BindView(R.id.rv3)
    RecyclerView rv3;
    @BindView(R.id.ry_gd)
    TextView ryGd;
    @BindView(R.id.sy_gd)
    TextView syGd;
    @BindView(R.id.rm_gd)
    TextView rmGd;

    @Override
    protected HomePresenterImpl initPresenter() {
        return new HomePresenterImpl();
    }

    @SuppressLint("WrongConstant")
    @Override
    protected void initView(View inflate) {

        ryGd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MoreActivity.class);
                startActivity(intent);
            }
        });

        syGd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MoreActivity.class);
                startActivity(intent);
            }
        });

        rmGd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MoreActivity.class);
                startActivity(intent);
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv1.setLayoutManager(linearLayoutManager);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext());
        linearLayoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
        rv2.setLayoutManager(linearLayoutManager1);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getContext());
        linearLayoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv3.setLayoutManager(linearLayoutManager2);
    }

    @Override
    protected int initLayout() {
        return R.layout.sy_layout;
    }

    @Override
    protected void initData() {
        presenter.hot(1, 5);
        presenter.now(1, 5);
        presenter.gg(1, 5);
    }

    @Override
    public void hotSuccess(Object obj) {
        if (obj instanceof HotBean) {
            HotBean hotBean = (HotBean) obj;
            List<HotBean.ResultBean> result = hotBean.getResult();
            HotAdapter adapter = new HotAdapter(result, getContext());
            rv1.setAdapter(adapter);
        }
    }

    @Override
    public void hotFilter(String msg) {

    }

    @Override
    public void nowSuccess(Object obj) {
        if (obj instanceof NowBean) {
            NowBean nowBean = (NowBean) obj;
            List<NowBean.ResultBean> result = nowBean.getResult();
            NowAdapter adapter = new NowAdapter(result, getContext());
            rv3.setAdapter(adapter);
        }
    }

    @Override
    public void nowFilter(String msg) {

    }

    @Override
    public void ggSuccess(Object obj) {
        if (obj instanceof GGBean) {
            GGBean ggBean = (GGBean) obj;
            List<GGBean.ResultBean> result = ggBean.getResult();
            GGAdapter adapter = new GGAdapter(result, getContext());
            rv2.setAdapter(adapter);
        }
    }

    @Override
    public void ggFilter(String msg) {

    }
}
