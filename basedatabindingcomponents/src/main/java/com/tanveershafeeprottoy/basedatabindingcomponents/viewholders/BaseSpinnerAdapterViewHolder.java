package com.tanveershafeeprottoy.basedatabindingcomponents.viewholders;

import androidx.databinding.ViewDataBinding;

/**
 * @author Tanveer Shafee Prottoy
 */
public class BaseSpinnerAdapterViewHolder {
    private ViewDataBinding viewDataBinding;

    public BaseSpinnerAdapterViewHolder(ViewDataBinding viewDataBinding) {
        this.viewDataBinding = viewDataBinding;
    }

    public ViewDataBinding getViewDataBinding() {
        return viewDataBinding;
    }
}
