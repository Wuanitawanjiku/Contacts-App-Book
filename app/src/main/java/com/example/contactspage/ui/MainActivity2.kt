package com.example.contactspage.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contactspage.model.Contacts
import com.example.contactspage.ContactsAdapter
import com.example.contactspage.ContactsViewModel.ContactsViewModel
import com.example.contactspage.R
import com.example.contactspage.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    lateinit var rvContacts: RecyclerView
    val contactsViewModel: ContactsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        contactsViewModel.getAllContacts()
        contactsViewModel.contactsLiveData.observe(this, {contacts->
            displayContacts(contacts)
        })

        binding.fabSave.setOnClickListener {
            startActivity(Intent(this, ViewContactsActivity::class.java))
        }
    }

    fun displayContacts(contactList: List<Contacts>){
        var rvContacts=findViewById<RecyclerView>(R.id.rvContacts)
        var contactslist= listOf(contactList)
        var contactsAdapter= ContactsAdapter(contactList,baseContext)
        rvContacts.layoutManager=LinearLayoutManager(baseContext)
        rvContacts.adapter=contactsAdapter
    }
}