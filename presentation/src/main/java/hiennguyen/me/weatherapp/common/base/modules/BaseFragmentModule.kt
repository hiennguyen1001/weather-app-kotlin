package hiennguyen.me.weatherapp.common.base.modules

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
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
        fun childFragmentManager(fragment: Fragment): FragmentManager {
            return fragment.childFragmentManager
        }
    }
}