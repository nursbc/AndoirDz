package com.example.andoirdz.Presenter.Presenters

import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import com.example.andoirdz.Domain.Student
import com.example.andoirdz.Domain.StudentsSortUseCase
import com.example.andoirdz.Contract.StudentFragmentContract

class StudentFragmentPresenter : StudentFragmentContract.Presenter{

    var view : StudentFragmentContract.View? = null
    var studentsSortUseCase : StudentsSortUseCase

    var students : ArrayList<Student> = ArrayList()


    constructor()
    {
        this.studentsSortUseCase =
            StudentsSortUseCase()
    }

    override fun initializeData() {
        view?.processData(students.apply {
            add(
                Student(
                    "Adam",
                    "Good Student",
                    mark = 5.0F
                    )
            )
            add(
                Student(
                    "Eve",
                    "Bad Student",
                    mark = 4.0F
                )
            )
            add(
                Student(
                    "Bill",
                    "Avarage Student",
                    mark = 3.0F
                )
            )
            add(
                Student(
                    "Zoe",
                    "Avarage Student",
                    mark = 2.0F
                )
            )
            add(
                Student(
                    "Grizli",
                    "Bad Student",
                    mark = 4.0F
                )
            )
            add(
                Student(
                    "Chupakabra",
                    "Bad Student",
                    mark = 4.0F
                )
            )
            add(
                Student(
                    "Dog",
                    "Good Student",
                    mark = 2.0F
                )
            )
            add(
                Student(
                    "Cat",
                    "Avarage Student",
                    mark = 3.0F
                )
            )
            add(
                Student(
                    "Sam",
                    "Good Student",
                    mark = 4.0F
                )
            )
            add(
                Student(
                    "Spider",
                    "Bad Student",
                    mark = 3.0F
                )
            )
            add(
                Student(
                    "Bender",
                    "bad Student",
                    mark = 1.0F
                )
            )
            add(
                Student(
                    "Gendalf",
                    "Good Student",
                    mark = 5.0F
                )
            )
            add(
                Student(
                    "Frodo",
                    "Avarage Student",
                    mark = 4.0F
                )
            )
            add(
                Student(
                    "Geralt",
                    "Good Student",
                    mark = 2.0F
                )
            )
            add(
                Student(
                    "Pig",
                    "Bad Student",
                    mark = 2.0F
                )
            )

        })
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