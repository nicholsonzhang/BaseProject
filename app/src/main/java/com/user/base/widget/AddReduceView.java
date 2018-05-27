package com.user.base.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.user.base.R;

/**
 * 加减按钮，
 */
public class AddReduceView extends LinearLayout{
    public AddReduceView(Context context) {
        super(context);
        init(context);
    }

    public AddReduceView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public AddReduceView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);

    }

    private void init(Context context){
        LayoutInflater.from(context).inflate(R.layout.view_add_reduce,this);

    }
}
