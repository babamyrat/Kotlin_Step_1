package com.example.kotlinstep1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinstep1.model.UsersModel
import com.example.kotlinstep1.model.UsersModelItem
import com.example.kotlinstep1.ui.UsersAdapter
import com.example.kotlinstep1.ui.UsersViewModel

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: UsersViewModel
    lateinit var recyclerView:RecyclerView
    private lateinit var adapter: UsersAdapter
    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)


        viewModel = ViewModelProvider(this)[UsersViewModel::class.java]

        viewModel.getViewUsers()
        viewModel.myUserList.observe(this) { response->
            response.body()?.let {
                adapter.setList(it)
            }

        }

        adapter = UsersAdapter(this)
        recyclerView.adapter = adapter

        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.isNestedScrollingEnabled = true
        recyclerView.setHasFixedSize(true)



    }

}