package com.example.contactspage.repository

import androidx.lifecycle.LiveData
import com.example.contactspage.ContactsApp
import com.example.contactspage.database.ContactsDatabase
import com.example.contactspage.model.Contacts
import com.example.contactspage.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NotesRepository {
    val db = ContactsDatabase.getDatabase(ContactsApp.appContext)

    suspend fun saveNote(note: Note){
        withContext(Dispatchers.IO){
            db.getNotesDao().insertNote(note)
        }
    }

    fun getAllNotes(): LiveData<List<Note>>{
        return db.getNotesDao().getAllNotes()
    }

    fun getNoteById(noteId: Int): LiveData<Note> {
        return db.getNotesDao().getNoteById(noteId)
    }
}