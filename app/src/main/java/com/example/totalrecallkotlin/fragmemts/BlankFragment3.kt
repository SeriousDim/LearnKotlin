package com.example.totalrecallkotlin.fragmemts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import com.example.totalrecallkotlin.R
import com.example.totalrecallkotlin.room.*
import kotlinx.android.synthetic.main.fragment_blank3.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.StringBuilder
import kotlin.random.Random

class BlankFragment3 : Fragment() {
    private lateinit var db: MyDatabase
    private lateinit var studentDao: StudentDao
    private lateinit var studentClassDao: StudentClassDao

    private lateinit var studentData: LiveData<List<Student>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        db = MyDatabase.getDatabase(requireContext())!!
        studentDao = db.studentDao()
        studentClassDao = db.studentClassDao()

        studentData = studentDao.getAllAsLiveData()
        studentData.observe(viewLifecycleOwner) {
            CoroutineScope(IO).launch { updateTextView()}
        }

        // init StudentClasses
        CoroutineScope(IO).launch()
        {
            if (studentClassDao.getCount() == 0){
                for (c in 1..11) {
                    val ncls = StudentClass(null, c, "School #10")
                    studentClassDao.insert(ncls)
                }
            }
        }

        setListeners()
        CoroutineScope(IO).launch { updateTextView()}
    }

    fun setListeners(){
        addStudent.setOnClickListener() {
            CoroutineScope(IO).launch()
            {
                var s = Student(null,
                    Random.nextLong(1_000_000_000_000, 9_999_999_999_999).toString(),
                    Random.nextInt(1, 11))
                studentDao.insert(s)
                //updateTextView()
            }
        }

        destroy.setOnClickListener() {
            CoroutineScope(IO).launch()
            {
                studentDao.clearTable()
                updateTextView()
            }
        }

        deleteAll.setOnClickListener(){
            CoroutineScope(IO).launch()
            {
                db.clearAllTables()
                updateTextView()
            }
        }

        delete.setOnClickListener() {
            CoroutineScope(IO).launch()
            {
                var s = Student(20, null, null)
                studentDao.delete(s)
                //updateTextView()

            }
        }
    }

    suspend fun updateTextView(){
        var out = StringBuilder()
        out.append("Student Table(${studentDao.getCount()}):\n")
        out.append(Student.getHeader())
        out.append("\n")
        for (s in studentDao.getAll()){
            out.append(s.toString())
            out.append("\n")
        }

        out.append("\n")
        out.append("\n")

        out.append("StudentClass Table(${studentClassDao.getCount()}):\n")
        out.append(StudentClass.getHeader())
        out.append("\n")
        for (s in studentClassDao.getAll()){
            out.append(s.toString())
            out.append("\n")
        }

        withContext(Main) {
            dataView.setText(out.toString())
        }
    }
    
}