// 命名该文件的类名 此时与class冲突
@file:JvmName("Text3JvmName")

package com.example.textkotlin

/**
 * JvmName
 */
// 改变量也是静态的
var kotlinField: String? = null
    //修改属性的set方法名
    @JvmName("setJavaField")
    set(value) {
        field = value  // field注意死循环
    }
    get() {
        return field
    }

// 修改普通的方法名(此方法为静态)
@JvmName("JavaFunction")
fun kotlinFunction() {

}