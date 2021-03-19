package com.example.crudroomdatabase.presentation.main

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.crudroomdatabase.CRUDApplication
import com.example.crudroomdatabase.R
import com.example.crudroomdatabase.database.entity.UserEntity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSave.setOnClickListener {
            insertDataToDatabase()
        }
    }

    private fun insertDataToDatabase() {
        val name = etName.text.toString()
        val surname = etSurname.text.toString()
        val gender = etGender.text.toString()
        val age = etAge.text

        if (inputCheck(name, surname, gender, age as Editable)) {
            val user = UserEntity(0, name, surname, gender, Integer.parseInt(age.toString()))
            (application as CRUDApplication).insertUserToDataBase(user)

            Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()

            val intent = Intent(this, com.example.crudroomdatabase.presentation.list.ListActivity::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(name: String, surname: String, gender: String, age: Editable): Boolean {
        return !(TextUtils.isEmpty(name)
                && TextUtils.isEmpty(surname)
                && TextUtils.isEmpty(gender)
                && age.isEmpty())

    }
}








