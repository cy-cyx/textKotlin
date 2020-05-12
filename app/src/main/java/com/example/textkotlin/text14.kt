package com.example.textkotlin

/**
 * 泛类
 */

open class cla1

open class cla2 : cla1()

class cla3 : cla2()

// 最普通的泛类
class clazz1<T> {
    var a: T? = null

    fun copy(src: clazz1<out T>, dst: clazz1<in T>) {
        dst.a = src.a
    }
}


interface interface1<out T> {
    fun getA(): T
}

class clazz2 : interface1<cla2> {
    override fun getA(): cla2 {
        return cla2()
    }
}

interface interface2<in T> {
    fun setA(a: T)
}

class clazz3 : interface2<cla2> {

    var a1: cla2? = null

    override fun setA(a: cla2) {
        this.a1 = a
    }

}
