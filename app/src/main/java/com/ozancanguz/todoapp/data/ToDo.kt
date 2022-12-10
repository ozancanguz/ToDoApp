package com.ozancanguz.todoapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.RoomMasterTable.TABLE_NAME


@Entity(tableName = "todo_table")
data class ToDo(

    var title:String,
    var description:String
) {

    @PrimaryKey(autoGenerate = true)
    var id:Int=0
}