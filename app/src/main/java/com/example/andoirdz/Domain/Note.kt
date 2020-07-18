package com.example.andoirdz.Domain

import android.os.Parcel
import android.os.Parcelable
import java.time.DateTimeException
import java.util.*

class Note : Parcelable {

    var date: String? = null
    var description: String = ""
    var head: String = "";

    var selectDate = Calendar.getInstance()
    val year = selectDate.get(Calendar.YEAR)
    val month = selectDate.get(Calendar.MONTH)
    val day = selectDate.get(Calendar.DAY_OF_MONTH)

    constructor(parcel: Parcel) : this() {
        description = parcel.readString().toString()
        head = parcel.readString().toString()
    }

    constructor()
    constructor(description: String, head: String)
    {
        date = getDate(year, month, day)
        this.description = description
        this.head = head
    }
    constructor(date: String, description: String, head: String)
    {
        this.date = date
        this.description = description
        this.head = head
    }


    fun getDate(year: Int, month: Int, day: Int): String {
        var months = month + 1
        var date = "$year:$months:$day"
        return date
    }


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(description)
        parcel.writeString(head)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Note> {
        override fun createFromParcel(parcel: Parcel): Note {
            return Note(parcel)
        }

        override fun newArray(size: Int): Array<Note?> {
            return arrayOfNulls(size)
        }
    }
}

