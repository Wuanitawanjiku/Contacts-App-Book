package com.example.contactspage.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.contactspage.R
import com.squareup.picasso.Picasso


class ViewContactsActivity : AppCompatActivity() {
lateinit var tvName2:TextView
lateinit var tvPhoneNo2:TextView
lateinit var tvEmail2:TextView
lateinit var imgPerson2:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_contacts)
        tvName2=findViewById(R.id.tvName2)
        tvPhoneNo2=findViewById(R.id.tvPhone2)
        tvEmail2=findViewById(R.id.tvEmail2)
        imgPerson2=findViewById(R.id.imgPerson2)


        var nameintent=intent.getStringExtra("name")
        tvName2.text=nameintent
        var phoneIntent=intent.getStringExtra("phoneNumber")
        tvPhoneNo2.text=phoneIntent
        var emailIntent=intent.getStringExtra("email")
        tvEmail2.text=emailIntent
       var imageIntent=intent.getStringExtra("image").toString()
        Picasso.get().load(imageIntent).into(imgPerson2)


    }

    }




