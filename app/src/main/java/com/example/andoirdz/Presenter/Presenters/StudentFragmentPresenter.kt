package com.example.andoirdz.Presenter.Presenters

import com.example.andoirdz.Domain.Student
import com.example.andoirdz.Domain.StudentsGroup
import com.example.andoirdz.Domain.StudentsSortUseCase
import com.example.andoirdz.Presenter.Contract.StudentFragmentContract

class StudentFragmentPresenter : StudentFragmentContract.Presenter{

    var view : StudentFragmentContract.View? = null
    var studentsSortUseCase : StudentsSortUseCase

    var students : ArrayList<Student> = ArrayList()


    constructor()
    {
        this.studentsSortUseCase =
            StudentsSortUseCase()
    }

    override fun initializeData(student : ArrayList<Student>) {
        this.students.clear()
        this.students.addAll(student)
        view?.processData(students)
        view?.initiateUpdateAdapter()
    }


    override fun initiateSortStudentsByName() {
        studentsSortUseCase.initiateSortStudentsByName(students)
        view?.processData(students)

    }

    override fun initiateSortStudentsByMark()
    {
        studentsSortUseCase.initiateSortStudentsByMark(students)
        view?.processData(students)
        view?.initializeAdapter()
    }

    override fun initiateSortStudentsRandom() {
        studentsSortUseCase.initiateSortStudentsRandom(students)
        view?.processData(students)
        view?.initializeAdapter()
    }

    override fun initiateFindStudentByName(name :String) {
        var arrayList : ArrayList<Student> = ArrayList()
        var temp = students.find{student -> student.name.toUpperCase().equals(name.toUpperCase()) }

        if(temp != null)
        {
            arrayList.add(temp)
            view?.processData(arrayList)
            view?.initializeAdapter()
        }
        else
        {
            view?.processData(students)
            view?.initializeAdapter()
        }
    }


    override fun initiateAddNewStudent(student: Student) {
        students.add(student)
        view?.processData(students)
        view?.initiateUpdateAdapter()
    }

    override fun attach(view: StudentFragmentContract.View) {
        this.view = view
    }

    override fun onStop() {
        view = null
    }

}