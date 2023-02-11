package com.example.roomdatabase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isEmpty
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.PersonRecyclerViewAdapter.PersonRecyclerViewAdapter
import com.example.roomdatabase.RoomDataBase.ViewModel.PersonViewModel
import com.example.roomdatabase.RoomDataBase.factory.ViewModelFactoy
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_recyclerview.view.*
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance
import org.w3c.dom.Text

class recyclerview : Fragment(R.layout.fragment_recyclerview), KodeinAware {
    override val kodein by kodein()
    private val factory: ViewModelFactoy by instance()
    private lateinit var viewModel: PersonViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_recyclerview, container, false)

        val btn = view.findViewById<FloatingActionButton>(R.id.id_addItem)
        val btn1 = view.findViewById<FloatingActionButton>(R.id.id_removeItem)
        val btn2 = view.findViewById<FloatingActionButton>(R.id.id_findItem)

        viewModel = ViewModelProvider(this, factory).get(PersonViewModel::class.java)

        btn.setOnClickListener {
            findNavController().navigate(R.id.action_recyclerview_to_editUser)
        }

        btn1.setOnClickListener {
            findNavController().navigate(R.id.action_recyclerview_to_delete)
        }

        btn2.setOnClickListener {
            findNavController().navigate(R.id.action_recyclerview_to_update)
        }


        // RecyclerView
        val adapter1 = PersonRecyclerViewAdapter(viewModel)
        val rw = view.findViewById<RecyclerView>(R.id.id_recyclerView1)
        rw.adapter = adapter1
        rw.layoutManager = LinearLayoutManager(activity)
        viewModel.getAllPeople().observe(viewLifecycleOwner, Observer { person ->
            adapter1.setPerson(person)
            if(adapter1.people.isEmpty()){view?.id_tvView1?.text = "Нет элементов"}
            else{view?.id_tvView1?.isVisible = !isVisible}
        })



        return view
    }

    }
