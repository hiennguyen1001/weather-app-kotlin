package hiennguyen.me.weatherapp.presentation.forecast

import androidx.fragment.app.Fragment
import dagger.Binds
import dagger.Module
import hiennguyen.me.weatherapp.common.base.modules.BaseFragmentModule
import hiennguyen.me.weatherapp.common.injection.scopes.PerFragment
import hiennguyen.me.weatherapp.presentation.forecast.views.ForeCastFragment

@Module(includes = [(BaseFragmentModule::class)])
abstract class ForecastFragmentModule {

    @Binds
    @PerFragment
    internal abstract fun fragment(foreCastFragment: ForeCastFragment): androidx.fragment.app.Fragment
}