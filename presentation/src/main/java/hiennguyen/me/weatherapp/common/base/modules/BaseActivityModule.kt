package hiennguyen.me.weatherapp.common.base.modules

import android.content.Context
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.google.android.gms.location.places.Places
import dagger.Module
import dagger.Provides
import hiennguyen.me.weatherapp.common.injection.modules.ViewModelModule
import hiennguyen.me.weatherapp.common.injection.qualifiers.ActivityContext
import hiennguyen.me.weatherapp.common.injection.scopes.PerActivity
import hiennguyen.me.weatherapp.domain.interactor.SearchCityUseCase
import hiennguyen.me.weatherapp.presentation.navigators.ActivityNavigator
import hiennguyen.me.weatherapp.presentation.navigators.Navigator

@Module(includes = [(ViewModelModule::class)])
class BaseActivityModule {

    @Provides
    @PerActivity
    @ActivityContext
    fun provideActivityContext(activity: androidx.fragment.app.FragmentActivity): Context {
        return activity
    }

    @Provides
    @PerActivity
    @ActivityContext
    fun provideFragmentActivity(activity: androidx.fragment.app.FragmentActivity): androidx.fragment.app.FragmentActivity {
        return activity
    }

    @Provides
    @PerActivity
    fun provideActivityNavigator(navigator: ActivityNavigator): Navigator {
        return navigator
    }

    @Provides
    @PerActivity
    fun provideFragmentManager(activity: androidx.fragment.app.FragmentActivity): androidx.fragment.app.FragmentManager {
        return activity.supportFragmentManager
    }

    @Provides
    @PerActivity
    fun provideGeoDataClient(activity: androidx.fragment.app.FragmentActivity) = Places.getGeoDataClient(activity)

}