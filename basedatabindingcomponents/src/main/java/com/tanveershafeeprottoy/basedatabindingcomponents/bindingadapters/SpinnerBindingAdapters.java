package com.tanveershafeeprottoy.basedatabindingcomponents.bindingadapters;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.appcompat.widget.AppCompatSpinner;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseBindingListener;

/**
 * @author Tanveer Shafee Prottoy
 */
public class SpinnerBindingAdapters {

    @BindingAdapter(value = {"selectedValue", "selectedValueAttrChanged"}, requireAll = false)
    public static void bindSpinnerData(AppCompatSpinner appCompatSpinner, Object newSelectedValue, InverseBindingListener inverseBindingListener) {
        appCompatSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(newSelectedValue != null && newSelectedValue == parent.getSelectedItem()) {
                    return;
                }
                inverseBindingListener.onChange();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        if(newSelectedValue != null) {
            if(appCompatSpinner.getAdapter() == null) {
                return;
            }
            appCompatSpinner.setSelection(((ArrayAdapter<Object>) appCompatSpinner.getAdapter()).getPosition(newSelectedValue), true);
        }
    }

    @InverseBindingAdapter(attribute = "selectedValue", event = "selectedValueAttrChanged")
    public static Object retrieveSelectedValue(AppCompatSpinner appCompatSpinner) {
        return appCompatSpinner.getSelectedItem();
    }
}
