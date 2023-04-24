package com.example.clone

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide


@Suppress("DEPRECATION")
class PicViewer : AppCompatActivity() {
    val APP_PREFERENCES = "favourites1"
    val APP_PREFERENCES_LIKE: Boolean? = false
    var likeLIst = listOf(false, false, false, false, false, false)
    var mSettings: SharedPreferences? = null
    var number:Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pic_viewer)
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val image: ImageView = findViewById(R.id.imageFull)
        val url: String? =
            intent.getSerializableExtra("picLink") as String?
        Glide.with(this)
            .load(url)
            .into(image)
        number = intent.getSerializableExtra("picNum") as Int?
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        if(this.mSettings?.contains(likeLIst[number!!].toString()) == true) {
            menu.findItem(R.id.action_next).setIcon(R.drawable._11755_heart_icon)
        }
        else {
            menu.findItem(R.id.action_next).setIcon(R.drawable._11754_heart_icon)
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here.
        val id = item.itemId

        if (id == R.id.action_next) {
            Toast.makeText(this, "Добавлено в Избранное", Toast.LENGTH_SHORT).show()
            item.setIcon(R.drawable._11755_heart_icon)
            val editor: SharedPreferences.Editor = mSettings!!.edit()
            editor.putBoolean(likeLIst[number!!].toString(), true)
            editor.apply()
            val newList = likeLIst.toMutableList()
            newList[number!!] = true
            likeLIst = newList


            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}