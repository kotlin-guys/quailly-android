package ru.kpfu.itis.quailly.app.ui.utils.bindings

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("isVisible")
fun setVisibility(view: View, value: Boolean?) {
    when (value) {
        true -> view.visibility = View.VISIBLE
        false -> view.visibility = View.INVISIBLE
    }
}

@BindingAdapter("isVisibleWithGone")
fun setVisibilityWithGone(view: View, value: Boolean?) {
    when (value) {
        true -> view.visibility = View.VISIBLE
        false -> view.visibility = View.GONE
    }
}
