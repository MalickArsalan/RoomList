package com.example.roomlist.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val firstName :String,
    val middleName :String,
    val lastName :String,
    val fatherName:String,
    val gender: String
)