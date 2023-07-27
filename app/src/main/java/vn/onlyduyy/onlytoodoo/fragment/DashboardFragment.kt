package vn.onlyduyy.onlytoodoo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
    // Option menu top bar
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_tasks, menu)

//        val searchItem = menu.findItem(R.id.action_search)
//        val searchView = searchItem.actionView as SearchView
//        searchView.OnQueryTextChanged {
//            //update search query
//            viewModel.searchQuery.value = it
//        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_sort_by_name -> {

                true
            }
            R.id.action_sort_by_date -> {
                item.isChecked = !item.isChecked
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
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
            ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return false
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val task = taskAdapter.currentList[viewHolder.adapterPosition]
                    viewModel.deleteTask(task)


                }
            }).attachToRecyclerView(dashboardList)
        }
        viewModel.tasks.observe(viewLifecycleOwner) {
            taskAdapter.submitList(it)
        }
    }
}