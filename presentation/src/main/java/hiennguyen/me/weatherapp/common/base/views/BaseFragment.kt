package hiennguyen.me.weatherapp.common.base.views

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment
import dagger.android.support.HasSupportFragmentInjector
import hiennguyen.me.weatherapp.presentation.navigators.FragmentNavigator
import java.lang.reflect.ParameterizedType
import javax.inject.Inject


abstract class BaseFragment<V : ViewDataBinding, M: ViewModel> : Fragment(), HasSupportFragmentInjector {

    protected lateinit var binding: V
    protected lateinit var viewModel: M
    @Inject
    protected lateinit var childFragmentInjector: DispatchingAndroidInjector<Fragment>
    @Inject
    protected lateinit var mFactory: ViewModelProvider.Factory

    @Inject
    protected lateinit var mNavigator: FragmentNavigator
    @Inject
    protected lateinit var mChildFragmentManager: FragmentManager

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return childFragmentInjector
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId(), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this, mFactory).get(viewModelClass())
    }

    private fun viewModelClass(): Class<M> {
        // dirty hack to get generic type https://stackoverflow.com/a/1901275/719212
        return (javaClass.genericSuperclass as ParameterizedType)
                .actualTypeArguments[1] as Class<M>
    }

    protected abstract fun layoutId(): Int
}