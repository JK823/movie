package com.bw.movie.mvp.dy.Contract;


import com.bw.movie.base.IBaseView;

public interface HomeContract {
    interface View extends IBaseView {
        void hotSuccess(Object obj);
        void hotFilter(String msg);

        void nowSuccess(Object obj);
        void nowFilter(String msg);

        void ggSuccess(Object obj);
        void ggFilter(String msg);
    }
    interface Model{
        void hot(int page, int count, HotCallBack callBack);
        interface HotCallBack{
            void hotSuccess(Object obj);
            void hotFilter(String msg);
        }
        void now(int page, int count, NowCallBack callBack);
        interface NowCallBack{
            void nowSuccess(Object obj);
            void nowFilter(String msg);
        }
        void gg(int page, int count, GGCallBack callBack);
        interface GGCallBack{
            void ggSuccess(Object obj);
            void ggFilter(String msg);
        }
    }
    interface Presenter{
        void hot(int page, int count);
        void now(int page, int count);
        void gg(int page, int count);
    }
}
