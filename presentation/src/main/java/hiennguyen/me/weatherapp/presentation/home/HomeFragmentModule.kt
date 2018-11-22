package hiennguyen.me.weatherapp.presentation.home

import androidx.fragment.app.Fragment


import dagger.Binds
import dagger.Module
import hiennguyen.me.weatherapp.common.base.modules.BaseFragmentModule
import hiennguyen.me.weatherapp.common.injection.scopes.PerFragment
import hiennguyen.me.weatherapp.presentation.home.views.HomeFragment

@Module(includes = [(BaseFragmentModule::class)])
abstract class HomeFragmentModule {

    @Binds
    @PerFragment
    internal abstract fun fragment(mainFragment: HomeFragment): androidx.fragment.app.Fragment
}
