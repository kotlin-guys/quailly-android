package ru.kpfu.itis.quailly.app.ui.new_item.field

import androidx.lifecycle.MutableLiveData
import ru.kpfu.itis.quailly.app.ui.utils.ext.map
import ru.kpfu.itis.quailly.app.ui.utils.ext.startWith

class Field<T : Any?>(
    isEmptyValidation: ((T) -> Boolean),
    validationAction: ((T) -> Boolean)? = null
) {

    val fieldValue = MutableLiveData<T>()

    val initialized = if (validationAction == null) {
        MutableLiveData(true)
    } else {
        fieldValue.map { value -> !isEmptyValidation.invoke(value) }
    }

    val isValid = fieldValue
        .map {
            validationAction?.invoke(it) ?: true
        }
        .startWith(true)

}