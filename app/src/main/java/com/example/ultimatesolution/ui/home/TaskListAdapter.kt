package com.example.ultimatesolution.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ultimatesolution.databinding.TaskListRvBinding
import com.example.ultimatesolution.model.Task
import com.example.ultimatesolution.ui.home.TaskListAdapter.TaskViewHolder

class TaskListAdapter(
    private val onClick: (Task) -> Unit
) : ListAdapter<Task, TaskViewHolder>(TaskDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            binding = TaskListRvBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            onClick = onClick
        )
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class TaskViewHolder(
        private val binding: TaskListRvBinding,
        private val onClick: (Task) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Task) {

            binding.taskImg.setImageDrawable(
                ContextCompat.getDrawable(
                    binding.root.context,
                    item.task_img
                )
            )

            binding.taskName.text = item.task_name

            binding.root.setOnClickListener { onClick.invoke(item) }
        }
    }


    class TaskDiffUtil : DiffUtil.ItemCallback<Task>() {
        override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem.task_id == newItem.task_id
        }

        override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem == newItem
        }

    }


}