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
/**
 * Created by user on 2017/10/26.
 */

public class TestBezierView extends View {

    private Paint mPaint = new Paint();
    private Paint mPaint2 = new Paint();
    private Path mPath = new Path();

    public TestBezierView(Context context) {
        this(context, null);
    }

    public TestBezierView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TestBezierView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(5);
        mPaint.setColor(Color.RED);

        mPaint2.setAntiAlias(true);
        mPaint2.setStyle(Paint.Style.FILL);
        mPaint2.setStrokeWidth(5);
        mPaint2.setColor(Color.BLUE);

    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//       RectF rectF = new RectF(0,0,200,100);
//        canvas.drawArc(rectF,0,90,false,mPaint);
//        canvas.drawOval(rectF,mPaint);

       canvas.drawRect(0,0,200,100,mPaint);
        canvas.rotate(40);
        canvas.drawRect(100,400,200,500,mPaint2);





    }
}
