package com.example.totalrecallkotlin

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SimpleAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main_list.*

// 1: https://startandroid.ru/ru/uroki/vse-uroki-spiskom/107-urok-48-ispolzuem-simpleadapter.html
class MainActivityList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_list)

        createListWithSimpleAdapter()
    }

    fun createListWithSimpleAdapter(){
        val ATTR_TEXT = "text"
        val ATTR_CHECKED = "checked"
        val ATTR_IMG = "image"
        val texts = arrayOf(
            "sometext 1", "sometext 2", "sometext 3",
            "sometext 4", "sometext 5"
        )

        val checked = booleanArrayOf(true, false, false, true, false)
        val img: Int = R.drawable.ic_launcher_background

        val data = ArrayList<Map<String, Any>>(texts.size)
        var m: Map<String, Any>
        for (i in 0 until texts.size) {
            m = HashMap()
            m[ATTR_TEXT] = texts[i]
            m[ATTR_CHECKED] = checked[i]
            m[ATTR_IMG] = img
            data.add(m)
        }

        var from = arrayOf(ATTR_TEXT, ATTR_CHECKED, ATTR_IMG)
        var to = intArrayOf(R.id.tvText, R.id.cbChecked, R.id.ivImg)

        var adapter = SimpleAdapter(this, data, R.layout.simple_adapter_list_item,
            from, to)
        my_list.adapter = adapter
    }

    fun createExampleList(){
        val data = arrayOf("Иван", "Марья", "Петр", "Антон", "Даша", "Борис",
            "Костя", "Игорь", "Анна", "Денис", "Андрей", "Иван", "Марья", "Петр", "Антон", "Даша", "Борис",
            "Костя", "Игорь", "Анна", "Денис", "Андрей", "Иван", "Марья", "Петр", "Антон", "Даша", "Борис",
            "Костя", "Игорь", "Анна", "Денис", "Андрей", "Иван", "Марья", "Петр", "Антон", "Даша", "Борис",
            "Костя", "Игорь", "Анна", "Денис", "Андрей")

        var adapter = ArrayAdapter<String>(this, R.layout.list_item, data)
        my_list.adapter = adapter
    }
}