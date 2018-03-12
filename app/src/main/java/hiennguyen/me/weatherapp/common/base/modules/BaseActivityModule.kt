package hiennguyen.me.weatherapp.common.base.modules

import android.content.Context
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import dagger.Module
import dagger.Provides
import hiennguyen.me.weatherapp.common.injection.modules.ViewModelModule
import hiennguyen.me.weatherapp.common.injection.qualifiers.ActivityContext
import hiennguyen.me.weatherapp.common.injection.scopes.PerActivity
import hiennguyen.me.weatherapp.presentation.navigators.ActivityNavigator
import hiennguyen.me.weatherapp.presentation.navigators.Navigator

@Module(includes = [(ViewModelModule::class)])
class BaseActivityModule {

    @Provides
    @PerActivity
    @ActivityContext
    fun provideActivityContext(activity: FragmentActivity): Context {
        return activity
    }

    @Provides
    @PerActivity
    @ActivityContext
    fun provideFragmentActivity(activity: FragmentActivity): FragmentActivity {
        return activity
    }

    @Provides
    @PerActivity
    fun provideActivityNavigator(navigator: ActivityNavigator): Navigator {
        return navigator
    }

    @Provides
    @PerActivity
    fun provideFragmentManager(activity: FragmentActivity): FragmentManager {
        return activity.supportFragmentManager
    }
}