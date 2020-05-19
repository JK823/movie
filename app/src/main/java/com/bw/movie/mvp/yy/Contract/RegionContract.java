package com.bw.movie.mvp.yy.Contract;


import com.bw.movie.base.IBaseView;

public interface RegionContract {
    interface View extends IBaseView {
        void leftSuccess(Object obj);
        void leftFilter(String msg);

        void rightSuccess(Object obj);
        void rightFilter(String msg);
    }
    interface Model{
        void left(LeftCallBack callBack);
        interface LeftCallBack{
            void leftSuccess(Object obj);
            void leftFilter(String msg);
        }
        void right(int regionId, RightCallBack callBack);
        interface RightCallBack{
            void rightSuccess(Object obj);
            void rightFilter(String msg);
        }
    }
    interface Presenter{
        void left();
        void right(int regionId);
    }
}
