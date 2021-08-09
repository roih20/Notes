package com.example.notes.repository

import com.example.notes.room.Dao
import com.example.notes.room.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NoteRepository(private val noteDao: Dao) {

    suspend fun insertNote(note: Note) = noteDao.insertNote(note)
    fun showAllNotes() = noteDao.showAllNotes()
    suspend fun search(query: String) = withContext(Dispatchers.IO) {
        noteDao.search(query)
    }

}