package com.example.andoirdz.Presenter.Contract

import com.example.andoirdz.Domain.Student
import com.example.andoirdz.Domain.StudentsGroup
import com.example.myapplication.Presentation.Base.BaseContract


interface IStudentFragmentContract {

    interface View : BaseContract.BaseView{
        fun initializePresenter()

        fun initializeLayoutManager()

        fun initializeAdapter()

        fun initiateUpdateAdapter()

        fun processData(students: ArrayList<Student>)


    }

    interface Presenter : BaseContract.BasePresenter<View>{
        fun initializeData(students : ArrayList<Student>)

        fun initiateSortStudentsByName()

        fun initiateSortStudentsByMark()

        fun initiateSortStudentsRandom()

        fun initiateFindStudentByName(name :String)

        fun initiateAddNewStudent(student: Student)
    }



}