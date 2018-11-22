package hiennguyen.me.weatherapp.presentation.home

import androidx.fragment.app.FragmentActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import hiennguyen.me.weatherapp.common.base.modules.BaseActivityModule
import hiennguyen.me.weatherapp.common.injection.scopes.PerActivity
import hiennguyen.me.weatherapp.common.injection.scopes.PerFragment
import hiennguyen.me.weatherapp.presentation.forecast.ForecastFragmentModule
import hiennguyen.me.weatherapp.presentation.forecast.views.ForeCastFragment
import hiennguyen.me.weatherapp.presentation.home.views.HomeActivity
import hiennguyen.me.weatherapp.presentation.home.views.HomeFragment


@Module(includes = [(BaseActivityModule::class)])
abstract class HomeActivityModule {

    @Binds
    @PerActivity
    abstract fun activity(homeActivity: HomeActivity): androidx.fragment.app.FragmentActivity

    @PerFragment
    @ContributesAndroidInjector(modules = [(HomeFragmentModule::class)])
    abstract fun bindHomeFragment(): HomeFragment

    @PerFragment
    @ContributesAndroidInjector(modules = [(ForecastFragmentModule::class)])
    abstract fun bindForeCastFragment(): ForeCastFragment

}