package vn.onlyduyy.onlytoodoo.utils

import vn.onlyduyy.onlytoodoo.database.TaskEntity

sealed class TaskEvent {
    data class UndoDeletedSwipeTask(val task: TaskEntity) : TaskEvent()
}
