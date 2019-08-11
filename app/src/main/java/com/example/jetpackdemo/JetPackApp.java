package com.example.jetpackdemo;

import android.app.Application;
import android.content.Context;

public class JetPackApp extends Application {
    static Context sAppContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sAppContext = this;
    }

    public static Context getAppContext() {
        return sAppContext;
    }

}
