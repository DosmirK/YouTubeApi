package com.example.youtubeapi.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.youtubeapi.data.model.Item
import com.example.youtubeapi.data.utils.Constants
import com.example.youtubeapi.databinding.ItemPlaylistBinding

class PlaylistsAdapter : ListAdapter<Item, PlaylistsAdapter.ItemPlaylistViewHolder>(DIFF_UTIL_CALL_BACK) {

    private companion object {
        val DIFF_UTIL_CALL_BACK: DiffUtil.ItemCallback<Item> =
            object : DiffUtil.ItemCallback<Item>() {
                override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
                    return oldItem == newItem
                }
            }
    }

    override fun onBindViewHolder(holder: ItemPlaylistViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemPlaylistViewHolder {
        return ItemPlaylistViewHolder(
            ItemPlaylistBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    fun setOnItemClickListener(onClick: (String) -> Unit) {
        onItemClick = onClick
    }

    private var onItemClick: ((String) -> Unit)? = null

    inner class ItemPlaylistViewHolder(private val binding: ItemPlaylistBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: Item) {
            binding.root.setOnClickListener {
                onItemClick?.let { onItemClick ->
                    onItemClick(item.id)
                }
            }
            binding.apply {
                tvPlaylistTitle.text = item.snippet.title
                "${item.contentDetails.itemCount} ${Constants.VIDEO_SERIES}".apply {
                    tvVideosCount.text = this
                }
                ivPreview.load(item.snippet.thumbnails.standard.url)
            }
        }
    }
}