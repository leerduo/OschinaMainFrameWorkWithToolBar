package com.dystu.toolbar;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/5/26.
 */
public class RecyclerItemViewHolder extends RecyclerView.ViewHolder {
    private final TextView mItemTextView;

    public RecyclerItemViewHolder(View itemView, TextView mItemTextView) {
        super(itemView);
        this.mItemTextView = mItemTextView;
    }


    public static RecyclerView.ViewHolder newInstance(View view) {
        TextView itemTextView = (TextView) view.findViewById(R.id.itemTextView);
        return new RecyclerItemViewHolder(view, itemTextView);
    }

    public void setItemText(CharSequence c){
        mItemTextView.setText(c);
    }

    public void setItemTextColor(int color){
        mItemTextView.setTextColor(color);
    }


}
