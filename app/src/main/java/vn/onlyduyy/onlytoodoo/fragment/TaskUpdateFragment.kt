package vn.onlyduyy.onlytoodoo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import vn.onlyduyy.onlytoodoo.R
import vn.onlyduyy.onlytoodoo.databinding.TaskUpdateBinding


class TaskUpdateFragment : Fragment(R.layout.task_update) {
    private lateinit var binding: TaskUpdateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = TaskUpdateBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

}