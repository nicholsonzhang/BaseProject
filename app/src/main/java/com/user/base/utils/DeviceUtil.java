package com.user.base.utils;

import android.content.Context;

/**
 * Created by user on 2017/8/21.
 */

public class DeviceUtil {

    public static int dp2px(Context context,float dp){
        float density = context.getResources().getDisplayMetrics().density;
        return (int)(dp*density+0.5f);
    }

    public static int px2dp(Context context, float px){
        float density = context.getResources().getDisplayMetrics().density;
        return (int)(px/density +0.5f);
    }
}
