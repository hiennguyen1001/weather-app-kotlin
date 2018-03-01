package hiennguyen.me.weatherapp.common.injection.components

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import hiennguyen.me.weatherapp.WeatherApp
import hiennguyen.me.weatherapp.common.injection.modules.AppModule
import hiennguyen.me.weatherapp.common.injection.modules.BuilderModule
import hiennguyen.me.weatherapp.common.injection.modules.NetModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidSupportInjectionModule::class), (AppModule::class), (BuilderModule::class), (NetModule::class)])
interface AppComponent : AndroidInjector<WeatherApp> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder
        fun build(): AppComponent
    }

}
