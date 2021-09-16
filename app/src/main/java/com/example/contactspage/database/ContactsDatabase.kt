package com.example.contactspage.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.contactspage.model.Contacts
import com.example.contactspage.model.Note

@Database(entities = arrayOf(Contacts::class, Note::class),  version = 2)
abstract class ContactsDatabase: RoomDatabase() {
    abstract fun contactDao(): ContactDao

    abstract fun getNotesDao(): NotesDao

    companion object {
        private var database: ContactsDatabase? = null

        fun getDatabase(context: Context): ContactsDatabase {
            if (database == null) {
                database =
                    Room.databaseBuilder(context, ContactsDatabase::class.java, "contactsDb")
                        .fallbackToDestructiveMigration().build()
            }
            return database as ContactsDatabase
        }
    }
}