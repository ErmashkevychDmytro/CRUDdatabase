package com.example.crudroomdatabase

import android.app.Application
import androidx.room.Room
import com.example.crudroomdatabase.database.entity.UserEntity

open class CRUDApplication : Application() {
    private var crudDatabase: AppDatabase? = null

    override fun onCreate() {
        super.onCreate()
        initDataBase()
    }

    fun getDataBase(): AppDatabase? = this.crudDatabase

    fun insertUserToDataBase(user: UserEntity) = crudDatabase?.userDao()?.insertList(user)

    private fun initDataBase() {
        crudDatabase = Room.databaseBuilder(this, AppDatabase::class.java, "crud_database")
                .allowMainThreadQueries()
                .build()
    }
}


