package com.edu.demo.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface UserDao {
    @Insert
    fun insertUser(userBean: UserBean?)

    @Query("SELECT * FROM user_info WHERE user_name = :name or email = :email")
    fun queryUser(name: String?, email: String?): UserBean?

    @Query("SELECT * FROM user_info")
    fun queryAll(): List<UserBean?>?
}
