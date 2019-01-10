package com.tanveershafeeprottoy.basedatabindingcomponents.viewholders;

import android.view.View;

import com.tanveershafeeprottoy.basedatabindingcomponents.listeners.ListItemOnClickListener;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author Tanveer Shafee Prottoy
 */
public class BaseRecyclerViewHolder<T> extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
    private ViewDataBinding viewDataBinding;
    private int variableId;
    private ListItemOnClickListener listItemOnClickListener;

    public BaseRecyclerViewHolder(ViewDataBinding viewDataBinding, int variableId,
                                  ListItemOnClickListener listItemOnClickListener) {
        super(viewDataBinding.getRoot());
        this.viewDataBinding = viewDataBinding;
        this.variableId = variableId;
        this.listItemOnClickListener = listItemOnClickListener;
        if(listItemOnClickListener != null) {
            View viewRoot = viewDataBinding.getRoot();
            viewRoot.setOnClickListener(this);
            viewRoot.setOnLongClickListener(this);
        }
    }

    public void bind(T type) {
        viewDataBinding.setVariable(variableId, type);
        viewDataBinding.executePendingBindings();
    }

    @Override
    public void onClick(View view) {
        listItemOnClickListener.onItemClick(getAdapterPosition());
    }

    @Override
    public boolean onLongClick(View view) {
        return listItemOnClickListener.onItemLongClick(getAdapterPosition());
    }
}
