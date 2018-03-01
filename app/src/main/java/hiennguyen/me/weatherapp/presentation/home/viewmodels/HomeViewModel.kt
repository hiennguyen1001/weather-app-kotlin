package hiennguyen.me.weatherapp.presentation.home.viewmodels

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import hiennguyen.me.weatherapp.common.base.viewmodels.BaseViewModel
import hiennguyen.me.weatherapp.data.models.Region
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


class HomeViewModel @Inject constructor(application: Application): BaseViewModel(application) {

    private val regionLiveData = MutableLiveData<List<Region>>()
    private val mDisposable: CompositeDisposable = CompositeDisposable()

    init {
        regionLiveData.value = Region.getRegionList()
    }

    fun regionList() = regionLiveData

    override fun onCleared() {
        mDisposable.clear()
        super.onCleared()
    }
}