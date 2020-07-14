package com.example.andoirdz.Presenter.ViewHolder

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.andoirdz.Domain.Student
import com.example.andoirdz.R
import kotlinx.android.synthetic.main.fragment_students_add_student.*


class StudentHolderWithPhoto (itemview : View) : RecyclerView.ViewHolder(itemview)
{

    var context : Context? = null
    var textViewName : TextView? = null
    var textViewDescription : TextView? = null
    var textViewMark : TextView? = null
    var textViewDate : TextView? = null
    var textViewGroup : TextView? = null
    var imageView : ImageView? = null

    init
    {
        initializeView()
    }

    fun initializeView()
    {
        textViewName = itemView.findViewById(R.id.textview_viewholder_student_name)
        textViewDescription = itemView.findViewById(R.id.textview_viewholder_student_description)
        textViewMark = itemView.findViewById(R.id.textview_viewholder_student_mark)
        textViewDate = itemView.findViewById(R.id.textview_viewholder_student_date_text)
        textViewGroup = itemView.findViewById(R.id.textview_viewholder_student_group_text)
        imageView = itemView.findViewById(R.id.imageview_fragment_add_student)

    }

    fun initiateBind(student : Student)
    {
        textViewName?.setText(student.name)
        textViewDescription?.setText(student.description)
        textViewMark?.setText(student.mark.toString())
        textViewGroup?.setText(student.studentGroup)
        imageView?.setImageBitmap(student.avatar)

        if(student.date == null)
        {
            textViewDate?.setText("")
        }
        else
            textViewDate?.setText(student.getnDate())
    }
}