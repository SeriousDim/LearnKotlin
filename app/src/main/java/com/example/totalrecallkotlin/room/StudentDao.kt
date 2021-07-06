package com.example.totalrecallkotlin.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface StudentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(s: Student)

    @Update
    fun update(s: Student)

    @Delete
    fun delete(s: Student)

    @Query("SELECT * FROM Student WHERE id = :id")
    fun getById(id: Long): Student

    @Query("SELECT * FROM Student")
    fun getAll(): List<Student>

    @Query("SELECT * FROM Student")
    fun getAllAsLiveData(): LiveData<List<Student>>

    @Query("SELECT COUNT(*) FROM Student")
    fun getCount(): Int

    @Query("DELETE FROM Student")
    fun clearTable()
}