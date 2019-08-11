package com.example.jetpackdemo.data.database.entity;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "user")
public class User {

    @PrimaryKey
    public int id;

    public String name;

    public String pwd;

    public String region;

    public int age;

    @Ignore
    public String unimportanceContent; //其他不想持久化到数据库中的字段使用@Ignore注解标示

    @Embedded
    public Address address; //@Embedded标签用于其嵌套类型处理，在user表中添加Address类型包含的字段

    public Date birthday;
}
