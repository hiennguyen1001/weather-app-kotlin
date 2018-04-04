package hiennguyen.me.weatherapp.presentation.navigators

import android.os.Bundle
import android.support.annotation.IdRes
import android.support.v4.app.Fragment

interface FragmentNavigator : Navigator {

    fun replaceChildFragment(@IdRes containerId: Int, fragment: Fragment, args: Bundle)

    fun replaceChildFragment(@IdRes containerId: Int, fragment: Fragment, fragmentTag: String, args: Bundle)

    fun replaceChildFragmentAndAddToBackStack(@IdRes containerId: Int, fragment: Fragment, args: Bundle, backstackTag: String)

    fun replaceChildFragmentAndAddToBackStack(@IdRes containerId: Int, fragment: Fragment, fragmentTag: String, args: Bundle, backstackTag: String)

}
