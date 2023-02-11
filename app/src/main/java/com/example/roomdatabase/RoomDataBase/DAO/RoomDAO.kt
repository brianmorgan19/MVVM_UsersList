package com.example.roomdatabase.RoomDataBase.DAO

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.roomdatabase.RoomDataBase.Model.Person
import kotlinx.coroutines.flow.Flow
import java.lang.reflect.Array

@Dao
interface RoomDAO {

    @Query("SELECT * FROM person ORDER BY id ASC")
    fun getAllPeople(): LiveData<List<Person>>

    @Query("DELETE FROM person")
    fun deleteAllPeople()

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun upsert(person: Person)

    @Query("DELETE FROM person WHERE age =:id ")
    suspend fun findByIdPerson(id:String)
    @Query("UPDATE person SET firstName=:first_name, lastName=:last_name, age=:age WHERE id_person =:id ")
    suspend fun update(first_name:String, last_name:String, age:String,id:String)

    @Delete
    suspend fun delete(person: Person)

}