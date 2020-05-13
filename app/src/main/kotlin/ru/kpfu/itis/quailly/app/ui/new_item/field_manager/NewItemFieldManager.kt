package ru.kpfu.itis.quailly.app.ui.new_item.field_manager

import android.net.Uri
import androidx.lifecycle.LiveData
import ru.kpfu.itis.quailly.app.ui.new_item.field.Field
import ru.kpfu.itis.quailly.app.ui.utils.ext.isAllTrue
import ru.kpfu.itis.quailly.app.ui.utils.ext.map
import ru.kpfu.itis.quailly.domain.model.Category
import javax.inject.Inject

class NewItemFieldManager @Inject constructor() {

    private companion object {
        const val NAME_MIN_LENGTH = 1
        const val DESCRIPTION_MIN_LENGTH = 1
    }

    val image = Field(::checkIsNull, ::validateImage)
    val name = Field(String::isNullOrEmpty, ::validateName)
    val description = Field(String::isNullOrEmpty, ::validateDescription)
    val category = Field(::checkIsNull, ::validateCategory)
    val desiredCategories = Field(List<Category>::isNullOrEmpty, ::validateDesiredCategories)

    val desiredCategoriesFormattedValue: LiveData<String> = desiredCategories.fieldValue
        .map {
            it.joinToString {
                it.name
            }
        }

    val isFormValid = listOf(
        image.isValid, name.isValid, description.isValid, category.isValid, desiredCategories.isValid,
        image.initialized, name.initialized, description.initialized, category.initialized,
        desiredCategories.initialized
    ).isAllTrue()

    private fun validateImage(value: Uri?): Boolean {

        return value != null
    }

    private fun validateName(value: String?): Boolean {

        return value != null && value.length >= NAME_MIN_LENGTH
    }

    private fun validateDescription(value: String?): Boolean {

        return value != null && value.length >= DESCRIPTION_MIN_LENGTH
    }

    private fun validateCategory(value: Category?): Boolean {

        return value != null
    }

    private fun validateDesiredCategories(value: List<Category>?): Boolean {

        return value.isNullOrEmpty().not()
    }

    private fun checkIsNull(any: Any?): Boolean = any == null
}
