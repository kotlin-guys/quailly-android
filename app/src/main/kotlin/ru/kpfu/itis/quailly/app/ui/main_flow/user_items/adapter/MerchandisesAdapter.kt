package ru.kpfu.itis.quailly.app.ui.main_flow.user_items.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ru.kpfu.itis.quailly.R
import ru.kpfu.itis.quailly.databinding.ItemMerchandiseBinding
import javax.inject.Inject

class MerchandisesAdapter @Inject constructor() :
    RecyclerView.Adapter<MerchandisesAdapter.MerchandiseViewHolder>() {

    var items: List<MerchandiseItemModel> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MerchandiseViewHolder =
        DataBindingUtil.inflate<ItemMerchandiseBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_merchandise,
            parent,
            false
        ).let {
            MerchandiseViewHolder(it)
        }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MerchandiseViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class MerchandiseViewHolder(val binding: ItemMerchandiseBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MerchandiseItemModel) = with(binding) {
            model = item
        }
    }
}