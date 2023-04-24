package com.example.newactivity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn: Button = findViewById(R.id.btn_show_pic)
        btn.setOnClickListener{
            val intent = Intent(this, PicActivity::class.java)
            intent.putExtra("picLink", "https://sportishka.com/uploads/posts/2022-03/thumbs/1647890840_51-sportishka-com-p-arrigech-alyaska-turizm-krasivo-foto-60.jpg")
            startActivity(intent)
        }
    }
}