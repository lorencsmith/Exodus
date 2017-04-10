package com.example.lorensmith.exodus.util;

import android.content.Context;

/**
 * Created by Loren Smith on 2/8/2017.
 */

public class UtilDensity {
    public static int dip2px(Context context, float dpValue){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int px2dip(Context context, float pxValue){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
