package com.example.andoirdz.Contract

import com.example.andoirdz.Domain.Student
import com.example.myapplication.Presentation.Base.BaseContract


interface StudentFragmentContract {

    interface View : BaseContract.BaseView{
        fun initializePresenter()

        fun initializeLayoutManager()

        fun initializeAdapter()

        fun initiateUpdateAdapter()

        fun processData(students: ArrayList<Student>)

    }

    interface Presenter : BaseContract.BasePresenter<View>{
        fun initializeData()

        fun initiateSortStudentsByName()

        fun initiateSortStudentsByMark()

        fun initiateSortStudentsRandom()

        fun initiateFindStudentByName(name :String)

        fun initiateAddNewStudent(student: Student)
    }



}