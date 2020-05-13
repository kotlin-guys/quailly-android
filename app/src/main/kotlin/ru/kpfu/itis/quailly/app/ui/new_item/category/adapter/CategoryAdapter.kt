package ru.kpfu.itis.quailly.app.ui.new_item.category.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.kpfu.itis.quailly.R
import ru.kpfu.itis.quailly.app.ui.new_item.common.CategoryDiffUtilCallback
import ru.kpfu.itis.quailly.app.ui.new_item.desired_categories.adapter.DesiredCategoriesAdapter
import ru.kpfu.itis.quailly.app.ui.new_item.desired_categories.adapter.ItemClickListener
import ru.kpfu.itis.quailly.databinding.LiCategoryBinding
import ru.kpfu.itis.quailly.domain.model.Category

class CategoryAdapter (
    private val clickListener: ItemClickListener<Category>
) : ListAdapter<Category, CategoryAdapter.CategoryViewHolder>(CategoryDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<LiCategoryBinding>(
            layoutInflater,
            R.layout.li_category,
            parent,
            false
        )
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.onBind(getItem(position), clickListener)
    }

    inner class CategoryViewHolder(private val binding: LiCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: Category, trackClickListener: ItemClickListener<Category>) {
            binding.category = item
            binding.root.setOnClickListener {
                trackClickListener.omItemClick(item)
            }
            binding.executePendingBindings()
        }
    }
}
