package com.example.contactspage.repository

import androidx.lifecycle.LiveData
import com.example.contactspage.ContactsApp
import com.example.contactspage.database.ContactsDatabase
import com.example.contactspage.model.Contacts
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ContactsRepository {
    val database = ContactsDatabase.getDatabase(ContactsApp.appContext)

    suspend fun saveContact(contact: Contacts){
        withContext(Dispatchers.IO){
            database.contactDao().insertContact(contact)
        }
    }

    fun getAllContacts(): LiveData<List<Contacts>>{
        return database.contactDao().getAllContacts()
    }

    fun fetchContacts(): LiveData<List<Contacts>>{
        return database.contactDao().getAllContacts()
    }

    fun getContactById(contactId: Int): LiveData<Contacts> {
        return database.contactDao().getContactById(contactId)
    }
}