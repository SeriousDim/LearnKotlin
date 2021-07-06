package com.example.totalrecallkotlin.io

import android.content.Context
import android.content.SharedPreferences
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_blank1.*

class SharedPrefsWorker(var context: Context?, var editText: EditText){
    private var sharedPrefs : SharedPreferences?

    private val MY_DATA = "MY_SP_DATA"

    init {
        sharedPrefs = context?.getSharedPreferences("total_recall", Context.MODE_PRIVATE)
    }

    fun saveSharedPrefs(){
        val editor: SharedPreferences.Editor = sharedPrefs!!.edit()
        editor.putString(MY_DATA, editText.text.toString())
        editor.apply()
        editor.commit()
        Toast.makeText(context, "Saved to SharedPrefs!", Toast.LENGTH_SHORT).show()
    }

    fun loadSharedPrefs(){
        val data: String? = sharedPrefs?.getString(MY_DATA, "")
        if (data != null)
            editText.setText(data)
        Toast.makeText(context, "Loaded from SharedPrefs!", Toast.LENGTH_SHORT).show()
    }
}