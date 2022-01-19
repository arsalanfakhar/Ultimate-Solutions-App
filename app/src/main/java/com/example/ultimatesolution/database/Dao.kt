package com.example.ultimatesolution.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single

@Dao
interface TasksDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(task: TaskDetail): Single<Long>

    @Query("SELECT * from TaskDetail ORDER BY dateCreated DESC")
    fun getAllTasks():Flowable<List<TaskDetail>>

}