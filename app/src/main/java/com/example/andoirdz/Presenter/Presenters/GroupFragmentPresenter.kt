package com.example.andoirdz.Presenter.Presenters

import com.example.andoirdz.Domain.Student
import com.example.andoirdz.Domain.StudentsGroup
import com.example.andoirdz.Presenter.Contract.GroupFragmentContract

class GroupFragmentPresenter : GroupFragmentContract.Presenter {

    var view: GroupFragmentContract.View? = null

    var groupStudents: ArrayList<StudentsGroup> = ArrayList()

    var students: ArrayList<Student> = ArrayList()

    override fun initializeData() {

        students.apply {
            add(
                Student(
                    "Adam",
                    "Good Student",
                    mark = 5.0F
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
                    "Gendalf",
                    "Good Student",
                    mark = 5.0F
                )
            )
            add(
                Student(
                    "Geralt",
                    "Good Student",
                    mark = 2.0F
                )
            )

        }

        view?.processData(groupStudents.apply {
            add(
                StudentsGroup("1", students)
            )
            add(
                StudentsGroup("2", students)
            )
        })

        view?.initiateUpdateAdapter()
    }

    override fun initiateAddNewGroup(group: StudentsGroup) {
        TODO("Not yet implemented")
    }

    override fun attach(view: GroupFragmentContract.View) {
        this.view = view
    }

    override fun onStop() {
        this.view = null
    }

}