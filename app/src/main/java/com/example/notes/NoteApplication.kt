package com.example.notes

import android.app.Application
import com.example.notes.repository.NoteRepository
import com.example.notes.room.NoteDatabase

class NoteApplication:Application() {

    private val database by lazy {
        NoteDatabase.getDatabase(this)
    }

    val noteRepository by lazy {
        val noteDao = database.noteDao()
        NoteRepository(noteDao)
    }
}