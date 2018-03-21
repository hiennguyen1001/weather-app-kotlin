package hiennguyen.me.weatherapp.presentation.home.viewmodels

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import hiennguyen.me.weatherapp.common.base.viewmodels.BaseViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


class HomeViewModel @Inject constructor(application: Application): BaseViewModel(application) {

    override fun onCleared() {
        mDisposable.clear()
        super.onCleared()
    }
}