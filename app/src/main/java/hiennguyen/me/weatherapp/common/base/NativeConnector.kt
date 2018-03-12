package hiennguyen.me.weatherapp.common.base


object NativeConnector {

    init {
        System.loadLibrary("urls")
    }

    external fun getWeatherApiKey() : String
}