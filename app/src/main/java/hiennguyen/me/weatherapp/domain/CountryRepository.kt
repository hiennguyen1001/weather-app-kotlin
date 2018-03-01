package hiennguyen.me.weatherapp.domain

import hiennguyen.me.weatherapp.data.models.remote.Country
import io.reactivex.Single


interface CountryRepository {

    fun getCountry(region: String) : Single<Country>
}