package org.diyorbek.recyclerviewanim_dragdrop_h1.adapter

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.SimpleCallback
import androidx.recyclerview.widget.ItemTouchHelper.*
import androidx.recyclerview.widget.RecyclerView
import org.diyorbek.recyclerviewanim_dragdrop_h1.adapter.ItemAdapter


val itemTouchHelper by lazy {
    val itemTouchCallback = object : SimpleCallback(UP or DOWN, START or END) {
        private var adapter = ItemAdapter()
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            adapter = recyclerView.adapter as ItemAdapter
            val from = viewHolder.adapterPosition
            val to = target.adapterPosition
            adapter.modeItem(from, to)
            adapter.notifyItemMoved(from, to)
            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            adapter.notifyItemRemoved(viewHolder.adapterPosition)
        }

        override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
            super.onSelectedChanged(viewHolder, actionState)
            if (actionState == ACTION_STATE_DRAG) {
                viewHolder?.itemView?.alpha = 0.5f
            }
        }

        override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {
            super.clearView(recyclerView, viewHolder)
            viewHolder.itemView.alpha = 1.0f
        }
    }
    ItemTouchHelper(itemTouchCallback)
}

