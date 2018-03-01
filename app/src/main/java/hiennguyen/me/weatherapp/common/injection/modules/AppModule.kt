package hiennguyen.me.weatherapp.common.injection.modules

import android.app.Application
import android.content.Context
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import hiennguyen.me.weatherapp.data.realm.RealmModules
import hiennguyen.me.weatherapp.utils.Config
import io.realm.RealmConfiguration
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
    fun provideConfiguration(): RealmConfiguration {
        return RealmConfiguration.Builder()
                .name(Config.DATABASE_NAME)
                .schemaVersion(Config.DATABASE_VERSION)
                .modules(RealmModules())
                .deleteRealmIfMigrationNeeded()
                .build()
    }
}