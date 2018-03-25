package hiennguyen.me.weatherapp.utils


import android.support.v7.recyclerview.extensions.DiffCallback
import hiennguyen.me.weatherapp.data.models.local.Model

class BaseModelDiffCallback : DiffCallback<Model>() {

    override fun areItemsTheSame(oldItem: Model, newItem: Model): Boolean {
        return false
    }

    override fun areContentsTheSame(oldItem: Model, newItem: Model): Boolean {
        return false
    }
}
