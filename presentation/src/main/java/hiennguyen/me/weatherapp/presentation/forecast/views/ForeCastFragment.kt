package hiennguyen.me.weatherapp.presentation.forecast.views

import hiennguyen.me.weatherapp.R
import hiennguyen.me.weatherapp.common.base.views.BaseFragment
import hiennguyen.me.weatherapp.databinding.FragmentForecastBinding
import hiennguyen.me.weatherapp.presentation.forecast.viewmodels.ForeCastViewModel

class ForeCastFragment : BaseFragment<FragmentForecastBinding, ForeCastViewModel>() {

    override fun layoutId(): Int {
        return R.layout.fragment_forecast
    }
}