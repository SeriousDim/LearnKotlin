package com.example.totalrecallkotlin.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class StudentClass(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val number: Int? = 1,
    val school: String?
){
    override fun toString(): String {
        return "${id}\t\t\t\t\t\t\t\t\t\t\t\t\t\t${number}\t\t\t\t\t\t\t\t\t\t\t\t\t\t${school}"
    }

    companion object{
        fun getHeader(): String{
            return "id\t\t\t\t\t\t\t\t\t\t\t\t\t\tnumber\t\t\t\t\t\t\t\t\t\t\t\t\t\tschool"
        }
    }
}