package hiennguyen.me.weatherapp.common.base.views

import android.arch.lifecycle.ViewModelProvider
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import hiennguyen.me.weatherapp.presentation.navigators.FragmentNavigator
import javax.inject.Inject


abstract class BaseFragment<V : ViewDataBinding> : DaggerFragment() {

    protected lateinit var binding: V
    @Inject
    protected lateinit var mFactory: ViewModelProvider.Factory

    @Inject
    protected lateinit var mNavigator: FragmentNavigator
    @Inject
    protected lateinit var mChildFragmentManager: FragmentManager


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId(), container, false)
        mNavigator.toString()
        return binding.root
    }

    protected abstract fun layoutId(): Int
}