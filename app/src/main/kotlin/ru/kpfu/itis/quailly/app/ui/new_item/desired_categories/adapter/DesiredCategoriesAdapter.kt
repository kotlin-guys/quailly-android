package ru.kpfu.itis.quailly.app.ui.new_item.desired_categories.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.davidecirillo.multichoicerecyclerview.MultiChoiceAdapter
import kotlinx.android.synthetic.main.li_desired_categories.view.*
import ru.kpfu.itis.quailly.R
import ru.kpfu.itis.quailly.databinding.LiDesiredCategoriesBinding
import ru.kpfu.itis.quailly.domain.model.Category

class DesiredCategoriesAdapter : MultiChoiceAdapter<DesiredCategoriesAdapter.DesiredCategoryViewHolder>() {

    val categories = mutableListOf<Category>()

    fun setCategories(categories: List<Category>) {
        this.categories.clear()
        this.categories.addAll(categories)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = categories.size

    override fun onBindViewHolder(holder: DesiredCategoryViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)

        holder.onBind(categories[position])
    }

    override fun setActive(view: View, state: Boolean) {
        super.setActive(view, state)

        if (state) {
            view.iv_check.visibility = View.VISIBLE
        } else {
            view.iv_check.visibility = View.INVISIBLE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DesiredCategoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<LiDesiredCategoriesBinding>(
            layoutInflater,
            R.layout.li_desired_categories,
            parent,
            false
        )
        return DesiredCategoryViewHolder(binding)
    }

    inner class DesiredCategoryViewHolder(private val binding: LiDesiredCategoriesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: Category) {
            binding.category = item
            binding.executePendingBindings()
        }
    }
}
