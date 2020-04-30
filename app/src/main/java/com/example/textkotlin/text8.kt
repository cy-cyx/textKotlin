package com.example.textkotlin

/**
 * 关于遍历和循环
 */
class text8 {

    // arrayList
    var arrayList = ArrayList<String>()

    // int[] ints = new int[]{1,2,3}
    var ints = arrayOf(1, 2, 3, 4)

    // int[] ints = new int[3]
    var intsnull = arrayOfNulls<Int>(2)

    fun a() {
        for (i in ints) {
            // nodo
        }


        // 1 到 100
        for (i in 1..100) {

        }

        // 100 到 1
        for (i in 100 downTo 1) {

        }

        // 1 到 99
        for (i in 1 until 100) {

        }

        // 1 到 10 +2
        for (i in 1..10 step 2) {

        }

        for ((index, e) in ints.withIndex()) {
            // index 下标
            // e     值
        }

        for (index in ints.indices) {
            // index 下标
        }

        for (element in ints) {
            // 值
        }
    }
}