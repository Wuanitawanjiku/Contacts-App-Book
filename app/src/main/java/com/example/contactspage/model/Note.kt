package com.example.contactspage.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notes")
data class Note(
    @PrimaryKey(autoGenerate = true) @NonNull var noteId: Int,
    var title: String,
    var body: String,
    var dateCreated: String
)
