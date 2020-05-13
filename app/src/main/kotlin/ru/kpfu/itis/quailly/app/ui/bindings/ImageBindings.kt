package ru.kpfu.itis.quailly.app.ui.bindings

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop

@BindingAdapter("loadURL")
fun loadUrl(view: ImageView, value: String?) {
    value?.let {
        Glide.with(view).load(it).transform(CircleCrop()).into(view)
    }
}