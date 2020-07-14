package com.example.andoirdz.Presenter.Fragment

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.andoirdz.Domain.Student
import com.example.andoirdz.R
import kotlinx.android.synthetic.main.fragment_student_details.*

class StudentDetailFragment : Fragment(), View.OnClickListener {


    var student: Student? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments.let {
            student = it?.getParcelable("StudentDetailsFragment")
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_student_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews(view)
        initializeListeners()
    }


    fun initializeViews(view:View){

        fragment_students_detail_text_view_first_name_text?.text = student?.name
        fragment_students_detail_text_view_detail_text?.text = student?.description
        fragment_students_detail_text_view_mark_text.text = student?.mark.toString()
        fragment_students_detail_text_view_date_text.text = student?.date.toString()
        fragment_students_detail_text_view_group_text.text = student?.studentGroup
        fragment_students_detail_image.setImageBitmap(student?.avatar)

    }

    fun initializeListeners()
    {
        button_Back_fragment_students_detail.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.button_Back_fragment_students_detail -> {
                val fragmentManager = fragmentManager
                fragmentManager?.popBackStack()
            }
        }
    }

}