package hiennguyen.me.weatherapp.data.models

interface Model {

    fun areItemsThemSameWith(model: Model): Boolean

    fun areContentsThemSameWith(model: Model): Boolean
}
