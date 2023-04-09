package com.example.kotlinstep1.ui

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinstep1.R
import com.example.kotlinstep1.model.UsersModel
import com.example.kotlinstep1.model.UsersModelItem

class UsersAdapter(var context: Context):RecyclerView.Adapter<UsersAdapter.ViewHolder>() {
    private var list = emptyList<UsersModelItem>()
//    lateinit var context: Context



    inner class ViewHolder(v : View): RecyclerView.ViewHolder(v){

        var txtName = v.findViewById<TextView>(R.id.txtName)
        var image = v.findViewById<ImageView>(R.id.image)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.list_items, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtName.text = list[position].strName

        Glide.with(context)
            .load(list[position].strImage)
            .into(holder.image)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(lists: List<UsersModelItem>) {
        list = lists
        notifyDataSetChanged()
    }


}

