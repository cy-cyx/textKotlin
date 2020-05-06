package com.example.textkotlin

import android.util.Log

/**
 *  lateinit 和 by lazy
 */
class text10 {

    // 如果调用未初始化的变量会抛异常
    lateinit var s: String

    // 在调用时，才初始化
    val s1 by lazy {
        Log.d("xx", "text10:初始化")
    }
}