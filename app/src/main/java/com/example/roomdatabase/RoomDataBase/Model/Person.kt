package com.example.roomdatabase.RoomDataBase.Model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person")
data class Person(
    @ColumnInfo(name = "firstName")
    val first_name:String,
    @ColumnInfo(name = "lastName")
    val last_name:String,
    @ColumnInfo(name = "age")
    val age: String,
    @ColumnInfo(name="id_person")
    val userID:String,
    @PrimaryKey(autoGenerate = true)
    val id:Int
)
