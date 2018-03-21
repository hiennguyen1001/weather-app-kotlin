package hiennguyen.me.weatherapp.common.model

interface Model {

    fun areItemsThemSameWith(model: Model): Boolean

    fun areContentsThemSameWith(model: Model): Boolean
}
