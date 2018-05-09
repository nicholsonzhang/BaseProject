package com.user.base.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.SwitchCompat;
import android.util.AttributeSet;

import com.user.base.R;

/**
 * 第一版，直接修改样式
 */
public class CustomSwitch extends SwitchCompat {
    public CustomSwitch(Context context) {
        this(context,null);
    }

    public CustomSwitch(Context context, AttributeSet attrs) {
        this(context,attrs, android.support.v7.appcompat.R.attr.switchStyle);

    }

    public CustomSwitch(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        Drawable trackDrawable = getResources().getDrawable(R.drawable.custom_switch_track);
        setTrackDrawable(trackDrawable);
        Drawable thumbDrawable = getResources().getDrawable(R.drawable.custom_switch_thumb);
        setThumbDrawable(thumbDrawable);

    }
}
