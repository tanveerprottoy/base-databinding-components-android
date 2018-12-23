package com.tanveershafeeprottoy.basedatabindingcomponents.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.tanveershafeeprottoy.basedatabindingcomponents.listeners.ListItemOnClickListener
import com.tanveershafeeprottoy.basedatabindingcomponents.viewholders.BaseRecyclerViewHolder

open class BaseListAdapter<T>(private val resourceId: Int, private val variableId: Int,
                              private val listItemOnClickListener:
                              ListItemOnClickListener?) : RecyclerView.Adapter<BaseRecyclerViewHolder>() {
    private var objList: MutableList<T>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseRecyclerViewHolder {
        return BaseRecyclerViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), resourceId, parent, false), variableId, listItemOnClickListener)
    }

    override fun onBindViewHolder(holder: BaseRecyclerViewHolder, position: Int) {
        try {
            holder.bind(objList!![position])
        }
        catch(e: Exception) {

        }
    }

    override fun getItemCount(): Int {
        return try {
            objList!!.size
        }
        catch(n: NullPointerException) {
            0
        }
    }

    fun setData(objList: MutableList<T>?) {
        this.objList = objList
        notifyDataSetChanged()
    }
}