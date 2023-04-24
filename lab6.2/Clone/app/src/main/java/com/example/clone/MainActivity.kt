package com.example.clone

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import okhttp3.OkHttpClient
import timber.log.Timber
import java.net.URL

class MainActivity : AppCompatActivity(), Adapter.CellClickListener {
    private val myUrl = URL("https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=ff49fcd4d4a08aa6aafb6ea3de826464&tags=cat&format=json&nojsoncallback=1")
    private var okHttpClient: OkHttpClient = OkHttpClient()
    var mSettings:SharedPreferences?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Timber.plant(Timber.DebugTree())

        val recyclerView: RecyclerView = findViewById(R.id.rView)

        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = Adapter(this, fetchList(), this)

        val mDividerItemDecoration: DividerItemDecoration = DividerItemDecoration(
            recyclerView.context,
            (recyclerView.layoutManager as GridLayoutManager).orientation
        )
        recyclerView.addItemDecoration(mDividerItemDecoration);

        mSettings = getSharedPreferences("favourites", Context.MODE_PRIVATE);
    }

    data class Photo(
        val id: Long,
        val number:Int,
        val owner: String = "",
        val secret: String = "",
        val server: Int = 0,
        val farm: Int = 0,
        val title: String = "",
    )

    data class PhotoPage(
        val page: Int = 1,
        val pages: Int = 1,
        val photo: JsonArray,
    )

    data class Wrapper(
        val photos: JsonObject,
        val stat: String = "ok",
    )

    private fun fetchList(): ArrayList<Photo> {
        val list = arrayListOf<Photo>()

        val model1 = Photo(52549327280,0, "60858939@N00","e9c0544af2", 65535, 66, "Cinnamon Cake")
        val model2 = Photo(52548824136, 1,"31269254@N04","880d68c737", 65535, 66, "Cosmic Cat")
        val model3 = Photo(52548792454, 2,"61300408@N05","c01489098e", 65535, 66, "\\u3054\\u307e")
        val model4 = Photo(52530249735, 3,"97555832@N08","5f29879aaf", 65535, 66, "Alma&Felicia_02992")
        val model5 = Photo(52525803402, 4,"43056966@N07","47e6af2b13", 65535, 66, "Valldemossa Cat [Valldemossa - 24 August 2022]")
        val model6 = Photo(52547834187, 5,"84904494@N00","1661a66208", 65535, 66, "Better Homes & Gardens 2022-11 122")

        list.add(model1)
        list.add(model2)
        list.add(model3)
        list.add(model4)
        list.add(model5)
        list.add(model6)
        mSettings?.edit()?.clear()?.apply()
        return list
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == 100) {
            Toast.makeText(this,"OK", Toast.LENGTH_LONG)
        }
    }
}
