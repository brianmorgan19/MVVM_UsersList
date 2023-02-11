package com.example.roomdatabase

import android.app.Application
import com.example.roomdatabase.RoomDataBase.DataBase.PersonDataBase
import com.example.roomdatabase.RoomDataBase.Repositroy.RoomRepository
import com.example.roomdatabase.RoomDataBase.ViewModel.PersonViewModel
import com.example.roomdatabase.RoomDataBase.factory.ViewModelFactoy
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class RoomDataBaseApplication: Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@RoomDataBaseApplication))
        bind() from provider  { PersonDataBase.getDatabase(instance()) }
        bind() from singleton { RoomRepository(instance()) }
        bind() from provider {
            ViewModelFactoy(instance())
        }
    }
}