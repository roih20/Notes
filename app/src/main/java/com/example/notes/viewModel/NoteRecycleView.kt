package com.example.notes.viewModel

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.R
import com.example.notes.room.Note

class NoteRecycleView: RecyclerView.Adapter<NoteRecycleView.ViewHolder>() {

    private var noteList: List<Note> ?= null

    fun setData(note: List<Note>){
        this.noteList = note
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bind( note: Note) {
            itemView.apply {
                findViewById<TextView>(R.id.txt_title).text = note.title
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val card = LayoutInflater.from(parent.context).inflate(R.layout.item_notes, parent, false)

        return ViewHolder(card)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       noteList?.let {
           holder.bind(it[position])
       }
    }

    override fun getItemCount(): Int = noteList?.size ?: 0
}