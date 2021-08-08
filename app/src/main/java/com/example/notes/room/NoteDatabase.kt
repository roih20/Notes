package com.example.notes.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(version = 1, entities = [Note::class], exportSchema = true)

abstract class NoteDatabase: RoomDatabase() {

    abstract fun noteDao(): Dao

    companion object{
        @Volatile
        private var INSTANCE: NoteDatabase ?= null

        fun getDatabase(context: Context) = INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context,
                NoteDatabase::class.java,
                "NoteDB"
            ).build()

            INSTANCE = instance
            instance
        }
    }
}