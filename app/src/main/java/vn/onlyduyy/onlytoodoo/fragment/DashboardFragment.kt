package vn.onlyduyy.onlytoodoo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import vn.onlyduyy.onlytoodoo.R
import vn.onlyduyy.onlytoodoo.adapter.TaskAdapter
import vn.onlyduyy.onlytoodoo.databinding.FragmentDashboardBinding
import vn.onlyduyy.onlytoodoo.viewmodel.TaskViewModel


@AndroidEntryPoint
class DashboardFragment : Fragment(R.layout.fragment_dashboard) {
    private lateinit var binding: FragmentDashboardBinding
    private lateinit var taskAdapter: TaskAdapter
    private val viewModel: TaskViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        displayTaskList()
        binding.addTaskButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_dashboardFragment_to_taskEditFragment)
        }
    }

    private fun displayTaskList() {
        taskAdapter = TaskAdapter()
        binding.apply {
            dashboardList.adapter = taskAdapter
            dashboardList.layoutManager = LinearLayoutManager(requireContext())
            dashboardList.setHasFixedSize(true)
        }
        viewModel.tasks.observe(viewLifecycleOwner) {
            taskAdapter.submitList(it)
        }
    }
}