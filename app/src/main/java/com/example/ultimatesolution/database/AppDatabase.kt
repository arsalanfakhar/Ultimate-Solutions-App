package com.example.ultimatesolution.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = arrayOf(TaskDetail::class), version = 1, exportSchema = false
)

@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getTasksDao(): TasksDao

    companion object{
        val DATABASE_NAME = "UltimateSolutionsDatabase.db"
    }
}
