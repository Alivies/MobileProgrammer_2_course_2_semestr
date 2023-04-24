package com.example.mydialer

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val context: Context,
              private var list: ArrayList<MainActivity.Contact>
) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var textName: TextView = view.findViewById(R.id.textName)
        var textPhone: TextView = view.findViewById(R.id.textPhone)
        var textType: TextView = view.findViewById(R.id.textType)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.rview_item,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list[position]
        holder.textName.text = data.name
        holder.textPhone.text = data.phone
        holder.textType.text = data.type
    }

    @SuppressLint("NotifyDataSetChanged")
    fun filterList(filteredList: ArrayList<MainActivity.Contact>) {
        list = filteredList
        notifyDataSetChanged()
    }

}