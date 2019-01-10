package com.tanveershafeeprottoy.basedatabindingcomponents.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.tanveershafeeprottoy.basedatabindingcomponents.listeners.ListItemOnClickListener;
import com.tanveershafeeprottoy.basedatabindingcomponents.viewholders.BaseRecyclerViewHolder;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author Tanveer Shafee Prottoy
 */
public class BaseListAdapter<T> extends RecyclerView.Adapter<BaseRecyclerViewHolder> {
    private int resourceId;
    private int variableId;
    private ListItemOnClickListener listItemOnClickListener;
    private List<T> objList;

    public BaseListAdapter(int resourceId, int variableId,
                           ListItemOnClickListener listItemOnClickListener) {
        this.resourceId = resourceId;
        this.variableId = variableId;
        this.listItemOnClickListener = listItemOnClickListener;
    }

    @Override
    @NonNull
    public BaseRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BaseRecyclerViewHolder<T>(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), resourceId, parent, false), variableId, listItemOnClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseRecyclerViewHolder holder, int position) {
        try {
            holder.bind(objList.get(position));
        }
        catch(Exception e) {

        }
    }

    @Override
    public int getItemCount() {
        try {
            return objList.size();
        }
        catch(NullPointerException n) {
            return 0;
        }
    }

    public void setData(List<T> objList) {
        this.objList = objList;
        notifyDataSetChanged();
    }
}
