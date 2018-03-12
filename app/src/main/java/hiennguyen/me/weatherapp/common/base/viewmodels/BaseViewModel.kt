package hiennguyen.me.weatherapp.common.base.viewmodels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.databinding.ObservableBoolean
import io.objectbox.BoxStore
import javax.inject.Inject


open class BaseViewModel(application: Application) : AndroidViewModel(application) {

    @Inject
    protected lateinit var mBoxStore: BoxStore

    private val mIsLoading = ObservableBoolean(false)

    fun getIsLoading(): ObservableBoolean {
        return mIsLoading
    }

    fun setIsLoading(isLoading: Boolean) {
        mIsLoading.set(isLoading)
    }

}