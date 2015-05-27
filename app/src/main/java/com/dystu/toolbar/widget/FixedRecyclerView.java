package com.dystu.toolbar.widget;

import android.content.Context;
import android.util.AttributeSet;

import com.github.ksoichiro.android.observablescrollview.ObservableRecyclerView;


public class FixedRecyclerView extends ObservableRecyclerView {
    public FixedRecyclerView(Context context) {
        super(context);
    }

    public FixedRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FixedRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

//    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
//    @Override
//    public boolean canScrollVertically(int direction) {
//        // check if scrolling up
//        if (direction < 1) {
//            boolean original = super.canScrollVertically(direction);
//            return !original && getChildAt(0) != null && getChildAt(0).getTop() < 0 || original;
//        }
//        return super.canScrollVertically(direction);
//    }
}