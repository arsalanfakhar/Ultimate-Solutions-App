package com.example.ultimatesolution.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class TaskDetail(
    @PrimaryKey(autoGenerate = true) var id: Int=0,
    var work_type:String,
    var work_description:String,
    var inventory:String,
    var budget:Int,
    var location:String,
    var dateCreated: Date
){


}