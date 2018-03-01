package hiennguyen.me.weatherapp.presentation.navigators

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import android.support.annotation.IdRes
import android.support.v4.app.Fragment

interface Navigator {

    fun finishActivity()

    fun startActivity(intent: Intent)

    fun startActivity(action: String)

    fun startActivity(action: String, uri: Uri)

    fun startActivity(activityClass: Class<out Activity>)

    fun startActivity(activityClass: Class<out Activity>, setArgsAction: ((Intent) -> Unit)?)

    fun startActivity(activityClass: Class<out Activity>, args: Bundle)

    fun startActivity(activityClass: Class<out Activity>, args: Parcelable)

    fun startActivity(activityClass: Class<out Activity>, arg: String)

    fun startActivity(activityClass: Class<out Activity>, arg: Int)

    fun startActivityForResult(activityClass: Class<out Activity>, requestCode: Int)

    fun startActivityForResult(activityClass: Class<out Activity>, setArgsAction: ((Intent) -> Unit)?, requestCode: Int)

    fun startActivityForResult(activityClass: Class<out Activity>, arg: Parcelable, requestCode: Int)

    fun startActivityForResult(activityClass: Class<out Activity>, arg: String, requestCode: Int)

    fun startActivityForResult(activityClass: Class<out Activity>, arg: Int, requestCode: Int)

    fun replaceFragment(@IdRes containerId: Int, fragment: Fragment, args: Bundle)

    fun replaceFragment(@IdRes containerId: Int, fragment: Fragment, fragmentTag: String, args: Bundle)

    fun replaceFragmentAndAddToBackStack(@IdRes containerId: Int, fragment: Fragment, args: Bundle, backstackTag: String)

    fun replaceFragmentAndAddToBackStack(@IdRes containerId: Int, fragment: Fragment, fragmentTag: String, args: Bundle, backstackTag: String)

    companion object {
        const val EXTRA_ARG = "_args"
    }

}
