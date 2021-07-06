package com.example.totalrecallkotlin.room

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

// 1: https://medium.com/mindorks/room-kotlin-android-architecture-components-71cad5a1bb35
@Entity(foreignKeys =
            [ForeignKey(entity = StudentClass::class,
                parentColumns = ["id"],
                childColumns = ["cls"])])
class Student(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null, // !!! Все поля долнжы быть val и nullable
    val name: String?,
    val cls: Int?
){
    override fun toString(): String {
        return "${id}\t\t\t\t\t\t\t\t\t\t\t\t\t\t${name}\t\t\t\t\t\t\t\t\t\t\t\t\t\t${cls}"
    }

    companion object{
        fun getHeader(): String{
            return "id\t\t\t\t\t\t\t\t\t\t\t\t\t\tname\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass"
        }
    }
}