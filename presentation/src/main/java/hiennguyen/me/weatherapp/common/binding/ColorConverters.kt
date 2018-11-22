package hiennguyen.me.weatherapp.common.binding

import androidx.databinding.BindingAdapter
import android.graphics.drawable.GradientDrawable
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.core.content.ContextCompat
import android.view.View
import android.widget.TextView
import hiennguyen.me.weatherapp.R


@BindingAdapter("backgroundColorRes")
fun setBackgroundColorRes(view: View?, color: Int?) {
    if (view == null || color == null) {
        return
    }

    view.setBackgroundColor(ContextCompat.getColor(view.context, color))
}

@BindingAdapter("textColorRes")
fun setTextColorRes(view: TextView?, textColor: Int?) {
    if (view == null || textColor == null) {
        return
    }

    if (textColor == R.color.colorPrimary) {

    }

    view.setTextColor(ContextCompat.getColor(view.context, textColor))
}

@BindingAdapter("hintColorRes")
fun setTextHintColorRes(view: TextView?, hintColor: Int?) {
    if (view == null || hintColor == null) {
        return
    }

    view.setHintTextColor(ContextCompat.getColor(view.context, hintColor))
}

@BindingAdapter("linkColorRes")
fun setTextLinkColorRes(view: TextView?, linkColor: Int?) {
    if (view == null || linkColor == null) {
        return
    }

    view.setLinkTextColor(ContextCompat.getColor(view.context, linkColor))
}

@BindingAdapter("backgroundShapeColor")
fun changeBackgroundShapeColor(pView: View, colorInt: Int) {
    if (colorInt == R.color.colorPrimary) {
        //todo something
    }
    val resolvedColor = ContextCompat.getColor(pView.context, colorInt)
    val background = pView.background
    if (background is GradientDrawable) {
        background.setColor(resolvedColor)
    } else {
        pView.setBackgroundColor(resolvedColor)
    }
}

@BindingAdapter("backgroundStrokeColor", "strokeSize")
fun changeBackgroundStrokeColor(pView: View, @ColorRes colorResInt: Int, @DimenRes strokeSize: Int) {
    val colorInt = ContextCompat.getColor(pView.context, colorResInt)
    val strokeSizeInPixels = pView.context.resources.getDimension(strokeSize)
    val background = pView.background
    if (background is GradientDrawable) {
        background.setStroke(strokeSizeInPixels.toInt(), colorInt)
    } else {
        pView.setBackgroundColor(colorInt)
    }
}