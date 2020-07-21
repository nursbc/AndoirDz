package com.example.andoirdz.Domain.UseCase.Function.Sort

import com.example.andoirdz.Domain.Student

class SortByNameUseCase {
    companion object {
        fun initiateSortByName(students: ArrayList<Student>): ArrayList<Student> {
            return students.apply { sortBy { student -> student.name } }
        }
    }
}