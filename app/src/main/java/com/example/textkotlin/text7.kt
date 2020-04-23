package com.example.textkotlin

import android.graphics.Bitmap
import java.lang.RuntimeException

/**
 * Strictfp  Transient Volatile Synchronized Throws
 */
class text7 {

    // 浮点运算更加精确， 而且不会因为不同的硬件平台所执行的结果不一致
    @Strictfp
    fun A(): Float {
        return 1f
    }

    @Synchronized
    fun B() {

    }

    @Transient
    var C: Bitmap? = null;

    @Volatile
    var D = 1;

    @Throws(RuntimeException::class)
    fun funF() {

    }
}