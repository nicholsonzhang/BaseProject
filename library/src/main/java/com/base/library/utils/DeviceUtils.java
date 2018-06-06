package com.base.library.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * Created by user on 2017/8/21.
 */

public class DeviceUtils {


    public static final float DENSITY = Resources.getSystem().getDisplayMetrics().density;
    public static int dp2px(float dp) {
        return (int) (dp * DENSITY + 0.5f);
    }

    public static int px2dp(float px) {
        return (int) (px / DENSITY + 0.5f);
    }

    public static int px2sp(Context context, float px) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (px / fontScale + 0.5f);
    }

    public static int sp2px(Context context, float sp) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (sp * fontScale + 0.5f);
    }

    public static int getScreenHeight(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        return dm.heightPixels;
    }

    public static int getScreenWidth(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        return dm.widthPixels;
    }
}
