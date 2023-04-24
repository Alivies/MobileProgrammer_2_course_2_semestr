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
            intent.putExtra("picLink", "https://i3vestno.ru/media/uploads/2022/8/uploads-2022-8-uploads-2022-8-uploads-2022-8-ng.jpg")
            startActivity(intent)
        }
    }
}