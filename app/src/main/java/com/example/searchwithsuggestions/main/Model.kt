package com.mrk.compaq.application.local.ui.main

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "localquery",indices =[Index(value = ["query"],unique = true)])
data class Model(

        val query: String
){
    @PrimaryKey(autoGenerate = true)
    var id:Int=0

}
