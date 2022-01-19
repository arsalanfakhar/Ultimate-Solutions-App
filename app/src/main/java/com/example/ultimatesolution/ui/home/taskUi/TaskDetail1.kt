package com.example.ultimatesolution.ui.home.taskUi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.ultimatesolution.R
import com.example.ultimatesolution.database.TaskDetail
import com.example.ultimatesolution.databinding.FragmentTaskDetail1Binding
import com.example.ultimatesolution.model.Task
import com.example.ultimatesolution.model.taskList
import dagger.hilt.android.AndroidEntryPoint
import java.util.*


//@AndroidEntryPoint
class TaskDetail1 : Fragment() {

    private lateinit var binding: FragmentTaskDetail1Binding
    private val viewModel: TaskViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentTaskDetail1Binding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()

    }


    private fun initialize() {
        bindAdapters()
        bindClickListener()

    }

    private fun bindAdapters() {
        val taskAdapter = ArrayAdapter<Task>(
            requireContext(),
            R.layout.spinner_view,
            taskList
        )

        binding.taskTypeTxt.setAdapter(taskAdapter)


        val selectedTaskId = requireActivity().intent.extras!!.getInt("taskId")
        binding.taskTypeTxt.setText(
            binding.taskTypeTxt.adapter.getItem(selectedTaskId).toString(),
            false
        )


        val inventoryList = arrayListOf("In app", "On your own")

        val inventoryAdapter = ArrayAdapter(
            requireContext(),
            R.layout.spinner_view,
            inventoryList
        )

        binding.taskInventoryTxt.setAdapter(inventoryAdapter)

    }

    private fun bindClickListener() {

        binding.taskTypeBtn.setOnClickListener {
            binding.taskTypeTxt.showDropDown()
        }

        binding.taskInventoryBtn.setOnClickListener {
            binding.taskInventoryTxt.showDropDown()
        }



        binding.confirmBtn.setOnClickListener {
            if (binding.taskTypeTxt.text.isEmpty()
                || binding.taskDescriptionTxt.text!!.isEmpty()
                || binding.taskInventoryTxt.text!!.isEmpty()
                || binding.taskBudgetTxt.text!!.isEmpty()
                || binding.taskLocationTxt.text!!.isEmpty()
            ) {
                Toast.makeText(requireContext(), "Fields are empty", Toast.LENGTH_SHORT).show()
            } else {

                val task = TaskDetail(
                    work_type = binding.taskTypeTxt.text.toString(),
                    work_description = binding.taskDescriptionTxt.text.toString(),
                    inventory = binding.taskInventoryTxt.text.toString(),
                    budget = binding.taskBudgetTxt.text.toString().toInt(),
                    location = binding.taskLocationTxt.text.toString(),
                    dateCreated = Calendar.getInstance().time
                )

                viewModel.addTask(task)

                findNavController().navigate(R.id.action_taskDetail1_to_taskDetailSummary)
            }
        }
    }

}