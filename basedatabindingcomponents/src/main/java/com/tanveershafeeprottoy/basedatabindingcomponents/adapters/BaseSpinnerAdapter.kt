package com.tanveershafeeprottoy.basedatabindingcomponents.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.tanveershafeeprottoy.basedatabindingcomponents.viewholders.BaseSpinnerAdapterViewHolder

class BaseSpinnerAdapter(context: Context, private val resourceId: Int, textViewId: Int, private val variableId: Int, private val anyList: List<Any>) : ArrayAdapter<Any>(context, resourceId, textViewId, anyList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getRowView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getRowView(position, convertView, parent)
    }

    override fun getCount(): Int {
        return try {
            anyList.size
        }
        catch(n: NullPointerException) {
            0
        }
    }

    private fun getRowView(position: Int, convertView: View?, parent: ViewGroup): View {
        var rowView = convertView
        val baseSpinnerAdapterViewHolder: BaseSpinnerAdapterViewHolder
        if(rowView == null) {
            val viewDataBinding: ViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), resourceId, parent, false)
            baseSpinnerAdapterViewHolder = BaseSpinnerAdapterViewHolder(viewDataBinding)
            rowView = viewDataBinding.root
            rowView.tag = baseSpinnerAdapterViewHolder
        }
        else {
            baseSpinnerAdapterViewHolder = rowView.tag as BaseSpinnerAdapterViewHolder
        }
        baseSpinnerAdapterViewHolder.viewDataBinding.setVariable(variableId, anyList[position])
        return rowView
    }
}