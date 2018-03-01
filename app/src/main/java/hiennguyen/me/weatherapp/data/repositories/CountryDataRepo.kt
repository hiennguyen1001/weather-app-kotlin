package hiennguyen.me.weatherapp.data.repositories

import hiennguyen.me.weatherapp.data.models.remote.Country
import hiennguyen.me.weatherapp.domain.CountryRepository
import io.reactivex.Single


class CountryDataRepo : CountryRepository {

    override fun getCountry(region: String): Single<Country> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}