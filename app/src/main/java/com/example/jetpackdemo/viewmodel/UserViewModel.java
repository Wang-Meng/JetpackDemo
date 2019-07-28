package com.example.jetpackdemo.viewmodel;

import androidx.lifecycle.LiveData;

import com.example.jetpackdemo.data.UserRepository;
import com.example.jetpackdemo.net.UserInfo;

public class UserViewModel extends BaseViewModel {
    private UserRepository mUserRepository;

    public UserViewModel() {
        mUserRepository = UserRepository.getInstance();
    }

    public LiveData<UserInfo> getUserViewModel() {
        return mUserRepository.getUserLiveData();
    }

    public void getUserInfo() {
        mUserRepository.getUserInfo();
    }

}
