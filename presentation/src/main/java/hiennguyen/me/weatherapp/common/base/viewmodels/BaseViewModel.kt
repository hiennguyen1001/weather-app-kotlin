package hiennguyen.me.weatherapp.common.base.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.databinding.ObservableBoolean
import io.objectbox.BoxStore
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


open class BaseViewModel(application: Application) : AndroidViewModel(application) {

    @Inject
    protected lateinit var mBoxStore: BoxStore

    protected val mIsLoading = ObservableBoolean(false)

    fun getIsLoading(): ObservableBoolean {
        return mIsLoading
    }

    fun setIsLoading(isLoading: Boolean) {
        mIsLoading.set(isLoading)
    }

}