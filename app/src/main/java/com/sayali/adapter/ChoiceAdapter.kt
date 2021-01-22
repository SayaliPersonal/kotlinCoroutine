package com.sayali.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.sayali.MainActivity
import com.sayali.R
import kotlinx.android.synthetic.main.container_choice.view.*

class ChoiceAdapter(val items: Array<String>, val context: Context) : RecyclerView.Adapter<ViewHolderA>() {

    init {
        Log.w("***items",items.toString())
    }
    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return items.size
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderA {
        return ViewHolderA(LayoutInflater.from(context).inflate(R.layout.container_choice, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolderA, position: Int) {
        holder?.choice?.text = items[position]

        holder?.choice?.setOnClickListener({
            val intent = Intent(context,MainActivity::class.java)
            intent.putExtra("choice_name",items[position])
            intent.putExtra("choice_no",position)
            context.startActivity(intent)
        })
    }
}

class ViewHolderA (view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each animal to
    val choice = view.btn_choice
}