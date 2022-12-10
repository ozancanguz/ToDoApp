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

    // update data to repo
    suspend fun updateData(toDo: ToDo){
        return toDoDao.updateData(toDo)
    }

    // delete data to repo
    suspend fun deleteSingleItem(toDo: ToDo){
        return toDoDao.deleteSingleItem(toDo)
    }

    // delete all items
    suspend fun deleteAllItems(){
        return toDoDao.deleteAllItems()
    }

    fun searchQuery(searchQuery:String):LiveData<List<ToDo>>{
        return toDoDao.searchDatabase(searchQuery)
    }





}