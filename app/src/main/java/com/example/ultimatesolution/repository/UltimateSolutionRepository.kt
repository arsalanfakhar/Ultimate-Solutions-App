package com.example.ultimatesolution.repository

import com.example.ultimatesolution.database.AppDatabase
import com.example.ultimatesolution.database.TaskDetail
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class UltimateSolutionRepository(
    private val database: AppDatabase
) {


    fun addTask(task: TaskDetail): Single<Long> {
        val call = database.getTasksDao().upsert(task)

        return call.observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }

    fun getAllTask(): Flowable<List<TaskDetail>> {
        val call = database.getTasksDao().getAllTasks()

        return call.observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }


}