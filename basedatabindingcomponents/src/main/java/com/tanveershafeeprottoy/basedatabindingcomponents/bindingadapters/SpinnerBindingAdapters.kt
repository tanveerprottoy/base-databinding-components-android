package com.tanveershafeeprottoy.basedatabindingcomponents.bindingadapters

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.widget.AppCompatSpinner
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener

object SpinnerBindingAdapters {

    @JvmStatic
    @BindingAdapter(value = ["selectedValue", "selectedValueAttrChanged"], requireAll = false)
    fun bindSpinnerData(appCompatSpinner: AppCompatSpinner, newSelectedValue: Any?, newTextAttrChanged: InverseBindingListener) {
        appCompatSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                if(newSelectedValue != null && newSelectedValue == parent.selectedItem) {
                    return
                }
                newTextAttrChanged.onChange()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
        if(newSelectedValue != null) {
            if(appCompatSpinner.adapter == null) {
                return
            }
            @Suppress("UNCHECKED_CAST")
            appCompatSpinner.setSelection((appCompatSpinner.adapter as ArrayAdapter<Any?>).getPosition(newSelectedValue), true)
        }
    }

    @JvmStatic
    @InverseBindingAdapter(attribute = "selectedValue", event = "selectedValueAttrChanged")
    fun retrieveSelectedValue(appCompatSpinner: AppCompatSpinner): Any? {
        return appCompatSpinner.selectedItem
    }
}