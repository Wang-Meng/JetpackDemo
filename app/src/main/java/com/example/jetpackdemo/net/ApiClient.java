package com.example.jetpackdemo.net;

import com.example.jetpackdemo.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String DEBUG_URL = ""; //测试版本服务器地址
    private static final String RELEASE_URL = ""; //正式版本服务器地址
    private static final String HOST_URL = BuildConfig.DEBUG ? DEBUG_URL : RELEASE_URL;
    private static final long NET_TIME_OUT_TIMES = 5 * 1000; //超时时间5s

    private volatile static OkHttpClient sOkHttpClient;
    private volatile static Retrofit sRetrofit;

    private static final class ServiceHolder {
//        private static final WebService SERVICE = getRetrofit().create(WebService.class);
    }

    public static WebService getService() {
//        return ServiceHolder.SERVICE;
        return null;
    }

    private static Retrofit getRetrofit() {
        if (sRetrofit == null) {
            synchronized (ApiClient.class) {
                if (sRetrofit == null) {
                    sRetrofit = new Retrofit.Builder()
                            .baseUrl(HOST_URL)
                            .client(getClient())
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                }
            }
        }
        return sRetrofit;
    }

    private static OkHttpClient getClient() {
        if (sOkHttpClient == null) {
            synchronized (ApiClient.class) {
                if (sOkHttpClient == null) {
                    sOkHttpClient = new OkHttpClient.Builder()
                            .connectTimeout(NET_TIME_OUT_TIMES, TimeUnit.MILLISECONDS)
                            .build();
                }
            }
        }
        return sOkHttpClient;
    }
}
