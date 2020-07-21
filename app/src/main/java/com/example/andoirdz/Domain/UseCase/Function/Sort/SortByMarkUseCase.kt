package com.example.andoirdz.Domain.UseCase.Function.Sort

import com.example.andoirdz.Domain.Student

class SortByMarkUseCase {
    companion object {
        fun initiateSortByMark(students: ArrayList<Student>): ArrayList<Student> {
            return students.apply { sortByDescending { student -> student.mark } }
        }
    }
}