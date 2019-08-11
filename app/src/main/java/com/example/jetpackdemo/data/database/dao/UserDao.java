package com.example.jetpackdemo.data.database.dao;

import android.database.Cursor;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.jetpackdemo.data.database.entity.Book;
import com.example.jetpackdemo.data.database.entity.User;
import com.example.jetpackdemo.data.database.entity.UserPartInfo;

import java.util.List;

//数据库表操作（增删改查）
@Dao
public interface UserDao {
    /**
     * 增加操作
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertUsers(User... users);

    @Insert
    public void insertBothUsers(User user1, User user2);

    @Insert
    public void insertUsersAndFriends(User user, List<User> friends);


    /**
     * 删除操作
     */
    @Delete
    public void deleteUsers(User... users);


    /**
     *修改操作
     */
    @Update
    public void updateUsers(User... users);




    /**
     *查找操作
     */
    @Query("SELECT * FROM user WHERE name LIKE :userName")
    User getUserInfo(String userName);


    //查询字段的子集，传入参数集合：返回UserPartInfo包含的字段信息
    @Query("SELECT name FROM user WHERE region IN (:regions)")
    public List<String> loadUsersFromRegions(List<String> regions);


    //可直接返回Cursor对象
    @Query("SELECT * FROM user WHERE age > :minAge LIMIT 5")
    public Cursor loadRawUsersOlderThan(int minAge);


//    多表查询
//    @Query("SELECT * FROM book "
//            + "INNER JOIN loan ON loan.book_id = book.id "
//            + "INNER JOIN user ON user.id = loan.user_id "
//            + "WHERE user.name LIKE :userName")
//    public List<Book> findBooksBorrowedByNameSync(String userName);
}
