package com.example.newactivity

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class PicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pic_layout)

        val image: ImageView = findViewById(R.id.picView)
        val url: String? =
            intent.getSerializableExtra("picLink") as String?
        Glide.with(this)
            .load(url)
            .into(image)
    }
}