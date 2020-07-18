package com.example.andoirdz.Presenter.Adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.andoirdz.Domain.Student
import com.example.andoirdz.Presenter.Activity.StudentsActivity
import com.example.andoirdz.Presenter.Fragment.StudentDetailFragment
import com.example.andoirdz.Presenter.Fragment.StudentsFragment
import com.example.andoirdz.Presenter.ViewHolder.StudentHolder
import com.example.andoirdz.Presenter.ViewHolder.StudentHolderWithPhoto
import com.example.andoirdz.R

class StudentsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder> {

    var context: Context? = null
    var students: List<Student>
    val NOTE_WITH_PHOTO = 1
    val NOTE_WITHOUT_PHOTO = 2

    constructor(context: Context?, students: ArrayList<Student>) {
        this.context = context
        this.students = students
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            NOTE_WITH_PHOTO -> return StudentHolderWithPhoto(
                LayoutInflater.from(context)
                    .inflate(R.layout.viewholder_with_photo_student, parent, false)
            )
            else -> return StudentHolder(
                LayoutInflater.from(context).inflate(R.layout.viewholder_student, parent, false)
            )
        }

    }

    override fun getItemCount(): Int {
        return students?.size ?: 0
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            NOTE_WITH_PHOTO -> {
                (holder as StudentHolderWithPhoto).initiateBind(students.get(position))

                (holder as StudentHolderWithPhoto).itemView.setOnClickListener(View.OnClickListener {
                    val bundle = Bundle()
                    val fragment = StudentDetailFragment();
                    bundle.putSerializable("StudentDetailsFragment", students.get(position))
                    fragment.setArguments(bundle)
                    val fragmentManager: FragmentManager = (context as StudentsActivity).fragmentMenager
                    fragmentManager?.beginTransaction()?.add(
                        R.id.relativelayout_activity_students_fragment_container,
                        fragment, "StudentDetailFragment"
                    )
                        ?.hide((context as StudentsActivity).fragmentMenager.findFragmentByTag("StudentsFragment") as StudentsFragment)
                        ?.addToBackStack(null)
                        ?.commit()
                })
            }
            else -> {
                (holder as StudentHolder).initiateBind(students.get(position))

                (holder as StudentHolder).itemView.setOnClickListener(View.OnClickListener {
                    val bundle = Bundle()
                    val fragment = StudentDetailFragment();
                    bundle.putParcelable("StudentDetailsFragment", students.get(position))
                    fragment.setArguments(bundle)
                    val fragmentManager: FragmentManager = (context as StudentsActivity).fragmentMenager
                    fragmentManager?.beginTransaction()?.add(
                        R.id.relativelayout_activity_students_fragment_container,
                        fragment, "StudentDetailFragment"
                    )
                        ?.hide((context as StudentsActivity).fragmentMenager.findFragmentByTag("StudentsFragment") as StudentsFragment)
                        ?.addToBackStack(null)
                        ?.commit()
                })
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if(students[position].avatar != null) NOTE_WITH_PHOTO
        else NOTE_WITHOUT_PHOTO
    }
}