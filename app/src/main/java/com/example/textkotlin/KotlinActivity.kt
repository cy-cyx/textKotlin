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
    }
}
