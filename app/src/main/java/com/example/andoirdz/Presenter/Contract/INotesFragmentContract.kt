package com.example.andoirdz.Presenter.Contract


import com.example.andoirdz.Domain.Note
import com.example.myapplication.Presentation.Base.BaseContract

interface INotesFragmentContract {

    interface View : BaseContract.BaseView{
        fun initializeNotePresenter()

        fun initializeNoteLayoutManager()

        fun NoteAdapter(notes : ArrayList<Note>)

        fun initializeNoteAdapter()

        fun initiateNoteUpdateAdapter()


        fun processNoteData(notes: ArrayList<Note>)
    }

    interface Presenter : BaseContract.BasePresenter<View>{
        fun initializeData()

        fun initiateAddnewNote(note: Note)

    }

}