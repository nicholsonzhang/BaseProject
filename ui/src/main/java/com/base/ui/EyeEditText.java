package com.base.ui;

import android.content.Context;
import android.util.AttributeSet;

public class EyeEditText extends android.support.v7.widget.AppCompatEditText{
    public EyeEditText(Context context) {
        this(context,null);
    }

    public EyeEditText(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.editTextStyle);

    }

    public EyeEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
