package hiennguyen.me.weatherapp.data.models.remote

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.relation.ToMany


data class Coord(var lon: Double?, var lat: Double?)

data class City(var id: Int?, var name: String?, var coord: Coord, var country: String?, var population: Int?)

@Entity
class Temp(@Id var id: Long, var day: Double?, var min: Double?, var max: Double?, var night: Int?, var eve: Double?, var morn:
Double?)

@Entity
class Weather(@Id var id: Long?, var main: String?, var description: String?, var icon: String?)

@Entity
data class ForeCast(@Id var id: Long, var dt: Int?, var temp: ToMany<Temp>, var pressure: Double?, var humidity: Int?,
                    var weather: List<Weather>, var speed: Double?, var deg: Double?, var clouds: Int?, var snow: Double?, var rain: Double?)

data class ForeCastResponse(var city: City?, var cod: String?, var message: Double?, var cnt: Double?, var list: List<ForeCast>)
