package com.example.andoirdz.Presenter.ViewHolder

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.view.View
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.andoirdz.Domain.Note
import com.example.andoirdz.R
import java.time.LocalDateTime

class NoteViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {

    var context : Context? = null
    var textViewDate : TextView? = null
    var textViewHead : TextView? = null
    var textViewDescription : TextView? = null

    @RequiresApi(Build.VERSION_CODES.O)
    var data = LocalDateTime.now()
    init
    {
        initializeView()
    }

    fun initializeView()
    {
        textViewDescription = itemView.findViewById(R.id.textview_viewholder_note_description_text)
        textViewHead = itemView.findViewById(R.id.textview_viewholder_note_head_text)
        textViewDate = itemView.findViewById(R.id.textview_viewholder_note_date_text)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("ResourceAsColor")
    fun initiateBind(note : Note)
    {
        if(note.date == getDate(data.year, data.month.value, data.dayOfMonth))
        {
            textViewDate?.setBackgroundResource(R.color.Red)
            textViewDate?.setText(note.date.toString())
            textViewHead?.setBackgroundResource(R.color.Red)
            textViewHead?.setText(note.head)
            textViewDescription?.setBackgroundResource(R.color.Red)
            textViewDescription?.setText(note.description)
        }

            textViewDate?.setText(note.date.toString())
            textViewHead?.setText(note.head)
            textViewDescription?.setText(note.description)

    }


    fun getDate(year: Int, month: Int, day: Int): String { 1
        var date = "$year:$month:$day"
        return date
    }

}