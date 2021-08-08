package com.example.notes.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface Dao {

    // Function to insert a note
    @Insert
    suspend fun insertNote(note: Note)

    //Function to show all notes
    @Query("SELECT * FROM Note_table")
    fun showAllNotes(): LiveData<List<Note>>

    // Function for search the title note
    @Query("SELECT * FROM Note_table WHERE title=:query")
    suspend fun search(query: String): Note



}