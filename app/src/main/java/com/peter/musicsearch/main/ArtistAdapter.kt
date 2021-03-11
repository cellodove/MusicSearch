package com.peter.musicsearch.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.peter.musicsearch.R
import com.peter.musicsearch.databinding.ItemSongBigBinding
import com.peter.musicsearch.databinding.ItemSongSmallBinding
import com.peter.musicsearch.repository.data.HitItem

class ArtistAdapter(private val listener: ArtistItemClickListener) :
    ListAdapter<HitItem, RecyclerView.ViewHolder>(
        object : DiffUtil.ItemCallback<HitItem>() {
            override fun areItemsTheSame(oldItem: HitItem, newItem: HitItem): Boolean =
                oldItem.result.id == newItem.result.id

            override fun areContentsTheSame(oldItem: HitItem, newItem: HitItem): Boolean =
                oldItem.result.id == newItem.result.id
        }
    ) {
    interface ArtistItemClickListener {
        fun onItemClick(position: Int)
    }

    companion object {
        const val ITEM_SMALL = 0
        const val ITEM_BIG = 1
    }

    override fun getItemViewType(position: Int): Int =
        if (getItem(position).result.isOpen) {
            ITEM_BIG
        } else {
            ITEM_SMALL
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        if (viewType == ITEM_SMALL) {
            ArtistSmallViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_song_small,
                    parent,
                    false
                )
            )
        } else {
            ArtistBigViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.item_song_big,
                    parent,
                    false
                )
            )
        }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)

        if (getItemViewType(position) == ITEM_SMALL) {
            (holder as ArtistSmallViewHolder).apply {
                setTitle(item.result.title)
                setThumbnail(item.result.song_art_image_thumbnail_url)
                setListener(listener)
            }
        } else {
            (holder as ArtistBigViewHolder).apply {
                setTitle(item.result.title)
                setFullTitle(item.result.full_title)
                setThumbnail(item.result.song_art_image_url)
                setListener(listener)
            }
        }
    }
}

class ArtistSmallViewHolder(private val binding: ItemSongSmallBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun setTitle(title: String) {
        binding.title.text = title
    }

    fun setThumbnail(url: String) {
        Glide.with(binding.root)
            .load(url)
            .into(binding.thumbnail)
    }

    fun setListener(listener: ArtistAdapter.ArtistItemClickListener) {
        binding.songItemContainer.setOnClickListener {
            if (adapterPosition != RecyclerView.NO_POSITION) {
                listener.onItemClick(adapterPosition)
            }
        }
    }
}

class ArtistBigViewHolder(private val binding: ItemSongBigBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun setTitle(title: String) {
        binding.title.text = title
    }

    fun setFullTitle(fullTitle: String) {
        binding.fullTitle.text = fullTitle
    }

    fun setThumbnail(url: String) {
        Glide.with(binding.root)
            .load(url)
            .into(binding.thumbnail)
    }

    fun setListener(listener: ArtistAdapter.ArtistItemClickListener) {
        binding.songItemContainer.setOnClickListener {
            if (adapterPosition != RecyclerView.NO_POSITION) {
                listener.onItemClick(adapterPosition)
            }
        }
    }
}

