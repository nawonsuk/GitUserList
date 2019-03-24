package com.mystory.gituserlist.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mystory.gituserlist.BR
import com.mystory.gituserlist.data.item
import com.mystory.gituserlist.databinding.LayoutApilistBinding
import com.mystory.gituserlist.presentation.viewmodel.ApiRecyclerViewModel

/**
 * ApiRecyclerViewAdapter
 * @author wsseo
 * @since 2019. 3. 24
 **/
class ApiRecyclerViewAdapter : PagedListAdapter<item, ApiRecyclerViewAdapter.SearchViewHolder>(diffCallback) {
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
        var binding = LayoutApilistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(binding)
    }
    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }
    class SearchViewHolder(binding: LayoutApilistBinding) : RecyclerView.ViewHolder(binding.root) {
        var binding = binding
        fun bindTo(data:item?){
            data?.let { binding.setVariable(BR.model, ApiRecyclerViewModel(it.name, it.owner?.avatar_url)) }
        }
    }
}