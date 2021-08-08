package com.example.notes.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.notes.repository.NoteRepository
import java.lang.Exception

class NoteFactory(private val noteRepository: NoteRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NoteViewModel::class.java)){
            return NoteViewModel(noteRepository) as T
        }
        throw Exception ( "Unknown view model class")
    }

}