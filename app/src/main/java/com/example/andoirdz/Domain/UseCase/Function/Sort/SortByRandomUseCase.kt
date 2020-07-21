package com.example.andoirdz.Domain.UseCase.Function.Sort

import com.example.andoirdz.Domain.Student

class SortByRandomUseCase {
    companion object {
        fun initiateSortRandom(array: ArrayList<Student>): ArrayList<Student> {
            return array.apply { shuffle() }
        }
    }
}