package com.example.andoirdz.Domain

import com.example.andoirdz.Domain.UseCase.Function.Sort.SortByMarkUseCase
import com.example.andoirdz.Domain.UseCase.Function.Sort.SortByNameUseCase
import com.example.andoirdz.Domain.UseCase.Function.Sort.SortByRandomUseCase
import kotlin.collections.ArrayList

class StudentsSortUseCase {

    fun initiateSortStudentsByName(students: ArrayList<Student>): ArrayList<Student> {
        return SortByNameUseCase.initiateSortByName(students)

    }

    fun initiateSortStudentsByMark(students: ArrayList<Student>): ArrayList<Student> {

        return SortByMarkUseCase.initiateSortByMark(students)
    }

    fun initiateSortStudentsRandom(students: ArrayList<Student>): ArrayList<Student> {

        return SortByRandomUseCase.initiateSortRandom(students)
    }
}