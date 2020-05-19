package com.bw.movie.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;

/**
 * date:2020/4/17
 * author:王成虎(13671)
 * time:10:01
 * day:17
 * month:四月
 * function:
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements IBaseView {

    protected P presenter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(initLayout(), null);
        presenter = initPresenter();
        if (presenter!=null) {
            presenter.attach(this);
        }
        ButterKnife.bind(this,inflate);
        initView(inflate);
        return inflate;
    }

    protected abstract P initPresenter();

    protected abstract void initView(View inflate);

    protected abstract int initLayout();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    protected abstract void initData();



    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter!=null) {
            presenter.deatch();
        }
    }

}
