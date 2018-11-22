package hiennguyen.me.weatherapp.common.injection.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import hiennguyen.me.weatherapp.common.base.viewmodels.ViewModelFactory
import hiennguyen.me.weatherapp.common.injection.ViewModelKey
import hiennguyen.me.weatherapp.presentation.home.viewmodels.HomeViewModel
import hiennguyen.me.weatherapp.presentation.search.viewmodels.SearchViewModel

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    abstract fun bindSearchViewModels(searchViewModels: SearchViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}