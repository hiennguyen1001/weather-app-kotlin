package hiennguyen.me.weatherapp.presentation.home.views

import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import hiennguyen.me.weatherapp.R
import hiennguyen.me.weatherapp.common.base.views.BaseActivity
import hiennguyen.me.weatherapp.databinding.ActivityHomeBinding
import hiennguyen.me.weatherapp.presentation.home.viewmodels.HomeViewModel
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import kotlinx.android.synthetic.main.region_nav_menu.*


class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>() {

    override fun layoutId(): Int {
        return R.layout.activity_home
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.fl_content, HomeFragment()).commit()
        }
        binding.homeViewModel = viewModel
        setup()
    }

    private fun setup() {
        setSupportActionBar(toolbar)
        val mDrawerToggle = ActionBarDrawerToggle(
                this,
                drawerView,
                toolbar,
                R.string.open_drawer,
                R.string.close_drawer)
        mDrawerToggle.isDrawerIndicatorEnabled = true
        drawerView.addDrawerListener(mDrawerToggle)
        mDrawerToggle.syncState()


        cityContainer.setOnClickListener { _ ->
            drawerView.closeDrawer(GravityCompat.START)
            headerImage.setImageResource(R.drawable.ic_my_city)
            toolbar.title = "My City"
        }

        headerImage.setImageResource(R.drawable.ic_my_city)
        toolbar.title = "My City"
    }
}