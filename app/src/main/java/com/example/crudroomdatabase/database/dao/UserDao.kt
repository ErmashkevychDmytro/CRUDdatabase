package com.example.crudroomdatabase.database.dao

import androidx.room.*
import com.example.crudroomdatabase.database.entity.UserEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM users")
    fun getAll(): List<UserEntity>

    @Query("SELECT * FROM users WHERE id = :id")
    fun findById(id: Int): UserEntity

    @Query("DELETE FROM users WHERE id = :id")
    fun deleteById(id: Int)

    @Query("DELETE FROM users")
    fun delete()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(listEntities: UserEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateUser(vararg users: UserEntity)
}