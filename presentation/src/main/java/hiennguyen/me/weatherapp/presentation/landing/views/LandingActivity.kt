package hiennguyen.me.weatherapp.presentation.landing.views

import hiennguyen.me.weatherapp.R
import hiennguyen.me.weatherapp.common.base.views.BaseActivity
import hiennguyen.me.weatherapp.databinding.ActivityLandingBinding
import hiennguyen.me.weatherapp.presentation.landing.viewmodels.LandingViewModel

class LandingActivity : BaseActivity<ActivityLandingBinding, LandingViewModel>() {
    override fun layoutId(): Int {
        return R.layout.activity_landing
    }

}