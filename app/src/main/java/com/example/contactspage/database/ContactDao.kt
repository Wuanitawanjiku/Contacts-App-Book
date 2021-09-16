package com.example.contactspage.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.contactspage.model.Contacts

@Dao
interface ContactDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertContact(contacts: Contacts)

    @Query(value = "SELECT * FROM Contacts")
    fun getAllContacts(): LiveData<List<Contacts>>

    @Query("SELECT * FROM Contacts WHERE id = :contactId")
    fun getContactById(contactId: Int): LiveData<Contacts>

    @Delete
    fun deleteContact(contacts: Contacts)
}