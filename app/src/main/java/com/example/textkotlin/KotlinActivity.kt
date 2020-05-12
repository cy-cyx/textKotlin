package com.example.textkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class KotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // JvmName
        kotlinField = "text"
        kotlinFunction()

        kotlinField_1 = "text"
        kotlinFunction1()

        // JvmMultifileClass
        getA()
        getB()

        // JvmStatic
        text6.A = 1
        text6_1.A = 1

        text6.B()
        text6_1.B()

        // 伴生对象
        text9.a
        text9.b()

        text9_1.a
        text9_1.b()

        var c = text9_2.clazz()
        var c1 = text9_3().clazz()

        // 扩展
        var c2 = text12()
        c2.a()
        c2.b()

        // 泛类
        var cla1: clazz1<in String> = clazz1<Any>()

        var cla2: clazz1<cla2> = clazz1()
        var cla3: clazz1<cla1> = clazz1()
        var cla4: clazz1<cla3> = clazz1()

        cla2.copy(cla4, cla3)

        var cla5 = clazz2()

        var a: cla1 = cla5.getA()

        var cla6 = clazz3()

        var cla7 = cla1()
        var cla8 = cla2()
        var cla9 = cla3()

        cla6.setA(cla9)
    }
}
