package com.base.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import butterknife.ButterKnife;


public abstract class BaseFrameLayout extends FrameLayout {

    public BaseFrameLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    public BaseFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public BaseFrameLayout(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View root = LayoutInflater.from(context).inflate(getInflatedLayout(), this);

        if (!isInEditMode()){
            ButterKnife.bind(this,root);
        }
        this.onInitializeCompleted(root);
    }

    protected abstract int getInflatedLayout();

    protected abstract void onInitializeCompleted(View parentView);

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

}
