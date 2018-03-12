package hiennguyen.me.weatherapp.presentation.home.views

import android.arch.lifecycle.Observer
import android.content.Context
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.View
import hiennguyen.me.weatherapp.BR
import hiennguyen.me.weatherapp.R
import hiennguyen.me.weatherapp.common.base.views.BaseActivity
import hiennguyen.me.weatherapp.common.binding.ActionType
import hiennguyen.me.weatherapp.data.models.Region
import hiennguyen.me.weatherapp.databinding.ActivityHomeBinding
import hiennguyen.me.weatherapp.presentation.home.viewmodels.HomeViewModel
import hiennguyen.me.weatherapp.utils.BaseModelDiffCallback
import hiennguyen.me.bindingadapterdelegate.ListConfig
import hiennguyen.me.bindingadapterdelegate.actionhandler.ActionHandler
import hiennguyen.me.bindingadapterdelegate.actionhandler.action.BaseAction
import hiennguyen.me.bindingadapterdelegate.adapter.BindableAdapter
import hiennguyen.me.bindingadapterdelegate.delegate.ModelActionItemDelegate
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
            supportFragmentManager.beginTransaction().replace(R.id.fl_content, HomeFragment()).commit()
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

        val actionHandler = ActionHandler.Builder()
                .addAction(ActionType.OPEN_URL, object : BaseAction<Region>() {
                    override fun isModelAccepted(model: Any): Boolean {
                        return model is Region
                    }

                    override fun onFireAction(context: Context, view: View?, actionType: String?, model: Region?) {
                        drawerView.closeDrawer(GravityCompat.START)
                        model?.flagResId?.let { headerImage.setImageResource(it) }
                        toolbar.title = model?.regionName
                    }
                })
                .build()

        cityContainer.setOnClickListener { _ ->
            drawerView.closeDrawer(GravityCompat.START)
            headerImage.setImageResource(R.drawable.ic_my_city)
            toolbar.title = "My City"
        }


        val adapter = BindableAdapter(BaseModelDiffCallback(),
                ModelActionItemDelegate(actionHandler, Region::class.java, R.layout.item_region, BR.region))

        val listConfig = ListConfig.Builder(adapter)
                .setDefaultDividerEnabled(true)
                .setLayoutManagerProvider(ListConfig.SimpleLinearLayoutManagerProvider())
                .build(this)
        listConfig.applyConfig(this, regionRecycler)

        viewModel.regionList().observe(this, Observer { regionList ->
            adapter.setItems(regionList) })

        headerImage.setImageResource(R.drawable.ic_my_city)
        toolbar.title = "My City"
    }
}