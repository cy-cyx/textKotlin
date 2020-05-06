package com.example.textkotlin

/**
 * companion 和 object
 */

// 单例
object text9 {
    val a = 1

    fun b() {

    }
}

// 伴生对象
class text9_1 {
    companion object {
        val a = 1

        fun b() {}
    }

    fun c() {}
}

class text9_2 {

    // 静态内部类
    class clazz {

    }
}

class text9_3 {

    // 内部类
    inner class clazz {

    }
}