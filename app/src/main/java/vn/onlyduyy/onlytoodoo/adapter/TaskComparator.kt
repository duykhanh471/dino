package vn.onlyduyy.onlytoodoo.adapter

import androidx.recyclerview.widget.DiffUtil
import vn.onlyduyy.onlytoodoo.database.TaskEntity

class TaskComparator : DiffUtil.ItemCallback<TaskEntity>() {
    override fun areItemsTheSame(oldItem: TaskEntity, newItem: TaskEntity): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: TaskEntity, newItem: TaskEntity): Boolean =
        oldItem.id == newItem.id && oldItem.taskName == newItem.taskName && oldItem.isDone == newItem.isDone
}
