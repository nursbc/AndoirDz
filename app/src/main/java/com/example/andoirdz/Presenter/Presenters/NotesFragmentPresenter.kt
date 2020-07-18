package com.example.andoirdz.Presenter.Presenters

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.andoirdz.Domain.Note
import com.example.andoirdz.Presenter.Contract.NotesFragmentContract

import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayList

class NotesFragmentPresenter : NotesFragmentContract.Presenter {

    var viewNote : NotesFragmentContract.View? = null

    var notes : ArrayList<Note> = ArrayList()

    var calendar: Calendar = Calendar.getInstance()

    @RequiresApi(Build.VERSION_CODES.O)
    var data = LocalDateTime.now()
    @RequiresApi(Build.VERSION_CODES.O)
    val temp = getDate(data.year, data.month.value, data.dayOfMonth)

    constructor()
    {

    }


    override fun initializeData() {
        viewNote?.processNoteData(notes.apply {
            add(Note(temp, "Vajnie", "Dela"))
            add(Note(temp, "Vajnie", "Dela"))
            add(Note(temp, "Vajnie", "Dela"))
        })

        viewNote?.initiateNoteUpdateAdapter()
    }

    fun getDate(year: Int, month: Int, day: Int): String {
        var date = "$year:$month:$day"
        return date
    }

    override fun initiateAddnewNote(note: Note) {
        notes.add(note)
        viewNote?.NoteAdapter(notes)
    }

    override fun attach(view: NotesFragmentContract.View) {
        this.viewNote = view
    }

    override fun onStop() {
        this.viewNote = null
    }


}