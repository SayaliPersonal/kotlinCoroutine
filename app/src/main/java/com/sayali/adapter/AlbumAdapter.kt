package com.sayali.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sayali.R
import com.sayali.data.AlbumDataItem
import kotlinx.android.synthetic.main.rv_container.view.*

class AlbumAdapter(val items: ArrayList<AlbumDataItem?>, val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    init {
        Log.w("***items",items.toString())
    }
    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return items.size
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.rv_container, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.tvAnimalType?.text = items[position]?.title
    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each animal to
    val tvAnimalType = view.title
}