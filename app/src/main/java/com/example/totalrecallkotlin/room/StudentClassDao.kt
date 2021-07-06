package com.example.totalrecallkotlin.room

import androidx.room.*

@Dao
interface StudentClassDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(s: StudentClass)

    @Update
    fun update(s: StudentClass)

    @Delete
    fun delete(s: StudentClass)

    @Query("SELECT * FROM StudentClass WHERE id = :id")
    fun getById(id: Long): Student

    @Query("SELECT * FROM StudentClass")
    fun getAll(): List<StudentClass>

    @Query("SELECT COUNT(*) FROM StudentClass")
    fun getCount(): Int

    @Query("DELETE FROM StudentClass")
    fun destroyTable()
}