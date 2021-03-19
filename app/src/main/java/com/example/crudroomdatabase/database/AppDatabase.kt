package com.example.crudroomdatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.crudroomdatabase.database.dao.UserDao
import com.example.crudroomdatabase.database.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}