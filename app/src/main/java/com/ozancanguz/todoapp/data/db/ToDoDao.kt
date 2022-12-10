package com.ozancanguz.todoapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ozancanguz.todoapp.data.model.ToDo

@Dao
interface ToDoDao {


    // get all data as live data
    @Query("select * from todo_table order by id ASC")
    fun getAllData(): LiveData<List<ToDo>>

    // insert
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertData(todo:ToDo)




}