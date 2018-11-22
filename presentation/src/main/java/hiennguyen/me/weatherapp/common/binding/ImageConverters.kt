package hiennguyen.me.weatherapp.common.binding

import androidx.databinding.BindingAdapter
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView

import com.bumptech.glide.load.engine.DiskCacheStrategy
import hiennguyen.me.weatherapp.utils.GlideApp

@BindingAdapter("backgroundRes")
fun setBackgroundDrawableRes(view: View?, resId: Int?) {
    if (view == null || resId == null) {
        return
    }

    view.setBackgroundResource(resId)
}

@BindingAdapter("imageRes")
fun setImageDrawableRes(view: ImageView?, resId: Int?) {
    if (view == null || resId == null) {
        return
    }

    view.setImageResource(resId)
}

@BindingAdapter(value = ["imageUrl", "placeholder"], requireAll = false)
fun setImageRemote(view: ImageView?, url: String?, placeholder: Drawable?) {
    if (view == null || url == null) {
        return
    }

    if (placeholder != null) {
        GlideApp.with(view)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .placeholder(placeholder)
                .into(view)
    } else {
        GlideApp.with(view.context).load(url).into(view)
    }
}

