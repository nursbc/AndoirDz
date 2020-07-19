package com.example.andoirdz.Data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class StudentsGroup {

    @PrimaryKey
    var groupId: String = ""

    override fun toString(): String {
        return "StudentsGroup(groupId='$groupId')"
    }
}