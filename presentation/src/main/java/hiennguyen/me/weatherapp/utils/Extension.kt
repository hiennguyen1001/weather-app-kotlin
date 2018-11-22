package hiennguyen.me.weatherapp.utils

import androidx.databinding.BindingAdapter
import androidx.appcompat.widget.SearchView
import android.widget.TextView


fun SearchView.setOnQueryTextListener(textSubmit: ((String?) -> Boolean?)? = null, textChanged: ((String?) -> Boolean)? = null) {
    val listener = object : SearchView.OnQueryTextListener {

        override fun onQueryTextSubmit(query: String?): Boolean {
            return textSubmit?.invoke(query) ?: false
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            return textChanged?.invoke(newText) ?: false
        }

    }
    setOnQueryTextListener(listener)
}

@BindingAdapter("containText")
fun setContainText(view: TextView, text: String) {
    view.text = text
}
