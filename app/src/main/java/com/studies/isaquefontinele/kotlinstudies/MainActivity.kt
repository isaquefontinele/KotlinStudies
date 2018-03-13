package com.studies.isaquefontinele.kotlinstudies

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var big: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun changeMario(view: View) {
//        if (big) image_mario.setImageResource(R.drawable.marioSmall) else image_mario.setImageResource(R.drawable.marioBig)

        big = if (big) {
            image_mario.setImageResource(R.drawable.mario_small)
            false
        } else {
            image_mario.setImageResource(R.drawable.mario_big)
            true
        }

    }
}
