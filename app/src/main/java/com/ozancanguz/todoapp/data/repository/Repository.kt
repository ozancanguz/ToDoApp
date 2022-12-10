package com.ozancanguz.todoapp.data.repository

import androidx.lifecycle.LiveData
import com.ozancanguz.todoapp.data.db.ToDoDao
import com.ozancanguz.todoapp.data.model.ToDo

class Repository(private val toDoDao: ToDoDao) {


    // get all data list from dao
    val getAllData: LiveData<List<ToDo>> = toDoDao.getAllData()


    // insert data to repository
    suspend fun insertData(toDo: ToDo){
        return toDoDao.insertData(toDo)
    }





}