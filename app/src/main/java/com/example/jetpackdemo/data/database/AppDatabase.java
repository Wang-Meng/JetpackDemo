package com.example.jetpackdemo.data.database;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.jetpackdemo.data.database.converters.Converters;
import com.example.jetpackdemo.data.database.dao.UserDao;
import com.example.jetpackdemo.data.database.entity.User;

@TypeConverters(Converters.class)
@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static final String TAG = "AppDatabase";
    private static final String DB_NAME = "jetpack_test";
    private static volatile AppDatabase sInstance;

    /**
     * 用于数据库更新（通常指数据表结构更新，插入或删除表）时执行的操作,类似于onUpgrade函数功能功能
     * 此处表示数据库版本号从1升到2所做的更改
     */
    private static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            //用于数据库表更新时执行的sql操作（此处为在名称为“user”的表中插入名称为“sex”的一列）
            database.execSQL("ALTER TABLE " + "user" + " ADD COLUMN sex TEXT");
        }
    };

    public static AppDatabase getInstance(final Context context) {
        if (sInstance == null) {
            synchronized (AppDatabase.class) {
                if (sInstance == null) {
                    sInstance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, DB_NAME)
                            .addCallback(new Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                    Log.i(TAG, "DB onCreate");
                                }

                                @Override
                                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                                    super.onOpen(db);
                                    Log.i(TAG, "DB onOpen");
                                }
                            })
                            .addMigrations(MIGRATION_1_2)
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return sInstance;
    }


    public abstract UserDao userDao();
}
