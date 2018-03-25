package hiennguyen.me.weatherapp.data.models.local


class SearchCity(val content: String?, val placeId: String?) : Model {

    override fun areItemsThemSameWith(model: Model): Boolean {
        return when(model) {
            is SearchCity -> {
                return placeId.equals(model.placeId)
            }
            else -> false
        }
    }

    override fun areContentsThemSameWith(model: Model): Boolean {
        return when(model) {
            is SearchCity -> {
                return placeId.equals(model.placeId) && content.equals(model.content)
            }
            else -> false
        }
    }
}