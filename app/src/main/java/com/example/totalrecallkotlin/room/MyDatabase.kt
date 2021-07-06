package com.example.totalrecallkotlin.room

import android.content.Context
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Room
import androidx.room.RoomDatabase

typealias InitAction = () -> Unit

@Database(entities = [Student::class, StudentClass::class], // !!! нужно добвлять новые сущности сюда
        version = 1)
abstract class MyDatabase : RoomDatabase(){
    abstract fun studentDao(): StudentDao
    abstract fun studentClassDao(): StudentClassDao

    companion object{
        val DATABASE_NAME = "TotalRecallDB"
        var INSTANCE: MyDatabase? = null

        fun isNull(): Boolean{
            return INSTANCE == null
        }

        fun getDatabase(context: Context): MyDatabase?{
            if (INSTANCE == null){
                synchronized(MyDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        MyDatabase::class.java, DATABASE_NAME)
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyDatabase(){
            INSTANCE = null
        }
    }
}