package hiennguyen.me.weatherapp.presentation.search

import android.support.v4.app.FragmentActivity
import com.google.android.gms.location.places.AutocompletePrediction
import com.google.android.gms.location.places.AutocompletePredictionBufferResponse
import com.google.android.gms.tasks.Task
import dagger.Binds
import dagger.Module
import hiennguyen.me.weatherapp.common.base.modules.BaseActivityModule
import hiennguyen.me.weatherapp.common.injection.scopes.PerActivity
import hiennguyen.me.weatherapp.domain.interactor.SearchCityUseCase
import hiennguyen.me.weatherapp.domain.interactor.UseCase


@Module(includes = [(BaseActivityModule::class)])
abstract class LocationSearchActivityModule {

    @Binds
    @PerActivity
    abstract fun activity(searchActivity: LocationSearchActivity): FragmentActivity

}