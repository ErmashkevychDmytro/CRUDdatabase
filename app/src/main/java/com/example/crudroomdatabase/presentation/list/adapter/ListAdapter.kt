package com.example.crudroomdatabase.presentation.list.adapter


import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.crudroomdatabase.R
import com.example.crudroomdatabase.database.entity.UserEntity


class ListAdapter(private val listener: ListItemListener) : RecyclerView.Adapter<ListHolder>() {

    private var userList = mutableListOf<UserEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {
        return ListHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false),
                listener
        )

    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ListHolder, position: Int) {
        holder.bind(userList[position])
    }


    fun setData(list: List<UserEntity>) {
        Log.d("ListAdapter", "users = $userList")
        userList.addAll(list)
        notifyDataSetChanged()
    }

    fun deleteItem(position: Int) {
        userList.removeAt(position)
        notifyItemRemoved(position)

    }

}






