package vn.onlyduyy.onlytoodoo.adapter

import androidx.recyclerview.widget.RecyclerView
import vn.onlyduyy.onlytoodoo.database.TaskEntity
import vn.onlyduyy.onlytoodoo.databinding.TaskViewBinding

class TaskViewHolder(private val binding: TaskViewBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(task: TaskEntity) {
        binding.apply {
            tvTaskName.text = task.taskName
            isDone.isChecked = task.isDone
        }
    }
}