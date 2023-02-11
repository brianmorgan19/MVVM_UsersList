package com.example.roomdatabase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.PersonRecyclerViewAdapter.PersonRecyclerViewAdapter
import com.example.roomdatabase.R
import com.example.roomdatabase.RoomDataBase.Model.Person
import com.example.roomdatabase.RoomDataBase.ViewModel.PersonViewModel
import com.example.roomdatabase.RoomDataBase.factory.ViewModelFactoy
import kotlinx.android.synthetic.main.activity_data.view.*
import kotlinx.android.synthetic.main.fragment_edit_user.view.*
import kotlinx.android.synthetic.main.fragment_recyclerview.*
import kotlinx.android.synthetic.main.fragment_recyclerview.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class editUser : Fragment(R.layout.fragment_edit_user), KodeinAware {
    override val kodein by kodein()
    private val factory: ViewModelFactoy by instance()
    private lateinit var viewModel:PersonViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_edit_user, container, false)

        // viewModel
        viewModel = ViewModelProvider(this,factory).get(PersonViewModel::class.java)

        // RcView adapter

        view.btn_add.setOnClickListener {
            insertPerson()
        }

        return view
    }

    private fun insertPerson(){
        val name = view?.id_name?.text.toString()
        val lastName = view?.id_lastName?.text.toString()
        val age = view?.id_age?.text.toString()
        val userID = view?.id_userID?.text.toString()
        val person = Person(name, lastName, age, userID,0)
        if(name.isNotEmpty() && lastName.isNotEmpty() && age.isNotEmpty()){
            GlobalScope.launch(Dispatchers.IO){
                viewModel.upsert(person)
            }
            Toast.makeText(activity, "Человек успешно добавлен!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_editUser_to_recyclerview)
        }
        else{
            Toast.makeText(activity, "Все поля должны быть заполнены", Toast.LENGTH_LONG).show()
        }

        view?.id_name?.text?.clear()
        view?.id_lastName?.text?.clear()
        view?.id_age?.text?.clear()

        view?.id_name?.requestFocus()


    }

}