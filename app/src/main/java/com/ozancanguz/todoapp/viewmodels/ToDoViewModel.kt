package com.ozancanguz.todoapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.ozancanguz.todoapp.data.db.ToDoDatabase
import com.ozancanguz.todoapp.data.model.ToDo
import com.ozancanguz.todoapp.data.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ToDoViewModel(application: Application):AndroidViewModel(application) {

    // get dao ref
    private val toDoDao=ToDoDatabase.getDatabase(application).todoDao()

    //get repository ref
    private val repository = Repository(toDoDao)

    //get all data list
    val getAllData: LiveData<List<ToDo>>

    // init get all data
    init {
        getAllData=repository.getAllData
    }

     // inserting data with background thread
    fun insertData(toDo: ToDo){
        viewModelScope.launch(Dispatchers.IO){
            repository.insertData(toDo)
        }
    }

    // updating data with backgroun thread
    fun updateData(toDo: ToDo){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateData(toDo)
        }
    }

    // deletin single item
    fun deleteSingleItem(toDo: ToDo){
        viewModelScope.launch {
            repository.deleteSingleItem(toDo)
        }

    }

    // delete all items
    fun deleteAllItems(){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteAllItems()
        }
    }

    // search database with query
    fun searchDatabase(searchQuery:String):LiveData<List<ToDo>>{

       return repository.searchQuery(searchQuery)

    }




}