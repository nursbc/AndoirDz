package com.example.andoirdz.Domain

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable

@SuppressLint("ParcelCreator")
class StudentsGroup() : Parcelable {
    var title : String = ""
    var students : ArrayList<Student> = ArrayList()

    constructor(parcel: Parcel) : this() {
        title = parcel.readString().toString()
    }

    constructor(title : String) : this() {
        this.title = title
    }

    constructor(title : String, student : Student) : this() {
        this.title = title
        this.students.add(student)
    }

    constructor(title : String, students : ArrayList<Student>) : this() {
        this.title = title
        this.students.addAll(students)
    }

    fun addStudent(student : Student)
    {
        students.add(student)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<StudentsGroup> {
        override fun createFromParcel(parcel: Parcel): StudentsGroup {
            return StudentsGroup(parcel)
        }

        override fun newArray(size: Int): Array<StudentsGroup?> {
            return arrayOfNulls(size)
        }
    }
}