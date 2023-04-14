package org.diyorbek.recyclerviewanim_dragdrop_h1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import org.diyorbek.recyclerviewanim_dragdrop_h1.R
import org.diyorbek.recyclerviewanim_dragdrop_h1.databinding.ListSampleBinding
import org.diyorbek.recyclerviewanim_dragdrop_h1.model.Item

class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    var itemList: MutableList<Item> = mutableListOf()
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        context = parent.context
        return ItemViewHolder(
            ListSampleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.binding(itemList[position])
        holder.itemView.animation = AnimationUtils.loadAnimation(context, R.anim.anim)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ItemViewHolder(private val binding: ListSampleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun binding(item: Item) {
            binding.apply {
                itemImg.setImageResource(item.image)
                itemName.text = item.name
                itemDesc.text = item.desc
                itemYear.text = item.year
                itemEvol.text = item.score
            }
        }
    }

    fun modeItem(from: Int, to: Int) {
        val thisList = itemList
        val fromLocation = thisList[from]
        if (to < from) {
            thisList.add(to + 1, fromLocation)
        } else {
            thisList.add(to - 1, fromLocation)
        }
        itemList = thisList
    }
}