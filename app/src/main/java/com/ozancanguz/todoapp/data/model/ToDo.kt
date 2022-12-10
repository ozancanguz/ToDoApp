package com.ozancanguz.todoapp.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.RoomMasterTable.TABLE_NAME
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "todo_table")
data class ToDo(
    @PrimaryKey(autoGenerate = true)
    var id:Int=0,
    var title:String,
    var description:String

    ):Parcelable{


    }




