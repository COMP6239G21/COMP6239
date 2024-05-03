package com.edu.demo.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *
 * user 实体
 */
@Entity(tableName = "user_info")
class UserBean {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0;

    @ColumnInfo(name = "user_name")
    var name: String? = ""
    @ColumnInfo(name = "email")
    var email: String? = ""
    @ColumnInfo(name = "password")
    var pwd: String? = ""


}