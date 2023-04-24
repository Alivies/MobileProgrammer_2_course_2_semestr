package com.example.clonewar

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide

@Suppress("DEPRECATION")
class PicViewer : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pic_viewer)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val image: ImageView = findViewById(R.id.imageFull)
        val url: String? =
            intent.getSerializableExtra("picLink") as String?
        Glide.with(this)
            .load(url)
            .into(image)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here.
        val id = item.itemId

        if (id == R.id.action_next) {
            val url: String? =
                intent.getSerializableExtra("picLink") as String?
            intent.putExtra("link", url)
            setResult(RESULT_OK, intent)
            finish()
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}