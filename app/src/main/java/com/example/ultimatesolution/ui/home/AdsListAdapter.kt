package com.example.ultimatesolution.ui.home


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ultimatesolution.databinding.AdsListRvBinding


class AdsListAdapter() : ListAdapter<Int, AdsListAdapter.AdsViewHolder>(AdsDiffUtil()) {


    class AdsViewHolder(
        private val binding: AdsListRvBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Int) {
            binding.adsImage.setImageDrawable(
                ContextCompat.getDrawable(
                    binding.root.context,
                    item
                )
            )
        }
    }

    class AdsDiffUtil : DiffUtil.ItemCallback<Int>() {
        override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean {
            return oldItem == newItem
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdsViewHolder {
        return AdsViewHolder(
            binding = AdsListRvBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AdsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


}