package com.example.roomdatabase.RoomDataBase.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.roomdatabase.RoomDataBase.Repositroy.RoomRepository
import com.example.roomdatabase.RoomDataBase.ViewModel.PersonViewModel

class ViewModelFactoy(private val repository: RoomRepository): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PersonViewModel(repository) as T
    }

}