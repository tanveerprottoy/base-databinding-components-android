package com.tanveershafeeprottoy.basedatabindingcomponents.viewholders

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.tanveershafeeprottoy.basedatabindingcomponents.listeners.ListItemOnClickListener

open class BaseRecyclerViewHolder(private val viewDataBinding: ViewDataBinding, private val variableId: Int, listItemOnClickListener: ListItemOnClickListener?) : RecyclerView.ViewHolder(viewDataBinding.root) {

    init {
        if(listItemOnClickListener != null) {
            viewDataBinding.root.setOnClickListener {
                listItemOnClickListener.onItemClick(this.adapterPosition)
            }
            viewDataBinding.root.setOnLongClickListener {
                listItemOnClickListener.onItemLongClick(this.adapterPosition)
            }
        }
    }

    fun bind(any: Any?) {
        viewDataBinding.setVariable(variableId, any)
        viewDataBinding.executePendingBindings()
    }
}