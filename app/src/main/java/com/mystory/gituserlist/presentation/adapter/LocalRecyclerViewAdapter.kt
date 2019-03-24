package com.mystory.gituserlist.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mystory.gituserlist.BR
import com.mystory.gituserlist.data.item
import com.mystory.gituserlist.databinding.LayoutLocallistBinding
import com.mystory.gituserlist.presentation.viewmodel.LocalRecyclerViewModel

/**
 * LocalRecyclerViewAdapter
 * @author wsseo
 * @since 2019. 3. 24
 **/
class LocalRecyclerViewAdapter : PagedListAdapter<item, LocalRecyclerViewAdapter.SearchViewHolder>(diffCallback) {
    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<item>() {
            override fun areItemsTheSame(oldItem: item, newItem: item): Boolean =
                oldItem.id == newItem.id && oldItem.name == newItem.name
                        && oldItem.owner?.avatar_url == newItem.owner?.avatar_url
            override fun areContentsTheSame(oldItem: item, newItem: item): Boolean =
                oldItem.id == newItem.id && oldItem.name == newItem.name
                        && oldItem.owner?.avatar_url == newItem.owner?.avatar_url
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        var binding = LayoutLocallistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(binding)
    }
    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }
    class SearchViewHolder(binding: LayoutLocallistBinding) : RecyclerView.ViewHolder(binding.root) {
        var binding = binding
        fun bindTo(data:item?){
            data?.let { binding.setVariable(BR.model, LocalRecyclerViewModel(it.name, it.owner?.avatar_url)) }
        }
    }
}