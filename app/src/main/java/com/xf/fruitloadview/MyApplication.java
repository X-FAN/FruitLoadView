package com.xf.fruitloadview;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by X-FAN on 2016/8/4.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
    }
}
