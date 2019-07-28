package com.example.jetpackdemo.net;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Retrofit接口
 */
public interface WebService {
    // 获取用户信息
    @GET("user_info")
    Call<BaseResponse<UserInfo>> getUserInfo(@Query("userName") String userName, @Query("password") String password);
}
