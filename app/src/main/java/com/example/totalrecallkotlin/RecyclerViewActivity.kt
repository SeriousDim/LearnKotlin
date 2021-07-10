package com.example.totalrecallkotlin

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.totalrecallkotlin.recyclerview.MyRecyclerAdapter
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        var layoutManager = GridLayoutManager(this, 3)
        rec_view.layoutManager = layoutManager
        rec_view.adapter = MyRecyclerAdapter(fillList())
    }

    private fun fillList(): List<String> {
        return this.resources.getStringArray(R.array.cat_names).toList()
    }
}