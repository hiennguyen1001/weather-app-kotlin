package hiennguyen.me.weatherapp.domain.mapper

import android.graphics.Typeface
import android.text.style.StyleSpan
import com.google.android.gms.location.places.AutocompletePrediction
import hiennguyen.me.weatherapp.data.models.local.SearchCity
import io.reactivex.Observable
import io.reactivex.functions.Function
import javax.inject.Inject


class SearchCityDisplayMapper @Inject constructor() : Function<List<AutocompletePrediction>, List<SearchCity>> {

    override fun apply(predictionList: List<AutocompletePrediction>): List<SearchCity> {
        return Observable.fromIterable(predictionList)
                .map(this::applyMap)
                .toList()
                .blockingGet()
    }

    fun applyMap(prediction: AutocompletePrediction) : SearchCity {
        return SearchCity(prediction.getFullText(StyleSpan(Typeface.NORMAL)).toString(), prediction.placeId)
    }
 }