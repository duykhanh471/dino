package vn.onlyduyy.onlytoodoo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import vn.onlyduyy.onlytoodoo.R
import vn.onlyduyy.onlytoodoo.databinding.TaskUpdateBinding

@AndroidEntryPoint

class TaskUpdateFragment : Fragment(R.layout.task_update) {
    private lateinit var binding: TaskUpdateBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = TaskUpdateBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

}