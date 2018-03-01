package hiennguyen.me.weatherapp.common.injection.modules

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import hiennguyen.me.weatherapp.common.base.viewmodels.ViewModelFactory
import hiennguyen.me.weatherapp.common.injection.ViewModelKey
import hiennguyen.me.weatherapp.presentation.home.viewmodels.HomeViewModel

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}