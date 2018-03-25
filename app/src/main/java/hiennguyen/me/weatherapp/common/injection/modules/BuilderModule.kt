package hiennguyen.me.weatherapp.common.injection.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import hiennguyen.me.weatherapp.common.base.modules.BaseActivityModule
import hiennguyen.me.weatherapp.common.injection.scopes.PerActivity
import hiennguyen.me.weatherapp.presentation.home.HomeActivityModule
import hiennguyen.me.weatherapp.presentation.home.views.HomeActivity
import hiennguyen.me.weatherapp.presentation.search.LocationSearchActivity
import hiennguyen.me.weatherapp.presentation.search.LocationSearchActivityModule


@Module
abstract class BuilderModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [(HomeActivityModule::class)])
    abstract fun bindHomeActivity(): HomeActivity

    @PerActivity
    @ContributesAndroidInjector(modules = [(LocationSearchActivityModule::class)])
    abstract fun bindLocationSearchActivity(): LocationSearchActivity
}