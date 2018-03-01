package hiennguyen.me.weatherapp.data.models.remote


data class Country(var flag: String?, var name: String?, var alpha2Code: String?, var capital: String?)

data class Coord(var lon: Double?, var lat: Double?)

data class City(var id: Int?, var name: String?, var coord: Coord, var country: String?, var population: Int?)

data class Temp(var day: Double?, var min: Double?, var max: Double?, var night: Int?, var eve: Double?, var morn: Double?)

data class Weather(var id: Int?, var main: String?, var description: String?, var icon: String?)

data class ForeCast(var dt: Int?, var temp: Temp, var pressure: Double?, var humidity: Int?, var weather: List<Weather>,
                    var speed: Double?, var deg: Double?, var clouds: Int?, var snow: Double?, var rain: Double?)

data class ForeCastResponse(var city: City?, var cod: String?, var message: Double?, var cnt: Double?, var list: List<ForeCast>)
