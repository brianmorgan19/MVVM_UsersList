package com.example.roomdatabase.PersonRecyclerViewAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.R
import com.example.roomdatabase.RoomDataBase.Model.Person
import com.example.roomdatabase.RoomDataBase.ViewModel.PersonViewModel
import kotlinx.android.synthetic.main.person_view.view.*

class PersonRecyclerViewAdapter(private val viewModel: PersonViewModel): RecyclerView.Adapter<PersonRecyclerViewAdapter.PersonViewHolder>(){

    var people = emptyList<Person>()

    inner class PersonViewHolder(item:View): RecyclerView.ViewHolder(item)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.person_view, parent, false)

        return PersonViewHolder(view)
    }

    fun setPerson(person: List<Person>){
        this.people = person
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person = people[position]
        holder.itemView.apply {
            id_rcID.text = person.userID
            id_rcName.text = person.first_name
            id_rvLastName.text = person.last_name
            id_rvAge.text = person.age
        }

        holder.itemView.id_delete.setOnClickListener {
            viewModel.delete(person)
        }
        }

    override fun getItemCount(): Int {
        return people.size
    }

    fun isEmpty(): Boolean {
        return people.isEmpty()
    }

}