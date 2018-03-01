package hiennguyen.me.weatherapp.common.base.viewmodels

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import hiennguyen.me.weatherapp.presentation.home.viewmodels.HomeViewModel
import javax.inject.Inject


@Suppress("UNCHECKED_CAST")
class
ViewModelFactory @Inject constructor() : ViewModelProvider.Factory {

    @Inject
    lateinit var homeViewModel: HomeViewModel


    override fun <T : ViewModel?> create(modelClass: Class<T>) =
            with(modelClass) {
                when {
                    isAssignableFrom(HomeViewModel::class.java) ->
                        homeViewModel
                    else ->
                        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
                }
            } as T
}
