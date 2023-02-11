package com.example.roomdatabase.RoomDataBase.Repositroy

import com.example.roomdatabase.RoomDataBase.DAO.RoomDAO
import com.example.roomdatabase.RoomDataBase.DataBase.PersonDataBase
import com.example.roomdatabase.RoomDataBase.Model.Person

class RoomRepository(val db: PersonDataBase){

    fun getAllPeople() = db.getDAO().getAllPeople()

    suspend fun deleteAll() = db.getDAO().deleteAllPeople()

    suspend fun deletePerson(id:String) = db.getDAO().findByIdPerson(id)

    suspend fun update(firstName:String, lastName:String, ageName:String, id:String) = db.getDAO().update(firstName, lastName, ageName, id)

    suspend fun upsert(person: Person) = db.getDAO().upsert(person)

    suspend fun delete(person: Person) = db.getDAO().delete(person)

}