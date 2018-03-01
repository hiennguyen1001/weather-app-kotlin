package hiennguyen.me.weatherapp.presentation.navigators

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager

import javax.inject.Inject

open class ActivityNavigator @Inject
constructor(private val activity: FragmentActivity?) : Navigator {

    override fun finishActivity() {
        activity?.finish()
    }

    override fun startActivity(intent: Intent) {
        activity?.startActivity(intent)
    }

    override fun startActivity(action: String) {
        activity?.startActivity(Intent(action))
    }

    override fun startActivity(action: String, uri: Uri) {
        activity?.startActivity(Intent(action, uri))
    }

    override fun startActivity(activityClass: Class<out Activity>) {
        startActivityInternal(activityClass, null, null)
    }

    override fun startActivity(activityClass: Class<out Activity>, setArgsAction: ((Intent) -> Unit)?) {
        startActivityInternal(activityClass, setArgsAction, null)
    }

    override fun startActivity(activityClass: Class<out Activity>, args: Bundle) {
        startActivityInternal(activityClass, { intent -> intent.putExtra(Navigator.EXTRA_ARG, args) }, null)
    }

    override fun startActivity(activityClass: Class<out Activity>, args: Parcelable) {
        startActivityInternal(activityClass, { intent -> intent.putExtra(Navigator.EXTRA_ARG, args) }, null)
    }

    override fun startActivity(activityClass: Class<out Activity>, arg: String) {
        startActivityInternal(activityClass, { intent -> intent.putExtra(Navigator.EXTRA_ARG, arg) }, null)
    }

    override fun startActivity(activityClass: Class<out Activity>, arg: Int) {
        startActivityInternal(activityClass, { intent -> intent.putExtra(Navigator.EXTRA_ARG, arg) }, null)
    }

    override fun startActivityForResult(activityClass: Class<out Activity>, requestCode: Int) {
        startActivityInternal(activityClass, null, requestCode)
    }

    override fun startActivityForResult(activityClass: Class<out Activity>, setArgsAction: ((Intent) -> Unit)?, requestCode: Int) {
        startActivityInternal(activityClass, setArgsAction, requestCode)
    }

    override fun startActivityForResult(activityClass: Class<out Activity>, arg: Parcelable, requestCode: Int) {
        startActivityInternal(activityClass, { intent -> intent.putExtra(Navigator.EXTRA_ARG, arg) }, requestCode)
    }

    override fun startActivityForResult(activityClass: Class<out Activity>, arg: String, requestCode: Int) {
        startActivityInternal(activityClass, { intent -> intent.putExtra(Navigator.EXTRA_ARG, arg) }, requestCode)
    }

    override fun startActivityForResult(activityClass: Class<out Activity>, arg: Int, requestCode: Int) {
        startActivityInternal(activityClass, { intent -> intent.putExtra(Navigator.EXTRA_ARG, arg) }, requestCode)
    }

    override fun replaceFragment(@IdRes containerId: Int, fragment: Fragment, args: Bundle) {
        replaceFragmentInternal(activity?.supportFragmentManager, containerId, fragment, null, args, false, null)
    }

    override fun replaceFragment(@IdRes containerId: Int, fragment: Fragment,
                                 fragmentTag: String, args: Bundle) {
        replaceFragmentInternal(activity?.supportFragmentManager, containerId, fragment, fragmentTag, args, false, null)
    }

    override fun replaceFragmentAndAddToBackStack(@IdRes containerId: Int, fragment: Fragment,
                                                  args: Bundle, backstackTag: String) {
        replaceFragmentInternal(activity?.supportFragmentManager, containerId, fragment, null, args, true, backstackTag)
    }

    override fun replaceFragmentAndAddToBackStack(@IdRes containerId: Int, fragment: Fragment,
                                                  fragmentTag: String, args: Bundle, backstackTag: String) {
        replaceFragmentInternal(activity?.supportFragmentManager, containerId, fragment, fragmentTag, args, true, backstackTag)
    }

    internal fun replaceFragmentInternal(fm: FragmentManager?, @IdRes containerId: Int, fragment: Fragment,
                                         fragmentTag: String?, args: Bundle?, addToBackstack: Boolean, backstackTag: String?) {
        if (args != null) {
            fragment.arguments = args
        }

        val ft = fm?.beginTransaction()?.replace(containerId, fragment, fragmentTag)
        if (addToBackstack) {
            ft?.addToBackStack(backstackTag)?.commit()
            fm?.executePendingTransactions()
        } else {
            ft?.commitNow()
        }
    }

    private fun startActivityInternal(activityClass: Class<out Activity>, setArgsAction: ((Intent) -> Unit)?, requestCode: Int?) {
        val intent = Intent(activity, activityClass)
        setArgsAction?.invoke(intent)

        if (requestCode != null) {
            activity?.startActivityForResult(intent, requestCode)
        } else {
            activity?.startActivity(intent)
        }
    }
}
