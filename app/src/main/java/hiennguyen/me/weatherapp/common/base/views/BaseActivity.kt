package hiennguyen.me.weatherapp.common.base.views

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.FragmentManager
import dagger.android.support.DaggerAppCompatActivity
import hiennguyen.me.weatherapp.common.base.viewmodels.BaseViewModel
import hiennguyen.me.weatherapp.presentation.navigators.Navigator
import java.lang.reflect.ParameterizedType
import javax.inject.Inject


abstract class BaseActivity<V : ViewDataBinding, M : BaseViewModel>: DaggerAppCompatActivity() {

    protected lateinit var binding: V
    protected lateinit var viewModel: M

    @Inject
    protected lateinit var navigator: Navigator

    @Inject
    protected lateinit var mFragmentManager: FragmentManager

    @Inject
    lateinit var mFactory: ViewModelProvider.Factory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bindingView(layoutId())
        viewModel = ViewModelProviders.of(this, mFactory).get(viewModelClass())
    }

    private fun bindingView(layoutId: Int): V {
        return DataBindingUtil.setContentView(this, layoutId)
    }

    protected abstract fun layoutId(): Int

    private fun viewModelClass(): Class<M> {
        // dirty hack to get generic type https://stackoverflow.com/a/1901275/719212
        return (javaClass.genericSuperclass as ParameterizedType)
                .actualTypeArguments[1] as Class<M>
    }

    protected fun getActivity() = this
}