package ru.kpfu.itis.quailly.app.ui.bindings

import android.widget.EditText
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import ru.kpfu.itis.quailly.R

@BindingAdapter("hasErrors")
fun setError(view: EditText, value: Boolean?) {

    when (value) {
        true -> {
            view.background = view.resources.getDrawable(R.drawable.background_frame_red, null)
            view.setTextColor(ContextCompat.getColor(view.context, R.color.color_error))
        }
        false -> {
            view.background = view.resources.getDrawable(R.drawable.background_frame_gray, null)
            view.setTextColor(ContextCompat.getColor(view.context, R.color.color_default))
        }
    }
}