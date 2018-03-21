package hiennguyen.me.weatherapp.utils

import android.support.v7.widget.SearchView


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
