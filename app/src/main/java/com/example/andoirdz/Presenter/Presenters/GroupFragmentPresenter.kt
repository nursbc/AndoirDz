package com.example.andoirdz.Presenter.Presenters

import com.example.andoirdz.Domain.Student
import com.example.andoirdz.Domain.StudentsGroup
import com.example.andoirdz.Presenter.Contract.IGroupFragmentContract

class GroupFragmentPresenter : IGroupFragmentContract.Presenter {

    var view: IGroupFragmentContract.View? = null

    var groupStudents: ArrayList<StudentsGroup> = ArrayList()

    var students: ArrayList<Student> = ArrayList()

    override fun initializeData() {

        students.apply {
            add(
                Student(
                    "Adam",
                    "Good Student",
                    5.0F,
                    "1"
                )
            )
            add(
                Student(
                    "Zoe",
                    "Avarage Student",
                    mark = 2.0F,
                    studentGroup = "1"
                )
            )
            add(
                Student(
                    "Gendalf",
                    "Good Student",
                    mark = 5.0F,
                    studentGroup = "2"
                )
            )
            add(
                Student(
                    "Geralt",
                    "Good Student",
                    mark = 2.0F,
                    studentGroup = "2"
                )
            )

        }

        view?.processData(groupStudents.apply {
            add(
                StudentsGroup("1", students.filter { student -> student.studentGroup == "1"  } as ArrayList<Student>)
            )
            add(
                StudentsGroup("2", students.filter { student -> student.studentGroup == "2" } as ArrayList<Student>)
            )
        })

        view?.initiateUpdateAdapter()
    }

    override fun initiateAddNewGroup(group: StudentsGroup) {
        TODO("Not yet implemented")
    }

    override fun attach(view: IGroupFragmentContract.View) {
        this.view = view
    }

    override fun onStop() {
        this.view = null
    }

}