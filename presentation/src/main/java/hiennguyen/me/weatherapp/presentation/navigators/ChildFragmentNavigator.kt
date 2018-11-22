package hiennguyen.me.weatherapp.presentation.navigators

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment

import javax.inject.Inject

class ChildFragmentNavigator @Inject
constructor(private val fragment: androidx.fragment.app.Fragment) : ActivityNavigator(fragment.activity), FragmentNavigator {

    override fun replaceChildFragment(@IdRes containerId: Int, fragment: androidx.fragment.app.Fragment, args: Bundle) {
        replaceFragmentInternal(this.fragment.childFragmentManager, containerId, fragment, null, args, false, null)
    }

    override fun replaceChildFragment(@IdRes containerId: Int, fragment: androidx.fragment.app.Fragment, fragmentTag: String, args: Bundle) {
        replaceFragmentInternal(this.fragment.childFragmentManager, containerId, fragment, fragmentTag, args, false, null)
    }

    override fun replaceChildFragmentAndAddToBackStack(@IdRes containerId: Int, fragment: androidx.fragment.app.Fragment, args: Bundle, backstackTag: String) {
        replaceFragmentInternal(this.fragment.childFragmentManager, containerId, fragment, null, args, true, backstackTag)
    }

    override fun replaceChildFragmentAndAddToBackStack(@IdRes containerId: Int, fragment: androidx.fragment.app.Fragment, fragmentTag: String, args: Bundle, backstackTag: String) {
        replaceFragmentInternal(this.fragment.childFragmentManager, containerId, fragment, fragmentTag, args, true, backstackTag)
    }
}

