package hiennguyen.me.weatherapp.common.injection.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import hiennguyen.me.weatherapp.common.injection.scopes.PerActivity
import hiennguyen.me.weatherapp.presentation.home.HomeActivityModule
import hiennguyen.me.weatherapp.presentation.home.views.HomeActivity


@Module
abstract class BuilderModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [(HomeActivityModule::class)])
    abstract fun bindHomeActivity(): HomeActivity
}