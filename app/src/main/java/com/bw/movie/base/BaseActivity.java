package com.bw.movie.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * date:2020/4/17
 * author:王成虎(13671)
 * time:10:00
 * day:17
 * month:四月
 * function:
 */
public abstract class BaseActivity <P extends BasePresenter> extends AppCompatActivity implements IBaseView {

    public P presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        presenter = initPresenter();
        if (presenter!=null) {
            presenter.attach(this);
        }
        ButterKnife.bind(this);
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract P initPresenter();

    protected abstract void initView();

    protected abstract int initLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter!=null) {
            presenter.deatch();
        }
    }


}
