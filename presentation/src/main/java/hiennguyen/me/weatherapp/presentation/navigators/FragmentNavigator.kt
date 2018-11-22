package hiennguyen.me.weatherapp.presentation.navigators

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment

interface FragmentNavigator : Navigator {

    fun replaceChildFragment(@IdRes containerId: Int, fragment: androidx.fragment.app.Fragment, args: Bundle)

    fun replaceChildFragment(@IdRes containerId: Int, fragment: androidx.fragment.app.Fragment, fragmentTag: String, args: Bundle)

    fun replaceChildFragmentAndAddToBackStack(@IdRes containerId: Int, fragment: androidx.fragment.app.Fragment, args: Bundle, backstackTag: String)

    fun replaceChildFragmentAndAddToBackStack(@IdRes containerId: Int, fragment: androidx.fragment.app.Fragment, fragmentTag: String, args: Bundle, backstackTag: String)

}
