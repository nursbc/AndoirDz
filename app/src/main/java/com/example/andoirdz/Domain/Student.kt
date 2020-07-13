package com.example.andoirdz.Domain

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parceler
import java.io.Serializable

@SuppressLint("ParcelCreator")
class Student() : Serializable, Parcelable {

    var name : String = ""
    var description : String = ""
    var mark : Float = 0.0F
    var date: String? = null
    var studentGroup: String = ""
    var avatar: Bitmap? = null

    constructor(parcel: Parcel) : this() {
        name = parcel.readString().toString()
        description = parcel.readString().toString()
        mark = parcel.readFloat()
        date = parcel.readString()
        avatar = parcel.readParcelable(Bitmap::class.java.classLoader)
    }

    constructor(name: String, description : String, mark : Float, avatar : Bitmap? = null) : this() {
        this.name = name
        this.description = description
        this.mark = mark
        this.avatar = avatar
    }

    constructor(name: String, description : String, mark : Float, date : String?, studentGroup : String, avatar : Bitmap? = null) : this() {
        this.name = name
        this.description = description
        this.mark = mark
        this.date = date
        this.studentGroup = studentGroup
        this.avatar = avatar
    }

    fun getnDate(): String? {
        return this.date
    }
    companion object : Parceler<Student> {

        override fun Student.write(parcel: Parcel, flags: Int) {
            parcel.writeString(name)
            parcel.writeString(description)
            parcel.writeFloat(mark)
            parcel.writeString(date.toString())
            parcel.writeString(studentGroup)
            parcel.writeValue(avatar)
        }

        override fun create(parcel: Parcel): Student {
            return Student(parcel)
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeFloat(mark)
        parcel.writeString(date.toString())
        parcel.writeString(studentGroup)
        parcel.writeValue(avatar)
    }

    override fun describeContents(): Int {
        return 0
    }


}