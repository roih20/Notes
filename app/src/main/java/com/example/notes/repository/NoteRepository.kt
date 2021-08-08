package com.example.notes.repository

import com.example.notes.room.Dao
import com.example.notes.room.Note

class NoteRepository(private val noteDao: Dao) {

    suspend fun insertNote(note: Note) = noteDao.insertNote(note)
    fun showAllNotes() = noteDao.showAllNotes()
    suspend fun search(query: String) = noteDao.search(query)

}