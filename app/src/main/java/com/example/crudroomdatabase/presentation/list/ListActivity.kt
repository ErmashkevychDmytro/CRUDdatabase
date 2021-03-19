package com.example.crudroomdatabase.presentation.list

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.crudroomdatabase.CRUDApplication
import com.example.crudroomdatabase.R
import com.example.crudroomdatabase.database.entity.UserEntity
import com.example.crudroomdatabase.presentation.UpdateUserActivity
import com.example.crudroomdatabase.presentation.list.adapter.ListAdapter
import com.example.crudroomdatabase.presentation.list.adapter.ListItemListener
import com.example.crudroomdatabase.presentation.main.MainActivity
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity(), ListItemListener {

    val adapter = ListAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        userRecyclerView.adapter = adapter
        userRecyclerView.layoutManager = LinearLayoutManager(this)


        val data = (application as CRUDApplication).getDataBase()?.userDao()?.getAll()
        Log.d("ListActivity", "data = $data")
        data?.let { adapter.setData(it) }
    }

    override fun onUserClick(user: UserEntity) {
        val intent = Intent(this, UpdateUserActivity::class.java)
        intent.putExtra("user", user.id)
        startActivity(intent)
    }

    override fun onUserLongClick(user: UserEntity, position: Int) {
        AlertDialog.Builder(this)
                .setTitle(R.string.dialog_title_delete_user_by_id)
                .setMessage(R.string.dialog_massage_delete_user_by_id)
                .setPositiveButton("Ok") { dialog, _ ->
                    deleteUserById(user.id, position)
                    dialog.dismiss()
                }
                .setNegativeButton("Cancel") { dialog, _ -> dialog.dismiss() }
                .show()
    }

    private fun deleteUserById(id: Int, position: Int) {
        (application as CRUDApplication).getDataBase()?.userDao()?.deleteById(id)
        adapter.deleteItem(position)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add(R.string.menu_delete_all_users)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        AlertDialog.Builder(this)
                .setTitle(R.string.dialog_title_delete_user_by_id)
                .setMessage(R.string.dialog_massage_delete_user_by_id)
                .setPositiveButton(R.string.dialog_positive_button) { dialog, _ ->
                    deleteAllUsers()
                    dialog.dismiss()
                }
                .setNegativeButton(R.string.dialog_negative_button) { dialog, _ -> dialog.dismiss() }
                .show()
        return super.onOptionsItemSelected(item)
    }

    private fun deleteAllUsers() {
        (application as CRUDApplication).getDataBase()?.userDao()?.delete()
        finish()
    }

    private fun gotoMainActivity() {
        var intent = Intent(this, MainActivity::class.java)
        finishAffinity()
        startActivity(intent)
    }

}



