package vn.onlyduyy.onlytoodoo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import vn.onlyduyy.onlytoodoo.R
import vn.onlyduyy.onlytoodoo.database.TaskEntity

import vn.onlyduyy.onlytoodoo.databinding.TaskEditBinding
import vn.onlyduyy.onlytoodoo.viewmodel.TaskViewModel
@AndroidEntryPoint

class TaskEditFragment : Fragment(R.layout.task_edit) {
    private lateinit var binding: TaskEditBinding
    private val viewModel: TaskViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = TaskEditBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.editFab.setOnClickListener {
            saveTask()
            it.findNavController().navigate(R.id.action_taskEditFragment_to_dashboardFragment)
        }
    }

    private fun saveTask() {
        val taskTitle: String = binding.etTaskName.text.toString()
        val completed: Boolean = false

        if (binding.etTaskName.text.isNotEmpty()) {
            val task = TaskEntity(0, taskTitle, completed)
            viewModel.insertTask(task)
            Snackbar.make(requireView(), "Added!", Snackbar.LENGTH_SHORT).show()


        } else {
            Snackbar.make(requireView(), "Please add the task name!", Snackbar.LENGTH_SHORT).show()
        }

    }

}