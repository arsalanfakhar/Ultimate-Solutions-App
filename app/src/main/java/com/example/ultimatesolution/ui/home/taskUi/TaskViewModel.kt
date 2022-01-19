package com.example.ultimatesolution.ui.home.taskUi

import androidx.lifecycle.ViewModel
import com.example.ultimatesolution.database.TaskDetail
import com.example.ultimatesolution.repository.UltimateSolutionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val repository: UltimateSolutionRepository
) : ViewModel() {

    //Setup
    private val disposeBag: CompositeDisposable by lazy { CompositeDisposable() }

    private var taskId = 0;

    fun setTaskId(taskId: Int) {
        this.taskId = taskId;
    }

    fun getTaskId(): Int = taskId;

    fun addTask(taskDetail: TaskDetail) {
        repository.addTask(taskDetail)
    }

}