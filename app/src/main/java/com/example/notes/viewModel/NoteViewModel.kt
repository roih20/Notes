package com.example.notes.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.repository.NoteRepository
import com.example.notes.room.Note
import kotlinx.coroutines.launch
import java.lang.Error

class NoteViewModel(private val noteRepository: NoteRepository): ViewModel(){

    val title = MutableLiveData("")
    var noteList = noteRepository.showAllNotes()

    fun insertNote(){
        viewModelScope.launch {
            try {
                if (!title.value.isNullOrEmpty()){
                    val newNote = Note(title.value!!)
                    noteRepository.insertNote(newNote)
                    title.value= ""
                }
            }catch (e: Error){
                Log.d("Error", e.message.toString())
            }
        }

    }


}