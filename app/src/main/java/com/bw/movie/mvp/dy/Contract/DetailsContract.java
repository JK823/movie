package com.bw.movie.mvp.dy.Contract;


import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.syBean.Details.MovieCommentBean;

/**
 * date:2020/4/24
 * author:王成虎(13671)
 * time:15:37
 * day:24
 * month:四月
 * function:
 */
public interface DetailsContract {

    interface View extends IBaseView {

        void detasuccess(Object obj);
        void detaFilter(String msg);

    }

    interface MovieCommentView extends IBaseView {
        void movieCommentSuccess(MovieCommentBean bean);
        void movieCommentError(String msg);
    }

   interface Model{

        void deta(int userId, String sessionId, String movieId, DetaCallBack callBack);
        interface DetaCallBack{

            void detasuccess(Object obj);
            void detaFilter(String msg);

        }

       void movieComment(int userId, String sessionId, String movieId, String commentContent, double score, movieCommentResult result);
       interface movieCommentResult{
           void movieCommentSuccess(MovieCommentBean bean);
           void movieCommentError(String msg);
       }

   }

   interface Presenter{
        void deta(int userId, String sessionId, String movieId);

   }

    interface MovieCommentPresenter {
        void movieComment(int userId, String sessionId, String movieId, String commentContent, double score);
    }

}

