package vn.onlyduyy.onlytoodoo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import vn.onlyduyy.onlytoodoo.R
import vn.onlyduyy.onlytoodoo.database.TaskEntity
import vn.onlyduyy.onlytoodoo.databinding.TaskUpdateBinding
import vn.onlyduyy.onlytoodoo.viewmodel.TaskViewModel

@AndroidEntryPoint

class TaskUpdateFragment : Fragment(R.layout.task_update) {
    private lateinit var binding: TaskUpdateBinding
    private lateinit var currentTask: TaskEntity
    private val viewModel : TaskViewModel by viewModels()
    private val args: TaskUpdateFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = TaskUpdateBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        currentTask = args.TaskEntry!!
        binding.etTaskUpdate.setText(currentTask.taskName)
        binding.updateFab.setOnClickListener {
            updateTask()
            it.findNavController().navigate(R.id.action_taskUpdateFragment_to_dashboardFragment)
        }
    }
    private fun updateTask() {
        val taskTitle: String = binding.etTaskUpdate.text.toString()
        val completed: Boolean = false
        if (binding.etTaskUpdate.text.isNotEmpty()) {
            val task = TaskEntity(currentTask.id, taskTitle, completed)
            viewModel.updateTask(task)
            Snackbar.make(requireView(), "Updated!", Snackbar.LENGTH_SHORT).show()

        } else {
            Snackbar.make(requireView(), "Please add the task name!", Snackbar.LENGTH_SHORT).show()
        }

    }

}