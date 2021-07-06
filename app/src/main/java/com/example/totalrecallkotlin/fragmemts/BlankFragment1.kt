package com.example.totalrecallkotlin.fragmemts

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.totalrecallkotlin.R
import com.example.totalrecallkotlin.io.SharedPrefsWorker
import kotlinx.android.synthetic.main.fragment_blank1.*

// 1: https://wajahatkarim.com/2020/01/bottom-navigation-jetpack-2/
// 2: https://startandroid.ru/ru/uroki/vse-uroki-spiskom/177-urok-107-android-3-actionbar-razmeschenie-elementov.html
class BlankFragment1 : Fragment() {
    private lateinit var sharedPrefs : SharedPrefsWorker

    private val CLEAR = 1
    private val COPY = 2
    private val PASTE = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_blank1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPrefs = SharedPrefsWorker(context, editText)
        save.setOnClickListener() {
            sharedPrefs.saveSharedPrefs()
        }

        load.setOnClickListener() {
            sharedPrefs.loadSharedPrefs()
        }

        registerForContextMenu(editText)
    }

    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?) {
        if (v.id == R.id.editText){
            menu.add(0, CLEAR, 0, "Очистить")
            menu.add(0, COPY, 0, "Копировать")
            menu.add(0, PASTE, 0, "Вставить")
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            CLEAR -> editText.setText("")
        }

        return super.onContextItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.blank1, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.search_item -> Toast.makeText(context, "Searching started", Toast.LENGTH_SHORT).show()
            R.id.send_item -> Toast.makeText(context, "Sending started", Toast.LENGTH_SHORT).show()
            R.id.history_item -> Toast.makeText(context, "History updated", Toast.LENGTH_SHORT).show()
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }
}