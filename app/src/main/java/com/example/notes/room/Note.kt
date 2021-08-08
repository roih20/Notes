package com.example.notes.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Note_table")
data class Note (
     @PrimaryKey
     var title: String )