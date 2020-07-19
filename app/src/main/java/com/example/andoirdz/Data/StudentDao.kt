package com.example.andoirdz.Data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.andoirdz.Data.StudentsGroup

//practic 17
@Dao
public interface StudentDao {

    @Query("SELECT * FROM student")
    fun initiateGetAllStudents() : List<Student>

    @Query("SELECT * FROM studentsgroup")
    fun initiateGetAllGroups() : List<StudentsGroup>

    @Query("SELECT * FROM student WHERE name IS :nameId")
    fun initiateGetStudentById(nameId: String) : Student

    @Query("SELECT * FROM student WHERE studentGroup IS :groupId")
    fun initiateGetStudentsByGroup(groupId: String) : List<Student>

    @Query("DELETE FROM student")
    fun initiateDeleteAllStudents()

    @Query("DELETE FROM studentsgroup")
    fun initiateDeleteAllGroups()

    @Query("DELETE FROM student WHERE name IS :name")
    fun initiateDeleteStudentById(name : String)

    @Query("DELETE FROM StudentsGroup WHERE groupId IS :groupId")
    fun initiateDeleteGroupById(groupId: String)

    @Insert
    fun initiateInsertStudent(student: Student)

    @Insert
    fun initiateInsertStudents(students : List<Student>)

    @Insert
    fun initiateInsertGroup(group : StudentsGroup)

    @Insert
    fun initiateInsertGroups(groups : List<StudentsGroup>)

}