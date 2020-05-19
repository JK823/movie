package com.bw.movie.util;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitUtil {
    public OkHttpClient okHttpClient;
    public Retrofit retrofit;
    public static RetrofitUtil instance = null;
    private RetrofitUtil(){
        retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(
                        okHttpClient = new OkHttpClient.Builder()
                                .readTimeout(5, TimeUnit.SECONDS)
                                .connectTimeout(5,TimeUnit.SECONDS)
                                .writeTimeout(5,TimeUnit.SECONDS)
                                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                                .build()
                )
                .build();

    }
    public static synchronized RetrofitUtil getInstance(){
        if (instance==null){
            instance = new RetrofitUtil();
        }
        return instance;
    }

    public boolean newWorkInfo(){
        ConnectivityManager manager = (ConnectivityManager) AppContext.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if (networkInfo!=null){
            return networkInfo.isConnected();
        }
        return false;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public ApiService createService(){
        ApiService apiService = retrofit.create(ApiService.class);
        return apiService;
    }

}
