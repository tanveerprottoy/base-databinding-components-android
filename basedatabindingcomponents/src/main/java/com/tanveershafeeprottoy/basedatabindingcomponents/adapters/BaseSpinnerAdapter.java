package com.tanveershafeeprottoy.basedatabindingcomponents.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.tanveershafeeprottoy.basedatabindingcomponents.viewholders.BaseSpinnerAdapterViewHolder;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/**
 * @author Tanveer Shafee Prottoy
 */
public class BaseSpinnerAdapter<T> extends ArrayAdapter<T> {
    private int resourceId;
    private int variableId;
    private List<T> objList;

    public BaseSpinnerAdapter(Context context, int resourceId, int variableId, List<T> objList) {
        super(context, resourceId, objList);
        this.resourceId = resourceId;
        this.variableId = variableId;
        this.objList = objList;
    }

    @Override
    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        return getRowView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, View convertView, @NonNull ViewGroup parent) {
        return getRowView(position, convertView, parent);
    }

    @Override
    public int getCount() {
        try {
            return objList.size();
        }
        catch(NullPointerException n) {
            return 0;
        }
    }

    private View getRowView(int position, View convertView, ViewGroup parent) {
        BaseSpinnerAdapterViewHolder baseSpinnerAdapterViewHolder;
        if(convertView == null) {
            ViewDataBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), resourceId, parent, false);
            baseSpinnerAdapterViewHolder = new BaseSpinnerAdapterViewHolder(viewDataBinding);
            convertView = viewDataBinding.getRoot();
            convertView.setTag(baseSpinnerAdapterViewHolder);
        }
        else {
            baseSpinnerAdapterViewHolder = (BaseSpinnerAdapterViewHolder) convertView.getTag();
        }
        baseSpinnerAdapterViewHolder.getViewDataBinding().setVariable(variableId, objList.get(position));
        return convertView;
    }
}
