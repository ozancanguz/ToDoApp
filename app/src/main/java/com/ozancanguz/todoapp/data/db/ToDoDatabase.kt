package com.ozancanguz.todoapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ozancanguz.todoapp.data.model.ToDo
import com.ozancanguz.todoapp.utils.Constants.Constants.Companion.DATABASE_NAME

@Database(entities = [ToDo::class], version = 1, exportSchema = true)
abstract class ToDoDatabase: RoomDatabase() {

    // get reference for dao
    abstract fun todoDao():ToDoDao

    companion object{
        @Volatile
        private var INSTANCE: ToDoDatabase? = null


        fun getDatabase(context: Context): ToDoDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ToDoDatabase::class.java,
                    DATABASE_NAME
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }





}