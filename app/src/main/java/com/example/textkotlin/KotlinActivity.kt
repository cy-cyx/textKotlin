package com.example.textkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

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
    }
}
