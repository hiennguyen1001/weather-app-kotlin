package hiennguyen.me.weatherapp.presentation.search

import android.content.Context
import android.os.Bundle
import android.view.View
import hiennguyen.me.bindingadapterdelegate.ListConfig
import hiennguyen.me.bindingadapterdelegate.actionhandler.ActionHandler
import hiennguyen.me.bindingadapterdelegate.actionhandler.action.BaseAction
import hiennguyen.me.bindingadapterdelegate.adapter.BindableAdapter
import hiennguyen.me.bindingadapterdelegate.delegate.ModelActionItemDelegate
import hiennguyen.me.weatherapp.BR
import hiennguyen.me.weatherapp.R
import hiennguyen.me.weatherapp.common.base.views.BaseActivity
import hiennguyen.me.weatherapp.common.binding.ActionType
import hiennguyen.me.weatherapp.common.model.SearchCity
import hiennguyen.me.weatherapp.databinding.ActivitySearchLocationBinding
import hiennguyen.me.weatherapp.presentation.search.viewmodels.SearchViewModels
import hiennguyen.me.weatherapp.utils.BaseModelDiffCallback
import hiennguyen.me.weatherapp.utils.setOnQueryTextListener
import kotlinx.android.synthetic.main.activity_search_location.*


class LocationSearchActivity : BaseActivity<ActivitySearchLocationBinding, SearchViewModels>() {

    override fun layoutId(): Int {
        return R.layout.activity_search_location
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
                .setDefaultDividerEnabled(true)
                .setLayoutManagerProvider(ListConfig.SimpleLinearLayoutManagerProvider())
                .build(this)
        listConfig.applyConfig(this, cityRecycler)

        searchCity.setOnQueryTextListener(textChanged = {
            return@setOnQueryTextListener true
        })

    }
}