package hiennguyen.me.weatherapp.data.models


import android.support.annotation.DrawableRes
import hiennguyen.me.weatherapp.R

import java.util.ArrayList

class Region(var regionName: String?, @param:DrawableRes var flagResId: Int?) : Model {

    override fun areItemsThemSameWith(model: Model): Boolean {
        return false
    }

    override fun areContentsThemSameWith(model: Model): Boolean {
        return false
    }

    companion object {

        private val REGIONS: MutableList<Region> by lazy {
            ArrayList<Region>().apply {
                var temp = Region("Africa", R.drawable.africa_flag)
                add(temp)
                temp = Region("Asia", R.drawable.asia_flag)
                add(temp)
                temp = Region("Europe", R.drawable.europe_flag)
                add(temp)
                temp = Region("Oceania", R.drawable.oceania_flag)
                add(temp)
            }
        }

        fun getRegionList(): List<Region> = REGIONS
    }

}
