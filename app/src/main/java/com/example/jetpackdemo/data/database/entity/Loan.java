package com.example.jetpackdemo.data.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "loan")
public class Loan {
    @PrimaryKey
    public int id;

    @ColumnInfo(name = "book_id")
    public int bookId;

    @ColumnInfo(name = "user_id")
    int userId;
}
