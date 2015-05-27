package com.dystu.toolbar;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2015/5/26.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String>  mItemList;

    public RecyclerAdapter(List<String> mItemList) {
        this.mItemList = mItemList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();

        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);

        return RecyclerItemViewHolder.newInstance(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        RecyclerItemViewHolder ViewHolder = (RecyclerItemViewHolder)holder;
        String itemText = mItemList.get(position);
        ViewHolder.setItemText(itemText);
        ViewHolder.setItemTextColor(Color.BLACK);
    }

    @Override
    public int getItemCount() {
        return mItemList == null ? 0: mItemList.size();
    }
}
