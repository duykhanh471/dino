package vn.onlyduyy.onlytoodoo.database

import androidx.lifecycle.LiveData
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import vn.onlyduyy.onlytoodoo.utils.TaskEvent
import javax.inject.Inject

class TaskRepository @Inject constructor(val taskDao: TaskDao) {
//    private val taskEventChannel = Channel<TaskEvent>()

    suspend fun insertTask(task: TaskEntity) {
        taskDao.insertTask(task)
    }
    suspend fun deleteTask(task: TaskEntity) {
        taskDao.deleteTask(task)
    }
    suspend fun updateTask(task: TaskEntity) {
        taskDao.updateTask(task)
    }
//    suspend fun undoDeleted(task: TaskEntity) {
//        taskEventChannel.send(TaskEvent.UndoDeletedSwipeTask(task))
//    }
}