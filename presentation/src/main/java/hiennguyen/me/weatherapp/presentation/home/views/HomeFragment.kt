package hiennguyen.me.weatherapp.presentation.home.views

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import android.view.View
import hiennguyen.me.weatherapp.R
import hiennguyen.me.weatherapp.common.base.views.BaseFragment
import hiennguyen.me.weatherapp.databinding.FragmentHomeBinding
import hiennguyen.me.weatherapp.presentation.home.viewmodels.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    lateinit var pager: ViewPager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pager = viewpager
    }
    override fun layoutId(): Int {
        return R.layout.fragment_home
    }


    class WeatherPagerAdapter(var mFragments: MutableList<Fragment>, fm: FragmentManager) : FragmentStatePagerAdapter(fm) {


        override fun getItem(position: Int): Fragment {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getCount(): Int {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        fun addItem(frag: Fragment) {
            mFragments.add(frag)
        }

    }

}