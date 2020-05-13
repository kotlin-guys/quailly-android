package ru.kpfu.itis.quailly.app.ui.new_item.common

import androidx.recyclerview.widget.DiffUtil
import ru.kpfu.itis.quailly.domain.model.Category

class CategoryDiffUtilCallback : DiffUtil.ItemCallback<Category>() {

    override fun areItemsTheSame(old: Category, new: Category): Boolean = old.id == new.id

    override fun areContentsTheSame(old: Category, new: Category): Boolean = old == new
}