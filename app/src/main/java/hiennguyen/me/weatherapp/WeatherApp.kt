package hiennguyen.me.weatherapp

import android.app.Activity
import android.app.Application
import android.content.Context
import android.support.multidex.MultiDexApplication
import com.facebook.stetho.Stetho
import com.squareup.leakcanary.LeakCanary
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import hiennguyen.me.weatherapp.common.injection.components.DaggerAppComponent
import io.realm.Realm
import timber.log.Timber
import javax.inject.Inject


class WeatherApp : MultiDexApplication(), HasActivityInjector {

    lateinit var app: Application

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        app = this
        Realm.init(this)
        DaggerAppComponent
                .builder()
                .application(this)
                .build()
                .inject(this)
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
            Stetho.initializeWithDefaults(this)
            LeakCanary.install(this)
        }
    }

    fun getAppContext(): Context {
        return app.applicationContext
    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity>? {
        return dispatchingAndroidInjector
    }
}