package hiennguyen.me.weatherapp.common.injection.modules

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import hiennguyen.me.weatherapp.BuildConfig
import hiennguyen.me.weatherapp.data.network.NetworkingHelper
import hiennguyen.me.weatherapp.utils.Config
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import timber.log.Timber


@Module
class NetModule {

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor { message ->
            Timber.tag(Config.API_LOG)
            Timber.d(message)
        }.setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    fun provideStetho() = StethoInterceptor()

    @Provides
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor, stethoInterceptor: StethoInterceptor): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            httpClient.addInterceptor(loggingInterceptor)
            httpClient.addNetworkInterceptor(stethoInterceptor)
        }
        return httpClient.build()
    }

    @Provides
    fun provideRetrofitBuilder(okHttpClient: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_ENDPOINT)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .callFactory(okHttpClient)
    }

    @Provides
    fun provideNetworkingHelper(builder: Retrofit.Builder) = NetworkingHelper(builder)
}