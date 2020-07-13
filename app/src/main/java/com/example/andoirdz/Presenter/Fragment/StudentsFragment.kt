package com.example.andoirdz.Presenter.Fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.andoirdz.Domain.Student
import com.example.andoirdz.Contract.StudentFragmentContract
import com.example.andoirdz.Presenter.Adapter.StudentsAdapter
import com.example.andoirdz.Presenter.Presenters.StudentFragmentPresenter
import com.example.andoirdz.R
import kotlinx.android.synthetic.main.fragment_students.*

class StudentsFragment : Fragment(), View.OnClickListener, StudentFragmentContract.View {

    var rootView: View? = null

    var students: ArrayList<Student> = ArrayList()

    var studentsAdapter: StudentsAdapter? = null

    lateinit var presenter : StudentFragmentPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.fragment_students, container, false)

        return view;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeViews()
        initializeListeners()
        initializePresenter()
        initializeLayoutManager()
        initializeAdapter()
        presenter.initializeData()
    }

    @SuppressLint("ResourceType")
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.button_fragment_student_sortbyname -> {
                presenter.initiateSortStudentsByName()
                initializeAdapter()
            }
            R.id.button_fragment_student_sortbymark ->{
                presenter.initiateSortStudentsByMark()
                initializeAdapter()
            }
            R.id.button_fragment_student_randomsort -> {
                presenter.initiateSortStudentsRandom()
                initializeAdapter()
            }
            R.id.button_fragment_student_searchstudent -> {
                presenter.initiateFindStudentByName(edittext_fragment_student_searchstudent.text.toString())
                initializeAdapter()
            }
            R.id.button_fragment_student_add_new_student -> {
                val fragmentManager = fragmentManager
                fragmentManager?.beginTransaction()?.add(
                    R.id.relativelayout_activity_students_fragment_container, StudentAddFragment(), "StudentAddStudent")
                    ?.hide(this)
                    ?.addToBackStack(null)
                    ?.commit()
            }

        }
    }

    override fun initializeViews(){
        recyclerview_fragment_students?.visibility = View.VISIBLE
        edittext_fragment_student_searchstudent?.visibility = EditText.VISIBLE
    }

    override fun initializePresenter() {
        presenter = StudentFragmentPresenter()
        presenter.attach(this)
    }

    override fun initializeLayoutManager(){
        recyclerview_fragment_students?.layoutManager = LinearLayoutManager(context)
        //recyclerViewStudents?.layoutManager = LinearLayoutManager(context)
    }

    override fun initializeAdapter(){
        studentsAdapter = StudentsAdapter(context, students)
        recyclerview_fragment_students?.adapter = studentsAdapter
        //recyclerViewStudents?.adapter = studentsAdapter
    }

    override fun processData(students: ArrayList<Student>) {
        this.students.clear()
        this.students.addAll(students)
    }

    override fun initializeListeners() {
        button_fragment_student_sortbyname?.setOnClickListener(this)
        button_fragment_student_sortbymark?.setOnClickListener(this)
        button_fragment_student_randomsort?.setOnClickListener(this)
        button_fragment_student_searchstudent?.setOnClickListener(this)
        button_fragment_student_add_new_student?.setOnClickListener(this)
    }


    override fun initiateUpdateAdapter() {
        studentsAdapter?.notifyDataSetChanged()
    }



    override fun initializeArguments() {
        TODO("Not yet implemented")
    }

    override fun initializeDependencies() {
        TODO("Not yet implemented")
    }


}