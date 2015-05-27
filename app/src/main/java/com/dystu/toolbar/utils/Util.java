package com.dystu.toolbar.utils;

import android.content.Context;

/**
 * Created by Administrator on 2015/5/26.
 */
public class Util {
    public static float dpToPixel(Context context, float dp) {
        float density = context.getResources().getDisplayMetrics().density;
        int pixelValue = (int) (dp * density + 0.5f);
        return pixelValue;
    }

}
