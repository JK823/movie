package com.bw.movie.util;


import com.bw.movie.bean.myBean.LoginBean;
import com.bw.movie.bean.myBean.RegionBean;
import com.bw.movie.bean.myBean.SendOutEmailCodeBean;
import com.bw.movie.bean.syBean.Details.DetailsBean;
import com.bw.movie.bean.syBean.Details.MovieCommentBean;
import com.bw.movie.bean.syBean.GGBean;
import com.bw.movie.bean.syBean.HotBean;
import com.bw.movie.bean.syBean.NowBean;
import com.bw.movie.bean.yyBean.CineamdeBean;
import com.bw.movie.bean.yyBean.FjBean;
import com.bw.movie.bean.yyBean.LeftBean;
import com.bw.movie.bean.yyBean.RecomBean;
import com.bw.movie.bean.yyBean.RightBean;
import com.bw.movie.seatselection.bean.BuyMovieTicketsBean;
import com.bw.movie.seatselection.bean.SeatInfoBean;
import com.bw.movie.seatselection.bean.WxPayBean;
import com.bw.movie.seatselection.movieSchedule.MovieScheduleBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * date:2020/4/17
 * author:王成虎(13671)
 * time:14:39
 * day:17
 * month:四月
 * function:
 */
public interface ApiService {

    //登录接口
    @POST(Api.LOGIN)
    @FormUrlEncoded
    Observable<LoginBean> getLogin(@Field("email") String email, @Field("pwd") String pwd);

    //微信登录
    @POST(Api.WXLOGIN)
    @FormUrlEncoded
    Observable<LoginBean> getWxlogin(@Field("code") String code);

    //注册接口
    @POST(Api.REGION)
    @FormUrlEncoded
    Observable<RegionBean> getRegion(@FieldMap Map<String, String> map);

    //验证码
    @POST(Api.YXYZM)
    @FormUrlEncoded
    Observable<SendOutEmailCodeBean> getSebdcode(@Field("email") String email);

    //热门电影
    @GET(Api.HOTURL)
    Observable<HotBean>getHot(@Query("page") int page, @Query("count") int count);

    //正在上映
    @GET(Api.NOWURL)
    Observable<NowBean>getNow(@Query("page") int page, @Query("count") int count);

    //即将上映
    @GET(Api.GGURL)
    Observable<GGBean>getGG(@Query("page") int page, @Query("count") int count);

    //详情页
    @GET(Api.XQY)
    Observable<DetailsBean>getXq(@Header("userId") int userId,
                                 @Header("sessionId") String sessionId,
                                 @Query("movieId") String movieId);

    //写影评
    @POST(Api.XYP)
    @FormUrlEncoded
    Observable<MovieCommentBean> getMovieComment(@Header("userId") int userId,
                                                 @Header("sessionId") String sessionId,
                                                 @Field("movieId") String movieId,
                                                 @Field("commentContent") String commentContent,
                                                 @Field("score") double score);
    //购票下单
    @POST(Api.PLACE)
    @FormUrlEncoded
    Observable<BuyMovieTicketsBean> setbuyMovieTickets(@FieldMap Map<String, String> map);

    //支付
    @POST(Api.PAYMENT)
    @FormUrlEncoded
    Observable<WxPayBean> setPay(@Field("payType") int payType, @Field("orderId") String orderId);

    //根据Id查询座位信息
    @GET(Api.SEAT)
    Observable<SeatInfoBean> getSeatInfo(@Query("hallId") int id);

    //座位
    @GET(Api.ZW)
    Observable<MovieScheduleBean> getMovieSchedule(@QueryMap Map<String, Integer> map);

    //推荐影院
    @GET(Api.RECOMURL)
    Observable<RecomBean> getRecom(@Header("userId") int userId,
                                   @Header("sessionId") String sessionId,
                                   @Query("page") int page,
                                   @Query("count") int count);

    //附近影院
    @GET(Api.Nearby)
    Observable<FjBean> getNearby(@Header("userId") int userId,
                                 @Header("sessionId") String sessionId,
                                 @Query("page") int page,
                                 @Query("count") int count);
    //影院中的左地区
    @GET(Api.LEFTURL)
    Observable<LeftBean>getLeft();

    //影院中的右地区
    @GET(Api.RIGHTURL)
    Observable<RightBean>getRight(@Query("regionId") int regionId);

    //影院详情
    @GET(Api.CINEAMDE)
    Observable<CineamdeBean> getCinde(@Header("userId") int userId,
                                      @Header("sessionId") String sessionId,
                                      @Query("cinemaId") String cinemaId);

}
