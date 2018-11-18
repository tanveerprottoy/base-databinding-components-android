package com.tanveershafeeprottoy.basedatabindingcomponents.listeners

interface ListItemOnClickListener {

    fun onItemClick(adapterPosition: Int)

    fun onItemLongClick(adapterPosition: Int): Boolean
}