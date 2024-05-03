package com.edu.demo.db

import android.content.Context
import androidx.room.Room

/**
 * 数据库工具类
 */
class DbManager private constructor() {
    lateinit var userDataBase: UserDataBase

    init {

    }

    fun init(context: Context) {
        userDataBase = Room.databaseBuilder(context, UserDataBase::class.java, "user_db")
            .fallbackToDestructiveMigration().allowMainThreadQueries().build()
    }

    companion object {
        private val util by lazy(LazyThreadSafetyMode.SYNCHRONIZED) { DbManager() }
        fun get(): DbManager = util
    }

    fun insertData(userBean: UserBean) {
        userDataBase.userDao().insertUser(userBean)
    }

    /**
     * 获取数据库中是否有该用户
     */
    fun queryUser(name: String, phone: String): UserBean? {
        return userDataBase.userDao().queryUser(name, phone)
    }

    fun queryAllUserCount(): Int {
        return queryAllUser().size
    }

    fun queryAllUser(): List<UserBean> {
        val list: List<UserBean?>? = userDataBase.userDao().queryAll()
        return list?.filterNotNull() ?: emptyList()
    }

}