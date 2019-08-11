package com.example.jetpackdemo.data;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.example.jetpackdemo.JetPackApp;
import com.example.jetpackdemo.data.database.AppDatabase;
import com.example.jetpackdemo.data.database.entity.User;
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
        //从服务器获取数据
//        Call<BaseResponse<UserInfo>> call = ApiClient.getService().getUserInfo("userName", "password");
//        call.enqueue(new Callback<BaseResponse<UserInfo>>() {
//            @Override
//            public void onResponse(Call<BaseResponse<UserInfo>> call, Response<BaseResponse<UserInfo>> response) {
//                mUserLiveData.setValue(response.body().getData());
//            }
//
//            @Override
//            public void onFailure(Call<BaseResponse<UserInfo>> call, Throwable t) {
//
//            }
//        });

        //从本地数据库获取数据
        AppDatabase appDatabase = AppDatabase.getInstance(JetPackApp.getAppContext());
        User user = new User();
        user.name = "jetPack";
        appDatabase.userDao().insertUsers(user);

        User user1 = appDatabase.userDao().getUserInfo("jetPack");
        Toast.makeText(JetPackApp.getAppContext(), "user name :" + user1.name, Toast.LENGTH_LONG).show();
    }
}
