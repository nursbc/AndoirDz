package com.example.andoirdz.Data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import com.example.andoirdz.Data.StudentsGroup
import java.util.*

//dz17
@Entity(foreignKeys = arrayOf(
    ForeignKey(
    entity = StudentsGroup::class,
    parentColumns = arrayOf("groupId"),
    childColumns = arrayOf("studentGroup"),
    onDelete = CASCADE)
))
class Student {

    @PrimaryKey
    var name : String = ""
    var description : String = ""
    var mark : Float = 0.0F
    var date: String = ""
    var studentGroup: String = ""

    constructor()

    constructor(name: String, description: String, mark: Float, studentGroup: String) {
        this.name = name
        this.description = description
        this.mark = mark
        this.studentGroup = studentGroup
    }

    constructor(name: String, description: String, mark: Float, date: String, studentGroup: String) {
        this.name = name
        this.description = description
        this.mark = mark
        this.date = date
        this.studentGroup = studentGroup
    }

    override fun toString(): String {
        return "Student(name='$name', description='$description', mark=$mark, date='$date', studentGroup='$studentGroup')"
    }


}