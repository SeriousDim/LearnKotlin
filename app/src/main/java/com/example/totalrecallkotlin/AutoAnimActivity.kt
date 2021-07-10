package com.example.totalrecallkotlin

import android.app.TimePickerDialog
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.transition.AutoTransition
import androidx.transition.TransitionInflater
import androidx.transition.TransitionManager
import androidx.transition.TransitionSet
import kotlinx.android.synthetic.main.activity_auto_anim.*

// 1: https://www.geeksforgeeks.org/how-to-create-an-expandable-cardview-in-android/
class AutoAnimActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auto_anim)
    }

    fun showView1(v: View){
        changeState(view1)
    }

    fun showToast(s: String){
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }

    fun showView2(v: View){
        changeState(view2)
    }

    fun changeState(vg: ViewGroup){
        TransitionManager.beginDelayedTransition(
            vg,
            AutoTransition()
        )
        vg.visibility = if (vg.visibility == View.GONE) View.VISIBLE else View.GONE
    }

}