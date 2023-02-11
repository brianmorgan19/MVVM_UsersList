package com.example.roomdatabase.RoomDataBase.ViewModel

import androidx.lifecycle.ViewModel
import com.example.roomdatabase.RoomDataBase.Model.Person
import com.example.roomdatabase.RoomDataBase.Repositroy.RoomRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class PersonViewModel(private val repository: RoomRepository): ViewModel() {

    fun upsert(person: Person) = GlobalScope.launch(Dispatchers.Main) {
        repository.db.getDAO().upsert(person)
    }

    fun deleteAllPeople() = GlobalScope.launch(Dispatchers.IO) {
        repository.db.getDAO().deleteAllPeople()
    }

    fun deletePerson(id:String) = GlobalScope.launch(Dispatchers.Main) { repository.db.getDAO().findByIdPerson(id) }


    fun update(firstName:String, lastName:String, ageName:String, id:String) = GlobalScope.launch(Dispatchers.Main) {
        repository.db.getDAO().update(firstName, lastName, ageName, id)
    }

    fun delete(person: Person) = GlobalScope.launch(Dispatchers.Main) {
        repository.db.getDAO().delete(person)
    }

    fun getAllPeople() = repository.db.getDAO().getAllPeople()

}