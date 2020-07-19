package com.example.andoirdz.Data

import androidx.room.Database
import androidx.room.RoomDatabase

//practic 17
@Database(entities = arrayOf(Student::class, StudentsGroup::class), version = 2)
abstract class AndroiDzDatabase : RoomDatabase() {
    abstract fun getStudentDao(): StudentDao

}