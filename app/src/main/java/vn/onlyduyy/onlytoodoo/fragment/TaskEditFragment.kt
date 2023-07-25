package vn.onlyduyy.onlytoodoo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar
import vn.onlyduyy.onlytoodoo.R
import vn.onlyduyy.onlytoodoo.database.TaskEntity

import vn.onlyduyy.onlytoodoo.databinding.TaskEditBinding
import vn.onlyduyy.onlytoodoo.viewmodel.TaskViewModel


class TaskEditFragment : Fragment(R.layout.task_edit) {
    private lateinit var binding: TaskEditBinding
    private val viewModel: TaskViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
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

        saveTask()
    }

    private fun saveTask() {
        val taskTitle: String = binding.etTaskName.text.toString()
        val completed: Boolean = false

        if (binding.etTaskName.text.isNotEmpty()) {
            val task = TaskEntity(0, taskTitle, completed)
            viewModel.insertTask(task)
            Snackbar.make(view!!, "Added!", Snackbar.LENGTH_SHORT)

        } else {
            Snackbar.make(view!!, "Please add the task name!", Snackbar.LENGTH_SHORT)
        }

    }

}