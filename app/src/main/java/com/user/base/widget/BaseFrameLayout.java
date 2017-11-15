package com.user.base.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import butterknife.ButterKnife;

/**
 * Created by user on 2017/11/9.
 */

public abstract class BaseFrameLayout extends FrameLayout {
    public BaseFrameLayout(@NonNull Context context) {
        super(context);
        init(context);
    }

    public BaseFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public BaseFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
    private void init(Context context){
        View root = LayoutInflater.from(context).inflate(getLayoutId(),this);
        if (!isInEditMode()){
            ButterKnife.bind(root,this);
        }
        onViewInitialized();
    }
    protected abstract int getLayoutId();
    protected abstract void onViewInitialized();
}
