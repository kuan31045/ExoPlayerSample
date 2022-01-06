package com.kappstudio.videoplayerlab.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kappstudio.videoplayerlab.data.VideoItem
import com.kappstudio.videoplayerlab.databinding.ItemVideoBinding
import com.kappstudio.videoplayerlab.util.setImage

class VideoAdapter(private val viewModel: DetailViewModel) :
    ListAdapter<VideoItem, VideoAdapter.VideoViewHolder>(DiffCallback) {

    inner class VideoViewHolder(private val binding: ItemVideoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(videoItem: VideoItem, viewModel: DetailViewModel) {
            binding.tvTitle.text = videoItem.title
            binding.tvDesc.text = videoItem.desc
            setImage(binding.ivCover, videoItem.cover)
            binding.ivPlayerVideo.setOnClickListener {
                //viewModel.navToPlayer(position)
            }
        }
    }

    object DiffCallback : DiffUtil.ItemCallback<VideoItem>() {
        override fun areItemsTheSame(oldItem: VideoItem, newItem: VideoItem): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: VideoItem, newItem: VideoItem): Boolean =
            oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        return VideoViewHolder(
            ItemVideoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.bind(getItem(position), viewModel)
    }
}