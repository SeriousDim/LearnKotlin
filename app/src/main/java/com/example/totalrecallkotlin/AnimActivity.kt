package com.example.totalrecallkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_anim.*

class AnimActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anim)

        var shakeAnim = AnimationUtils.loadAnimation(this, R.anim.shake)

        shake.setOnClickListener() {
            shake.startAnimation(shakeAnim)
        }
    }
}