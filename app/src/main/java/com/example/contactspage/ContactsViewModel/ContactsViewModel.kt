package com.example.contactspage.ContactsViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contactspage.model.Contacts
import com.example.contactspage.repository.ContactsRepository
import kotlinx.coroutines.launch

class ContactsViewModel: ViewModel() {
    val contactsRepository = ContactsRepository()
    lateinit var contactsLiveData: LiveData<List<Contacts>>

    fun saveContact(contacts: Contacts){
        viewModelScope.launch {
            contactsRepository.saveContact(contacts)
        }
    }

    fun getAllContacts(){
        contactsLiveData = contactsRepository.getAllContacts()
    }
}