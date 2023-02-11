package com.example.roomdatabase.RoomDataBase.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdatabase.PersonRecyclerViewAdapter.PersonRecyclerViewAdapter
import com.example.roomdatabase.RoomDataBase.DAO.RoomDAO
import com.example.roomdatabase.RoomDataBase.Model.Person


@Database(entities = [Person::class], version = 1, exportSchema = true)
abstract class PersonDataBase: RoomDatabase() {

    abstract fun getDAO(): RoomDAO

    companion object {
        @Volatile
        private var INSTANCE:PersonDataBase? = null

        fun getDatabase(context: Context): PersonDataBase{
            if(INSTANCE == null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, PersonDataBase::class.java, "personN").build()
                }
            }
            return INSTANCE!!
        }
    }

}
