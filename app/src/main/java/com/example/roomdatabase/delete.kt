package com.example.roomdatabase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.roomdatabase.PersonRecyclerViewAdapter.PersonRecyclerViewAdapter
import com.example.roomdatabase.RoomDataBase.DAO.RoomDAO
import com.example.roomdatabase.RoomDataBase.DataBase.PersonDataBase
import com.example.roomdatabase.RoomDataBase.Model.Person
import com.example.roomdatabase.RoomDataBase.Repositroy.RoomRepository
import com.example.roomdatabase.RoomDataBase.ViewModel.PersonViewModel
import com.example.roomdatabase.RoomDataBase.factory.ViewModelFactoy
import kotlinx.android.synthetic.main.fragment_delete.view.*
import kotlinx.coroutines.*
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance
import org.w3c.dom.Text
class delete : Fragment(R.layout.fragment_delete), KodeinAware {
    override val kodein by kodein()
    private val factory: ViewModelFactoy by instance()
    private lateinit var repository: RoomRepository
    private lateinit var viewModel:PersonViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_delete, container, false)
        viewModel = ViewModelProvider(this,factory).get(PersonViewModel::class.java)

        val id = view.findViewById<EditText>(R.id.id_ID).text.toString()
        val adapter = PersonRecyclerViewAdapter(viewModel)

        view.btn_delete.setOnClickListener{
            
            Toast.makeText(activity, "Человек успешно удален", Toast.LENGTH_LONG).show()
        }

        view.btn_deleteAll.setOnClickListener {
            viewModel.deleteAllPeople()
        }

        return view
    }


}