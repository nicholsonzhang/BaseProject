package com.user.base.modules.mine.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.user.base.R


class TestKotlinActivity : AppCompatActivity() {
    //    var mIndex: Int = 100

        override fun onCreate(savedInstanceState: Bundle?)

    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_kotlin)

//        Log.e("yyzhang", "test sum fun" + sum(5, 9))
//        var name = "nichol"
//        Log.e("yyzhang", "name is $name")


//        val asc = Array(5,{i->(i*i).toString()})
//        asc.forEach { Log.e("yyzhang",it) }


    }

    fun sum(a: Int, b: Int): Int {
        return a + b
    }


}