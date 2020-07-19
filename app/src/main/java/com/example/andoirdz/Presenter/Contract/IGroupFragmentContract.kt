package com.example.andoirdz.Presenter.Contract

import com.example.andoirdz.Domain.Student
import com.example.andoirdz.Domain.StudentsGroup
import com.example.myapplication.Presentation.Base.BaseContract

interface IGroupFragmentContract {

    interface View : BaseContract.BaseView{
        fun initializePresenter()

        fun initializeLayoutManager()

        fun initializeAdapter()

        fun initiateUpdateAdapter()

        fun processData(groups: ArrayList<StudentsGroup>)

    }

    interface Presenter : BaseContract.BasePresenter<View>{
        fun initializeData()

        fun initiateAddNewGroup(group: StudentsGroup)
    }
}