package com.example.roomdatabase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.roomdatabase.RoomDataBase.ViewModel.PersonViewModel
import com.example.roomdatabase.RoomDataBase.factory.ViewModelFactoy
import kotlinx.android.synthetic.main.activity_data.view.*
import kotlinx.android.synthetic.main.fragment_update.view.*
import org.kodein.di.generic.instance
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance
import org.w3c.dom.Text


class update : Fragment(R.layout.fragment_update), KodeinAware {
    override val kodein by kodein()
    private val factoy:ViewModelFactoy by instance()
    private lateinit var viewModel:PersonViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)

        viewModel = ViewModelProvider(this, factoy).get(PersonViewModel::class.java)

        view.update_btn.setOnClickListener {
            viewModel.update(view.update_id_nameUser.text.toString(), view.update_id_lastNameUser.text.toString(), view.update_id_age.text.toString(), view.update_id_ID.text.toString())
            findNavController().navigate(R.id.action_update_to_recyclerview)
        }

        return view
    }


}