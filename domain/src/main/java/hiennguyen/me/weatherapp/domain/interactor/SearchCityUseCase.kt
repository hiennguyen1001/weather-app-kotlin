package hiennguyen.me.weatherapp.domain.interactor

import com.google.android.gms.common.data.DataBufferUtils
import com.google.android.gms.location.places.AutocompletePrediction
import com.google.android.gms.location.places.AutocompletePredictionBufferResponse
import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.Tasks
import hiennguyen.me.weatherapp.data.models.local.SearchCity
import hiennguyen.me.weatherapp.domain.mapper.SearchCityDisplayMapper
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SearchCityUseCase @Inject constructor(private val searchCityDisplayMapper: SearchCityDisplayMapper) : UseCase<List<SearchCity>,
        Task<AutocompletePredictionBufferResponse>>() {

    override fun buildUseCaseSingle(params: Task<AutocompletePredictionBufferResponse>?): Single<List<SearchCity>> {
        return Single.fromCallable {
            params?.let {
                Tasks.await(it, 60, TimeUnit.SECONDS)
                DataBufferUtils
                        .freezeAndClose<AutocompletePrediction, AutocompletePrediction>(params.result) as List<AutocompletePrediction>
            } ?: emptyList()
        }.map(searchCityDisplayMapper)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
    }


}