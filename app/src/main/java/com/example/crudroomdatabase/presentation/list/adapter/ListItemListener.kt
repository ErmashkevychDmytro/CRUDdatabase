package com.example.crudroomdatabase.presentation.list.adapter

import com.example.crudroomdatabase.database.entity.UserEntity

interface ListItemListener {
    fun onUserClick(user: UserEntity)
    fun onUserLongClick(user: UserEntity, position: Int)
}