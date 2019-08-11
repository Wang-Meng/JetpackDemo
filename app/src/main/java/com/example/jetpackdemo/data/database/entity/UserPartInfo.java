package com.example.jetpackdemo.data.database.entity;

import androidx.room.ColumnInfo;


public class UserPartInfo {
    @ColumnInfo(name = "user_name")
    public String userName;

    public String pwd;
}
