package com.example.andoirdz.Presenter.Fragment

import android.Manifest
import android.app.Activity.RESULT_OK
import android.app.DatePickerDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.example.andoirdz.Presenter.Contract.IStudentFragmentContract
import com.example.andoirdz.Domain.Student
import com.example.andoirdz.R
import kotlinx.android.synthetic.main.fragment_students_add_student.*
import java.util.*
import kotlin.collections.ArrayList

class StudentAddFragment : Fragment(), View.OnClickListener, IStudentFragmentContract.View {

    var student: Student? = null
    var selectDate = Calendar.getInstance()
    val year = selectDate.get(Calendar.YEAR)
    val month = selectDate.get(Calendar.MONTH)
    val day = selectDate.get(Calendar.DAY_OF_MONTH)
    var date: String? = null
    var group : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments.let {
            group = it?.getString("group").toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.fragment_students_add_student, container, false)
        return view;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeListeners()
    }

    override fun initializeViews() {
    }

    override fun initializeListeners() {
        button_fragment_student_cancel_add.setOnClickListener(this)
        button_fragment_student_add_student.setOnClickListener(this)
        button_fragment_student_add_date.setOnClickListener(this)
        button_fragment_student_add_photo.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button_fragment_student_cancel_add -> {
                val fragmentManager = fragmentManager
                fragmentManager?.popBackStack()

            }
            R.id.button_fragment_student_add_date -> {
                val datePickerDialog = activity?.let {
                    DatePickerDialog(
                        it,
                        DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                            textview_fragment_student_add_show_date.setText(dayOfMonth.toString() + ":" + (monthOfYear + 1).toString() + ":" + year.toString())
                            date = getDate(year, monthOfYear, dayOfMonth)
                        },
                        year,
                        month,
                        day
                    )
                }
                datePickerDialog?.show()
            }

            R.id.button_fragment_student_add_student -> {
                var image: Bitmap? = null
                when {
                    edittext_fragment_student_add_write_name.text.toString().isEmpty() -> {
                        edittext_fragment_student_add_write_name.setText("Write name")
                    }
                    edittext_fragment_student_add_write_description.text.toString().isEmpty() -> {
                        edittext_fragment_student_add_write_description.setText("Write description about student")
                    }
                    edittext_fragment_student_add_write_mark.text.toString().isEmpty() -> {
                        edittext_fragment_student_add_write_mark.setText("Write mark")
                    }
                    else -> {
                        if (imageview_fragment_add_student?.drawable is BitmapDrawable) {
                            image =
                                (imageview_fragment_add_student?.drawable as BitmapDrawable).bitmap
                            var student: Student =
                                Student(
                                    edittext_fragment_student_add_write_name.text.toString(),
                                    edittext_fragment_student_add_write_description.text.toString(),
                                    edittext_fragment_student_add_write_mark.text.toString().toFloat(),
                                    this.date,
                                    this.group,
                                    image
                                )

                            val fragment =
                                fragmentManager?.findFragmentByTag("StudentsFragment") as StudentsFragment

                            fragment.presenter.initiateAddNewStudent(student)
                            fragment.presenter.initiateSortStudentsByName()
                            fragment.initializeAdapter()

                            val fragmentManager = fragmentManager
                            fragmentManager?.popBackStack()
                        }
                    }
                }
            }
            R.id.button_fragment_student_add_photo -> {
                if (ActivityCompat.checkSelfPermission(
                        context!!,
                        Manifest.permission.READ_EXTERNAL_STORAGE
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 2000)
                } else {
                    val cameraIntent =
                        Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                    cameraIntent.type = "image/*"
                    startActivityForResult(cameraIntent, 1000)
                }

            }

        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == RESULT_OK) {
            if (requestCode == 1000) {
                val returnUri: Uri? = data?.getData()
                val bitmapImage: Bitmap =
                    MediaStore.Images.Media.getBitmap(activity?.getContentResolver(), returnUri)
                imageview_fragment_add_student?.setImageBitmap(bitmapImage)
            }
        }
    }

    fun getDate(year: Int, month: Int, day: Int): String {
        var months = (month + 1)
        var date = "$year:$months:$day"
        return date
    }


    override fun initializePresenter() {
    }

    override fun initializeLayoutManager() {
        TODO("Not yet implemented")
    }

    override fun initializeAdapter() {
        TODO("Not yet implemented")
    }

    override fun initiateUpdateAdapter() {
        TODO("Not yet implemented")
    }

    override fun processData(students: ArrayList<Student>) {
        TODO("Not yet implemented")
    }


    override fun initializeArguments() {
        TODO("Not yet implemented")
    }

    override fun initializeDependencies() {
        TODO("Not yet implemented")
    }
}