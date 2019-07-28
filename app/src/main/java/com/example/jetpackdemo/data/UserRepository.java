package com.example.jetpackdemo.data;

import androidx.lifecycle.MutableLiveData;

import com.example.jetpackdemo.net.ApiClient;
import com.example.jetpackdemo.net.BaseResponse;
import com.example.jetpackdemo.net.UserInfo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {
    private final MutableLiveData<UserInfo> mUserLiveData = new MutableLiveData<>();
    private UserRepository() {}

    private static final class RepoHlder {
        private static final UserRepository INSTANCE = new UserRepository();
    }

    public static UserRepository getInstance() {
        return RepoHlder.INSTANCE;
    }

    public MutableLiveData<UserInfo> getUserLiveData() {
        return mUserLiveData;
    }

    public void getUserInfo() {
        Call<BaseResponse<UserInfo>> call = ApiClient.getService().getUserInfo("userName", "password");
        call.enqueue(new Callback<BaseResponse<UserInfo>>() {
            @Override
            public void onResponse(Call<BaseResponse<UserInfo>> call, Response<BaseResponse<UserInfo>> response) {
                mUserLiveData.setValue(response.body().getData());
            }

            @Override
            public void onFailure(Call<BaseResponse<UserInfo>> call, Throwable t) {

            }
        });
    }
}
