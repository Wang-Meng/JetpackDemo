package com.example.jetpackdemo.data.database.converters;

import android.database.Cursor;

import androidx.room.TypeConverter;

import com.example.jetpackdemo.data.database.entity.UserPartInfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 类型转换器
 * 支持自定义数据类型转化为Room能够持久化的数据类型
 */
public class Converters {
    /**
     *将时间戳转化为Date类型
     *需要将 @Converters 注解添加到AppDatabase类中，
     * 这样Room就可以把你定义的这个converter用到entity和DAO中
     */
    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    /**
     *将Data类型数据转化为时间戳类型
     */
    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }


//    @TypeConverter
//    public static List<UserPartInfo> fromCursor(Cursor cursor) {
//        List<UserPartInfo> userPartInfos = new ArrayList<>();
//        while (cursor.moveToNext()) {
//            cursor.getString();
//        }
//        return
//    }
}
