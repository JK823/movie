package com.bw.movie.util;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.facebook.drawee.backends.pipeline.Fresco;

public class AppContext extends Application {
    public static Context context;
    public static SharedPreferences preferences;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        preferences = getSharedPreferences("userData", MODE_PRIVATE);
        FrescoUtils.initFresco();
        Fresco.initialize(this);

    }


}
