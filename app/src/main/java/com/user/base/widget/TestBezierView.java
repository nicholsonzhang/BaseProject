package com.user.base.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.user.base.R;

/**
 * Created by user on 2017/10/26.
 */

public class TestBezierView extends View {

    private Drawable mDrawable;
    public TestBezierView(Context context) {
        this(context, null);
    }

    public TestBezierView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TestBezierView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mDrawable = getResources().getDrawable(R.drawable.aa);
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mDrawable.setBounds(0,0,200,400);
        mDrawable.draw(canvas);
    }
}
