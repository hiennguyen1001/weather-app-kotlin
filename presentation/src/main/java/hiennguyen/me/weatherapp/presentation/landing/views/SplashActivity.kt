package hiennguyen.me.weatherapp.presentation.landing.views

import android.os.Bundle
import android.os.Handler
import hiennguyen.me.weatherapp.R
import hiennguyen.me.weatherapp.common.base.views.BaseActivity
import hiennguyen.me.weatherapp.databinding.ActivitySplashBinding
import hiennguyen.me.weatherapp.presentation.landing.viewmodels.SplashViewModel

class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>() {
    override fun layoutId(): Int {
        return R.layout.activity_splash
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val handler = Handler()
        handler.postDelayed({
            navigator.startActivity(LandingActivity::class.java)
        }, 1500)
    }

}