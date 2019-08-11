package com.example.jetpackdemo.data.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

/**
 * 添加外键进行表关联（支持指定被关联的entity更新时做什么操作（级联删除））
 */
@Entity(foreignKeys = @ForeignKey(entity = User.class,
        parentColumns = "id",
        childColumns = "user_id"))
public class Book {
    @PrimaryKey
    public int id;

    @ColumnInfo(name = "book_name")
    public String bookName;

    @ColumnInfo(name = "user_id")
    public int userId;
}
