package com.bw.movie.base;

import java.lang.ref.WeakReference;

/**
 * date:2020/4/17
 * author:王成虎(13671)
 * time:10:01
 * day:17
 * month:四月
 * function:
 */
public abstract class BasePresenter <V extends IBaseView> {

    public WeakReference<V>weakReference;
    public BasePresenter() {
        initModel();
    }
    public void attach(V v){
        weakReference = new WeakReference<>(v);
    }
    public void deatch(){
        if (weakReference!=null){
            weakReference.clear();
            weakReference=null;
        }
    }
    protected abstract void initModel();
    public V getView(){
        V v = weakReference.get();
        return v;
    }
}
