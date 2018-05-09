package com.user.base.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;

import com.user.base.R;

public class XEditText extends android.support.v7.widget.AppCompatEditText {


    private Drawable leftDrawable;
    public XEditText(Context context) {
        this(context,null);
    }

    public XEditText(Context context, AttributeSet attrs) {
        this(context,attrs,android.R.attr.editTextStyle);
    }

    public XEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.XEditText,defStyleAttr,0);
        int leftDrawableWidth = a.getDimensionPixelSize(R.styleable.XEditText_leftDrawableWidth,0);
        int leftDrawableHeight = a.getDimensionPixelSize(R.styleable.XEditText_leftDrawableHeight,0);

        a.recycle();

        int height = (int) getTextSize();


        leftDrawable = getCompoundDrawables()[0];
        if (leftDrawable != null){
            if (leftDrawableHeight != 0 && leftDrawableWidth != 0){
                leftDrawable.setBounds(0,0,leftDrawableWidth,leftDrawableHeight);
            }else {
                leftDrawable.setBounds(0,0,height,height);
            }
            setCompoundDrawables(leftDrawable,null,null,null);//设置左边的drawable
        }
    }

}
