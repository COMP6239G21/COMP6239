package com.edu.demo.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserBean::class], version = 1, exportSchema = false)
abstract class UserDataBase : RoomDatabase() {
    // 这个函数应返回一个非空的 UserDao
    abstract fun userDao(): UserDao
}
