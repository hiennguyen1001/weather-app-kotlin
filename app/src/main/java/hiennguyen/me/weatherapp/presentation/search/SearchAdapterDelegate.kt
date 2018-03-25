package hiennguyen.me.weatherapp.presentation.search

import android.view.LayoutInflater
import android.view.ViewGroup
import hiennguyen.me.bindingadapterdelegate.actionhandler.ActionHandler
import hiennguyen.me.bindingadapterdelegate.adapter.BindingHolder
import hiennguyen.me.bindingadapterdelegate.delegate.ActionAdapterDelegate
import hiennguyen.me.weatherapp.R
import hiennguyen.me.weatherapp.data.models.local.Model
import hiennguyen.me.weatherapp.data.models.local.SearchCity
import hiennguyen.me.weatherapp.databinding.ItemSearchLayoutBinding

class SearchAdapterDelegate(actionHandler: ActionHandler) : ActionAdapterDelegate<Model, ItemSearchLayoutBinding>(actionHandler) {

    override fun onCreateViewHolder(parent: ViewGroup): BindingHolder<ItemSearchLayoutBinding> {
        return BindingHolder.newInstance(R.layout.item_search_layout, LayoutInflater.from(parent?.getContext()), parent, false)
    }

    override fun isForViewType(items: MutableList<Model>, position: Int): Boolean {
        return items[position] is SearchCity
    }

    override fun onBindViewHolder(items: MutableList<Model>, position: Int, holder: BindingHolder<ItemSearchLayoutBinding>) {
        val location = items[position] as SearchCity
        holder.binding.city = location
        holder.binding.actionHandler = actionHandler
    }
}