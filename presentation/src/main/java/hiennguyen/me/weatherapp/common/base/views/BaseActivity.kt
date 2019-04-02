package hiennguyen.me.weatherapp.common.base.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasFragmentInjector
import dagger.android.support.HasSupportFragmentInjector
import hiennguyen.me.weatherapp.common.base.viewmodels.BaseViewModel
import hiennguyen.me.weatherapp.presentation.navigators.Navigator
import java.lang.reflect.ParameterizedType
import javax.inject.Inject


abstract class BaseActivity<V : ViewDataBinding, M : BaseViewModel> : AppCompatActivity(), HasFragmentInjector, HasSupportFragmentInjector {

    protected lateinit var binding: V
    protected lateinit var viewModel: M

    @Inject lateinit var supportFragmentInjector: DispatchingAndroidInjector<androidx.fragment.app.Fragment>
    @Inject lateinit var frameworkFragmentInjector: DispatchingAndroidInjector<android.app.Fragment>

    @Inject protected lateinit var navigator: Navigator
    @Inject protected lateinit var mFragmentManager: androidx.fragment.app.FragmentManager
    @Inject lateinit var mFactory: ViewModelProvider.Factory


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = bindingView(layoutId())
        viewModel = ViewModelProviders.of(this, mFactory).get(viewModelClass())
    }

    override fun supportFragmentInjector(): AndroidInjector<androidx.fragment.app.Fragment>? {
        return supportFragmentInjector
    }

    override fun fragmentInjector(): AndroidInjector<android.app.Fragment>? {
        return frameworkFragmentInjector
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