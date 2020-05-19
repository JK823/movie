package com.bw.movie.util;


public interface Api {
    //接口头
    String BASEURL="http://mobile.bwstudent.com/movieApi/";
    //登录
    String LOGIN ="user/v2/login";
    //注册
    String REGION="user/v2/register";
    //验证码
    String YXYZM="user/v2/sendOutEmailCode";
    //微信登录
    String WXLOGIN="user/v1/weChatBindingLogin";
    //首页热门
    String HOTURL = "movie/v2/findHotMovieList";
    //首页正在
    String NOWURL = "movie/v2/findReleaseMovieList";
    //首页即将
    String GGURL = "movie/v2/findComingSoonMovieList";
    //详情页
    String XQY ="movie/v2/findMoviesDetail";
    //写影评
    String XYP="movie/v1/verify/movieComment";
    //购票下单
    String PLACE = "movie/v2/verify/buyMovieTickets";
    //根据Id查询座位信息
    String SEAT = "movie/v2/findSeatInfo";
    //座位
    String ZW = "movie/v2/findMovieSchedule";
    //支付
    String PAYMENT = "movie/v2/verify/pay";
    //对电影的评论
    String DYPL="user/v2/verify/findMyMovieCommentList";
    //推荐影院
    String RECOMURL = "cinema/v1/findRecommendCinemas";
    //地区
    String LEFTURL ="tool/v2/findRegionList";
    String RIGHTURL = "cinema/v2/findCinemaByRegion";
    //附近影院
    String Nearby = "cinema/v1/findNearbyCinemas";
    //查询影院详情
    String CINEAMDE = "cinema/v1/findCinemaInfo";
}
