package com.example.andoirdz.Domain

import kotlin.collections.ArrayList

class StudentsSortUseCase {

    fun initiateSortStudentsByName(students: ArrayList<Student>) {
        students.sortBy { student -> student.name  }

/*        return students.sortedWith(compareBy( Student::name))*/
    }

    fun initiateSortStudentsByMark(students: ArrayList<Student>)  {

        return students.sortByDescending { student -> student.mark }
    }

    fun initiateSortStudentsRandom(students: ArrayList<Student>) {

        return students.shuffle();

/*        for(s in students)
        {
            temp.add(students.random())
        }

        return temp.toList()*/
    }
}