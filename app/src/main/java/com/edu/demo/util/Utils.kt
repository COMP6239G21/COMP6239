package com.edu.demo.util

import android.content.Context
import android.widget.Toast
import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException


class Utils {
    private var context: Context? = null
    fun init(context: Context) {
        this.context = context;
    }

    companion object {
        private val util by lazy(LazyThreadSafetyMode.SYNCHRONIZED) { Utils() }
        fun get(): Utils = util
    }

    fun getMD5Hash(input: String): String {
        try {
            // 创建MD5哈希算法实例
            val md = MessageDigest.getInstance("MD5")
            // 计算输入字符串的MD5哈希值
            val hashBytes = md.digest(input.toByteArray())
            // 将哈希值转换为32位的十六进制表示
            val bigInt = BigInteger(1, hashBytes)
            val md5Hash = StringBuilder(bigInt.toString(16))
            // 如果十六进制表示长度不足32位，前面补0
            while (md5Hash.length < 32) {
                md5Hash.insert(0, "0")
            }
            return md5Hash.toString()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }
        return ""
    }

    fun toast(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
}