package com.example.andoirdz.Presenter.ViewHolder

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.andoirdz.Domain.Student
import com.example.andoirdz.R

class StudentHolder(itemview : View) : RecyclerView.ViewHolder(itemview) {


    var textViewName: TextView? = null
    var textViewDescription: TextView? = null
    var textViewMark: TextView? = null
    var textViewDate: TextView? = null

    init {
        initializeView()
    }

    fun initializeView() {
        textViewName = itemView.findViewById(R.id.textview_viewholder_student_name)
        textViewDescription = itemView.findViewById(R.id.textview_viewholder_student_description)
        textViewMark = itemView.findViewById(R.id.textview_viewholder_student_mark)
        textViewDate = itemView.findViewById(R.id.textview_viewholder_student_date_text)

    }

    fun initiateBind(student: Student) {
        var bitmapImage: Bitmap? = null
        textViewName?.setText(student.name)
        textViewDescription?.setText(student.description)
        textViewMark?.setText(student.mark.toString())

        if (student.date == null) {
            textViewDate?.setText("")
        } else
            textViewDate?.setText(student.getnDate())
    }
}