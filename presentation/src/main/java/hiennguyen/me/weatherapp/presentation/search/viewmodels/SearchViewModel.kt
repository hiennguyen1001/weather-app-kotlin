package hiennguyen.me.weatherapp.presentation.search.viewmodels

import android.annotation.SuppressLint
import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.location.places.AutocompleteFilter
import com.google.android.gms.location.places.AutocompleteFilter.TYPE_FILTER_CITIES
import com.google.android.gms.location.places.GeoDataClient
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.jakewharton.rxrelay2.PublishRelay
import hiennguyen.me.weatherapp.common.base.viewmodels.BaseViewModel
import hiennguyen.me.weatherapp.data.models.local.SearchCity
import hiennguyen.me.weatherapp.domain.interactor.SearchCityUseCase
import hiennguyen.me.weatherapp.utils.LogWraper
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SearchViewModel @Inject constructor(application: Application, private val geoDataClient: GeoDataClient,
                                          private val searchCityUseCase: SearchCityUseCase) : BaseViewModel(application) {

    var cityListLiveData = MutableLiveData<List<SearchCity>>()
    private val searchPublishSubject = PublishRelay.create<String>()

    init {
        initSearchPublishSubject()
    }

    fun search(key: String) {
        LogWraper.d { key }
        searchPublishSubject.accept(key)
    }

    @SuppressLint("CheckResult")
    private fun initSearchPublishSubject() {
        searchPublishSubject
                .debounce(300, TimeUnit.MILLISECONDS)
                .distinctUntilChanged()
                .subscribeOn(Schedulers.io())
                .subscribe({ result ->
                    mIsLoading.set(true)
                    val results = geoDataClient.getAutocompletePredictions(result, BOUNDS_GREATER_SYDNEY, filter)
                    searchCityUseCase.singleSubscribeWith(onSuccess = {
                        cityListLiveData.value = it
                        mIsLoading.set(false)
                    }, onError = {
                        mIsLoading.set(false)
                    }, params = results)
                }, { t: Throwable? -> t?.let {
                    LogWraper.d(message = { "Failed to get search results" }, throwable = t)
                }})
    }


    override fun onCleared() {
        searchCityUseCase.dispose()
        super.onCleared()
    }

    companion object {
        private val BOUNDS_GREATER_SYDNEY = LatLngBounds(
                LatLng(-34.041458, 150.790100), LatLng(-33.682247, 151.383362))
        val filter = AutocompleteFilter.Builder().setTypeFilter(TYPE_FILTER_CITIES).build()
    }

}