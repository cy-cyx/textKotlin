package com.example.textkotlin

/**
 * by关键字 委托/代理模式
 */
interface Base {
    fun a()
}

class BaseImpl : Base {
    override fun a() {

    }
}

class BaseProxy(b: BaseImpl) : Base by b