package hiennguyen.me.weatherapp.utils


import android.support.v7.recyclerview.extensions.DiffCallback
import hiennguyen.me.weatherapp.data.models.Model

class BaseModelDiffCallback : DiffCallback<Model>() {

    override fun areItemsTheSame(oldItem: Model, newItem: Model): Boolean {
        return oldItem.areItemsThemSameWith(newItem)
    }

    override fun areContentsTheSame(oldItem: Model, newItem: Model): Boolean {
        return oldItem.areContentsThemSameWith(newItem)
    }
}
