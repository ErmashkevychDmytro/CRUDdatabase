package com.example.crudroomdatabase.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(

        @PrimaryKey(autoGenerate = true)
        var id: Int,

        @ColumnInfo(name = "name")
        var name: String?,

        @ColumnInfo(name = "surname")
        var surname: String?,

        @ColumnInfo(name = "gender")
        var gender: String?,

        @ColumnInfo(name = "age")
        var age: Int

)
