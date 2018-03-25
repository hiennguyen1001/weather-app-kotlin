package hiennguyen.me.weatherapp.presentation.home.viewmodels

import android.app.Application
import hiennguyen.me.weatherapp.common.base.viewmodels.BaseViewModel
import javax.inject.Inject


class HomeViewModel @Inject constructor(application: Application): BaseViewModel(application) {

    override fun onCleared() {
        super.onCleared()
    }
}