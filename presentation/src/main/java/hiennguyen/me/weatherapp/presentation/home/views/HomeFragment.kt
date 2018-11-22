package hiennguyen.me.weatherapp.presentation.home.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import android.view.View
import hiennguyen.me.weatherapp.R
import hiennguyen.me.weatherapp.common.base.views.BaseFragment
import hiennguyen.me.weatherapp.databinding.FragmentHomeBinding
import hiennguyen.me.weatherapp.presentation.home.viewmodels.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    lateinit var pager: androidx.viewpager.widget.ViewPager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pager = viewpager
    }
    override fun layoutId(): Int {
        return R.layout.fragment_home
    }


    class WeatherPagerAdapter(var mFragments: MutableList<androidx.fragment.app.Fragment>, fm: androidx.fragment.app.FragmentManager) : FragmentStatePagerAdapter(fm) {


        override fun getItem(position: Int): androidx.fragment.app.Fragment {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getCount(): Int {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        fun addItem(frag: androidx.fragment.app.Fragment) {
            mFragments.add(frag)
        }

    }

}