package com.example.totalrecallkotlin.fragmemts

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.totalrecallkotlin.MainActivity
import com.example.totalrecallkotlin.NavActivity
import com.example.totalrecallkotlin.R
import kotlinx.android.synthetic.main.fragment_blank2.*

class BlankFragment2 : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_blank2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    fun setListeners(){
        to_main.setOnClickListener(){
            var intent = Intent(context, MainActivity::class.java)
            intent.putExtra("STR_DATA", "fuckin shit man")
            startActivity(intent)
        }
    }
}