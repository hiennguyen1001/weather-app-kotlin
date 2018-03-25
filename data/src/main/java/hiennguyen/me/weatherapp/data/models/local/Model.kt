package hiennguyen.me.weatherapp.data.models.local

interface Model {

    fun areItemsThemSameWith(model: Model): Boolean

    fun areContentsThemSameWith(model: Model): Boolean
}
