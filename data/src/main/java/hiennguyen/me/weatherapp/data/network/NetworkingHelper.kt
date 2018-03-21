package hiennguyen.me.weatherapp.data.network

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.internal.bind.DateTypeAdapter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*


class NetworkingHelper(private val defaultBuilder: Retrofit.Builder) {


    fun <T> createServiceImplemetation(clazz: Class<T>): T {
        return defaultBuilder
                .addConverterFactory(GsonConverterFactory.create(mDefaultGsonBuilder.create()))
                .build().create(clazz)
    }

    fun <T> createServiceImplemetation(clazz: Class<T>, gson: Gson): T {
        return defaultBuilder
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build().create(clazz)
    }


    companion object {

        private val GSON_INSTANCE: GsonBuilder = GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(Date::class.java, DateTypeAdapter())
        val mDefaultGsonBuilder by lazy { GSON_INSTANCE }

    }
}