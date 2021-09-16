package com.example.contactspage.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.contactspage.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var imageView=findViewById<ImageView>(R.id.ivContacts)
        imageView.setOnClickListener {
            var intent=Intent(baseContext, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}