package com.example.ultimatesolution.ui.home.taskUi

import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.ultimatesolution.R
import com.example.ultimatesolution.databinding.ActivityTaskDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp


@AndroidEntryPoint
class TaskDetailActivity : AppCompatActivity() {


    private lateinit var binding: ActivityTaskDetailBinding

    private val viewModel: TaskViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTaskDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }


}