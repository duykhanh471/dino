package vn.onlyduyy.onlytoodoo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ListAdapter
import vn.onlyduyy.onlytoodoo.database.TaskEntity
import vn.onlyduyy.onlytoodoo.databinding.TaskViewBinding
import vn.onlyduyy.onlytoodoo.fragment.DashboardFragmentDirections

class TaskAdapter : ListAdapter<TaskEntity, TaskViewHolder>(TaskComparator()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = TaskViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)

        holder.itemView.setOnClickListener {
            val updateDirects = DashboardFragmentDirections.actionDashboardFragmentToTaskUpdateFragment(currentItem)
            it.findNavController().navigate(updateDirects)
        }
    }
}