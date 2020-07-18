package com.example.andoirdz.Presenter.ViewHolder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.andoirdz.Domain.Student
import com.example.andoirdz.Domain.StudentsGroup
import com.example.andoirdz.R

class GroupHolder(itemview : View) : RecyclerView.ViewHolder(itemview) {
    var textViewTitle: TextView? = null
    var textViewCount: TextView? = null

    init {
        initializeView()
    }

    fun initializeView() {
        textViewCount = itemView.findViewById(R.id.viewholder_group_count)
        textViewTitle = itemView.findViewById(R.id.viewholder_group_title)
    }

    fun initiateBind(group: StudentsGroup)
    {
        textViewTitle?.setText(group.title)
        textViewCount?.setText(group.students.size.toString())
    }
}