package com.example.clone

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.io.IOException
import java.net.URL


@Suppress("DEPRECATION")
class Adapter(private val context: Context,
              private val list: ArrayList<MainActivity.Photo>,
              private val cellClickListener: CellClickListener
) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageView)
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
        val link = "https://farm${data.farm}.staticflickr.com/${data.server}/${data.id}_${data.secret}_z.jpg"
        val url = URL(link)
        try {
            Glide.with(context).load(url).into(holder.imageView)
        } catch (e: IOException) {}

        holder.imageView.setOnClickListener {
            cellClickListener.onCellClickListener(context, link, data.number)
        }
    }

    interface CellClickListener {
        fun onCellClickListener(context: Context, data: String, number:Int) {
            val intent = Intent(context, PicViewer::class.java)
            intent.putExtra("picLink", data)
            intent.putExtra("picNum", number)
            context.startActivity(intent)
        }
    }
}