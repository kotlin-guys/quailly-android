package ru.kpfu.itis.quailly.app.ui.utils.bindings

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("adapter")
fun RecyclerView.setRecyclerViewAdapter(adapter: RecyclerView.Adapter<*>?) {
    this.adapter = adapter
    doOnDetach { it.adapter = null }
}

inline fun <reified T : View> T.doOnDetach(crossinline callback: (T) -> Unit) {

    addOnAttachStateChangeListener(object : View.OnAttachStateChangeListener {

        override fun onViewAttachedToWindow(v: View) = Unit

        override fun onViewDetachedFromWindow(v: View) {

            callback.invoke(v as T)
            removeOnAttachStateChangeListener(this)
        }
    })
}