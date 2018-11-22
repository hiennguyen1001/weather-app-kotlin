package hiennguyen.me.weatherapp.common.base.modules

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import dagger.Binds
import dagger.Module
import dagger.Provides
import hiennguyen.me.weatherapp.common.injection.scopes.PerFragment
import hiennguyen.me.weatherapp.presentation.navigators.ChildFragmentNavigator
import hiennguyen.me.weatherapp.presentation.navigators.FragmentNavigator

@Module
abstract class BaseFragmentModule {

    @Binds
    @PerFragment
    abstract fun provideFragmentNavigator(fragmentNavigator: ChildFragmentNavigator): FragmentNavigator


    @Module
    companion object {
        const val FRAGMENT = "BaseFragmentModule.fragment"
        const val CHILD_FRAGMENT_MANAGER = "BaseFragmentModule.childFragmentManager"

        @Provides
        @PerFragment
        fun childFragmentManager(fragment: androidx.fragment.app.Fragment): androidx.fragment.app.FragmentManager {
            return fragment.childFragmentManager
        }
    }
}