package com.ozancanguz.todoapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ozancanguz.todoapp.data.model.ToDo

@Dao
interface ToDoDao {


    // get all data as live data
    @Query("select * from todo_table order by id ASC")
    fun getAllData(): LiveData<List<ToDo>>

    // insert
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertData(todo:ToDo)

    // update
    @Update
    suspend fun updateData(todo: ToDo)

    // delete
    @Delete
    suspend fun deleteSingleItem(todo: ToDo)

    @Query("delete from todo_table")
    suspend fun deleteAllItems()

    @Query("select * from todo_table where title like  :searchQuery")
    fun searchDatabase(searchQuery:String):LiveData<List<ToDo>>




}