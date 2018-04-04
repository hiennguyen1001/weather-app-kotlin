package hiennguyen.me.weatherapp.common.injection.modules

import android.app.Application
import android.content.Context
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import hiennguyen.me.weatherapp.BuildConfig
import hiennguyen.me.weatherapp.data.models.remote.MyObjectBox
import hiennguyen.me.weatherapp.utils.Config
import io.objectbox.BoxStore
import io.objectbox.android.AndroidObjectBrowser
import javax.inject.Singleton


@Module
class AppModule {

    @Provides
    @Singleton
    fun provideAppContext(app: Application): Context {
        return app
    }

    @Provides
    @Singleton
    fun provideResources(app: Application): Resources {
        return app.resources
    }

    @Provides
    @Singleton
    fun provideObjectBoxStore(app: Application): BoxStore {
        return MyObjectBox.builder().debugRelations()
                .androidContext(app)
                .build()
    }


}