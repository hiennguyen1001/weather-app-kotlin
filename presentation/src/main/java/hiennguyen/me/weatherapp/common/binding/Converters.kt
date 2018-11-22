package hiennguyen.me.weatherapp.common.binding

import androidx.databinding.BindingAdapter
import androidx.databinding.BindingConversion
import android.view.View

import hiennguyen.me.bindingadapterdelegate.actionhandler.listener.ActionClickListener


/**
 * Binding adapter to assign an action to a view using android data binding approach.
 * Sample:
 * <pre>
 * &lt;Button
 * android:layout_width="wrap_content"
 * android:layout_height="wrap_content"
 *
 * android:actionHandler="@{someActionHandler}"
 * android:actionType='@{"send_message"}'
 * android:actionTypeLongClick='@{"show_menu"}'
 * android:model="@{user}"
 *
 * android:text="@string/my_button_text"/&gt;
</pre> *
 *
 * @param view                The View to bind an action
 * @param actionHandler       The action handler which will handle an action
 * @param actionType          The action type, which will be handled on view clicked
 * @param actionTypeLongClick The action type, which will be handled on view long clicked
 * @param model               The model which will be handled
 */
@BindingAdapter(value = ["actionHandler", "actionType", "actionTypeLongClick", "model", "modelLongClick"], requireAll = false)
fun setActionHandler(view: View, actionHandler: ActionClickListener?, actionType: String?,
                     actionTypeLongClick: String?, model: Any, modelLongClick: Any?) {
    if (actionHandler != null) {
        if (actionType != null) {
            view.setOnClickListener { _ -> actionHandler.onActionClick(view, actionType, model) }
        }

        if (actionTypeLongClick != null) {
            view.setOnLongClickListener { _ ->
                actionHandler.onActionClick(view, actionTypeLongClick, modelLongClick ?: model)
                true
            }
        }
    }
}


@BindingAdapter("visibleOrGone")
fun bindVisibleOrGone(view: View, b: Boolean) {
    view.visibility = if (b) View.VISIBLE else View.GONE
}

@BindingAdapter("visible")
fun bindVisible(view: View, b: Boolean) {
    view.visibility = if (b) View.VISIBLE else View.INVISIBLE
}

@BindingConversion
fun convertBooleanToVisibility(b: Boolean): Int {
    return if (b) View.VISIBLE else View.GONE
}

