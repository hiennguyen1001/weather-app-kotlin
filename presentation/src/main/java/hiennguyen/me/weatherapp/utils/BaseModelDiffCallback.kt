package hiennguyen.me.weatherapp.utils


import android.support.v7.util.DiffUtil
import hiennguyen.me.weatherapp.data.models.local.Model

class BaseModelDiffCallback : DiffUtil.ItemCallback<Model>() {

    override fun areItemsTheSame(oldItem: Model, newItem: Model): Boolean {
        return false
    }

    override fun areContentsTheSame(oldItem: Model, newItem: Model): Boolean {
        return false
    }
}
