package com.example.textkotlin;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 在java调kotlin
 */
public class JavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // JvmName
        Text3JvmName.getKotlinField();
        Text3JvmName.JavaFunction();

        Text3_1Kt.getKotlinField_1();
        Text3_1Kt.kotlinFunction1();

        // JvmMultifileClass
        Utils.getA();
        Utils.getB();

        // JvmStatic
        text6.B();
        text6.getA();

        text6_1.Companion.getA();
        text6_1.Companion.B();

        // 伴生对象
        text9.INSTANCE.b();
        text9.INSTANCE.getA();

        text9_1.Companion.b();
        text9_1.Companion.getA();

        text9_2.clazz c = new text9_2.clazz();
        text9_3.clazz c1 = new text9_3().new clazz();

        // 扩展
        text12 c2 = new text12();
        c2.a();
        Text12_1Kt.b(c2);

        // 泛类
        text14.text14_1 cla = new text14.text14_1<cla3>();
        text14.text14_1<cla2> cla1 = cla;
//        cla3 a = cla.a;
    }
}
