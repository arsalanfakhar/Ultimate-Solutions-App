package com.example.ultimatesolution.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ultimatesolution.R
import com.example.ultimatesolution.databinding.FragmentHomeBinding
import com.example.ultimatesolution.model.Task
import com.example.ultimatesolution.model.taskList
import com.example.ultimatesolution.ui.home.taskUi.TaskDetailActivity
import com.example.ultimatesolution.ui.main.MainActivity
import com.google.android.material.tabs.TabLayoutMediator


class HomeFragment : Fragment() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var binding: FragmentHomeBinding


    private lateinit var adsListAdapter: AdsListAdapter
    private lateinit var taskListAdapter: TaskListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialize()
        bindRv()
    }

    private fun initialize() {
        drawerLayout = MainActivity.getMainActivity()!!.drawerLayout

        binding.toggleDrawerBtn.setOnClickListener {
            //toggle drawer
            if (drawerLayout.isOpen) {
                drawerLayout.close()
            } else
                drawerLayout.open()
        }
    }

    private fun bindRv() {

        //ads mock list
        val adsList = arrayListOf(
            R.drawable.banner1,
            R.drawable.banner2,
            R.drawable.banner3,
        )

        //task mock list

//        val taskList = arrayListOf(
//            Task(1, "Cleaning", R.drawable.ic_cleaning_lady),
//            Task(2, "Ac Service", R.drawable.ic_cleaning_lady),
//            Task(3, "Electrician", R.drawable.ic_cleaning_lady),
//            Task(4, "Plumber", R.drawable.ic_cleaning_lady),
//            Task(4, "Plumber", R.drawable.ic_cleaning_lady),
//            Task(4, "Plumber", R.drawable.ic_cleaning_lady),
//            Task(4, "Plumber", R.drawable.ic_cleaning_lady),
//            Task(4, "Plumber", R.drawable.ic_cleaning_lady),
//            Task(4, "Plumber", R.drawable.ic_cleaning_lady),
//            Task(4, "Plumber", R.drawable.ic_cleaning_lady),
//            Task(4, "Plumber", R.drawable.ic_cleaning_lady),
//            Task(4, "Plumber", R.drawable.ic_cleaning_lady),
//            Task(4, "Plumber", R.drawable.ic_cleaning_lady),
//
//        )

        //Ads List rv
        adsListAdapter = AdsListAdapter()

        binding.adsViewpager.apply {
            adapter = adsListAdapter
        }

        TabLayoutMediator(binding.dotsTab, binding.adsViewpager) { tab, position ->

        }.attach()

        adsListAdapter.submitList(adsList)


        //task list rv
        taskListAdapter = TaskListAdapter(
            onClick = {

                val intent = Intent(requireContext(), TaskDetailActivity::class.java)
                val bundle = Bundle()
                bundle.putInt("taskId", it.task_id)
                intent.putExtras(bundle)

                startActivity(intent)
            }
        )

        binding.taskRv.apply {
            layoutManager = GridLayoutManager(context, 3, GridLayoutManager.VERTICAL, false)
            adapter = taskListAdapter
        }

        taskListAdapter.submitList(taskList)

    }

}