package com.example.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.core.R
import com.example.core.databinding.ListItemRowBinding
import com.example.core.domain.model.PopularMovie

class PopularMovieAdapter : RecyclerView.Adapter<PopularMovieAdapter.ListViewHolder>() {
    private var listData = ArrayList<PopularMovie>()
    var onItemClick: ((PopularMovie) -> Unit)? = null

    fun setData(newListData: List<PopularMovie>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ListItemRowBinding.bind(itemView)
        fun bind(data: PopularMovie) {
            with(binding) {
                tvItemTitle.text = data.title
                tvItemDate.text = data.releaseDate
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w600_and_h900_bestv2" + data.poster)
                    .into(ivItemPoster)
            }
        }

        init {
            binding.root.setOnClickListener { onItemClick?.invoke(listData[bindingAdapterPosition]) }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder = ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_row, parent, false))

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listData.size
}