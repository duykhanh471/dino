package vn.onlyduyy.onlytoodoo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import vn.onlyduyy.onlytoodoo.database.TaskEntity
import vn.onlyduyy.onlytoodoo.database.TaskRepository
import vn.onlyduyy.onlytoodoo.utils.TaskEvent
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val taskRepository: TaskRepository
) : ViewModel() {
    val tasks = taskRepository.taskDao.retrieveAllTasks()

    fun insertTask(task: TaskEntity) = viewModelScope.launch(Dispatchers.IO) {
        taskRepository.insertTask(task)
    }
    fun deleteTask(task: TaskEntity) = viewModelScope.launch(Dispatchers.IO) {
        taskRepository.deleteTask(task)
    }
    fun updateTask(task: TaskEntity) = viewModelScope.launch(Dispatchers.IO) {
        taskRepository.updateTask(task)
    }

}