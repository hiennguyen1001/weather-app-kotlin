package hiennguyen.me.weatherapp.presentation.search

import android.arch.lifecycle.Observer
import android.content.Context
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import hiennguyen.me.bindingadapterdelegate.ListConfig
import hiennguyen.me.bindingadapterdelegate.actionhandler.ActionHandler
import hiennguyen.me.bindingadapterdelegate.actionhandler.action.BaseAction
import hiennguyen.me.bindingadapterdelegate.adapter.BindableAdapter
import hiennguyen.me.bindingadapterdelegate.delegate.ModelActionItemDelegate
import hiennguyen.me.bindingadapterdelegate.util.ColorDividerItemDecoration
import hiennguyen.me.bindingadapterdelegate.util.DividerItemDecoration.SPACE_BOTTOM
import hiennguyen.me.weatherapp.BR
import hiennguyen.me.weatherapp.R
import hiennguyen.me.weatherapp.common.base.views.BaseActivity
import hiennguyen.me.weatherapp.common.binding.ActionType
import hiennguyen.me.weatherapp.data.models.local.SearchCity
import hiennguyen.me.weatherapp.databinding.ActivityLocationSearchBinding
import hiennguyen.me.weatherapp.presentation.search.viewmodels.SearchViewModel
import hiennguyen.me.weatherapp.utils.BaseModelDiffCallback
import hiennguyen.me.weatherapp.utils.setOnQueryTextListener
import kotlinx.android.synthetic.main.activity_location_search.*


class LocationSearchActivity : BaseActivity<ActivityLocationSearchBinding, SearchViewModel>() {

    override fun layoutId(): Int {
        return R.layout.activity_location_search
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.searchViewModel = viewModel

        val actionHandler = ActionHandler.Builder()
                .addAction(ActionType.CLICK_EVENT, object : BaseAction<SearchCity>() {
                    override fun isModelAccepted(model: Any): Boolean {
                        return model is SearchCity
                    }

                    override fun onFireAction(context: Context, view: View?, actionType: String?, model: SearchCity?) {
                    }
                })
                .build()
        val adapter = BindableAdapter(BaseModelDiffCallback(),
                ModelActionItemDelegate(actionHandler, SearchCity::class.java, R.layout.item_search_layout, BR.city))

        val listConfig = ListConfig.Builder(adapter)
                .setLayoutManagerProvider(ListConfig.SimpleLinearLayoutManagerProvider())
                .addItemDecoration(ColorDividerItemDecoration(ContextCompat.getColor(this, R.color.black_effective),
                        2, SPACE_BOTTOM,  true, false))
                .build(this)
        listConfig.applyConfig(this, cityRecycler)

        searchCity.setOnQueryTextListener(textChanged = {
            if (it != null && it.length >= 2) {
                viewModel.search(it)
            }
            return@setOnQueryTextListener true
        })

        viewModel.cityListLiveData.observe(this , Observer {
            adapter.items = it
        })
    }
}