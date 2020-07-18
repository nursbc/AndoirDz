package com.example.andoirdz.Presenter.Adapter

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.andoirdz.Domain.Note
import com.example.andoirdz.Presenter.ViewHolder.NoteViewHolder
import com.example.andoirdz.R


class NotesAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder> {

    var context: Context? = null
    var notes: List<Note>

    constructor(context: Context?, notes: List<Note>){
        this.context = context
        this.notes = notes
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.viewholder_note, parent, false)
        return NoteViewHolder(view)
    }

    override fun getItemCount(): Int {
        return notes?.size ?: 0
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as NoteViewHolder).initiateBind(notes.get(position))

    }
}