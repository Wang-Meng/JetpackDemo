package com.example.jetpackdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.jetpackdemo.viewmodel.UserViewModel;

public class MainActivity extends AppCompatActivity {
    UserViewModel mUserViewModel;
    Button mGetInfoBtn;
    TextView mNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initViewModel();
    }

    private void initView() {
        mUserViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        mGetInfoBtn = findViewById(R.id.btn_get_user_info);
        mNameTextView = findViewById(R.id.txv_user_name);
        mGetInfoBtn.setOnClickListener((view) -> {
            mUserViewModel.getUserInfo();
        });
    }

    private void initViewModel() {
        //添加此事件观察者，数据更新时自动回调
        mUserViewModel.getUserViewModel().observe(this, userInfo -> {
            mNameTextView.setText("hello," + userInfo.getName());
        });
    }
}
