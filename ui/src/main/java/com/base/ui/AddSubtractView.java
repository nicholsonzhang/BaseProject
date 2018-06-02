package com.base.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;


import com.base.ui.listener.OnCountChangeListener;

import butterknife.BindView;
import butterknife.OnClick;

public class AddSubtractView extends BaseFrameLayout {

    @BindView(R2.id.current)
    TextView mCurrentTV;


    private OnCountChangeListener mOnCountChangeListener;
    private int mCurrent = 1;

    private int mMaxValue = Integer.MAX_VALUE;
    private int mMinValue = 1;

    public AddSubtractView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public AddSubtractView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AddSubtractView(Context context) {
        super(context);
    }

    @Override
    protected int getInflatedLayout() {
        return R.layout.widget_add_subtract;
    }

    @Override
    protected void onInitializeCompleted(View parentView) {
    }

    /**
     * 设置当前的数量
     *
     * @param count
     */

    public void setCurrentCount(int count) {
        mCurrent = count;
        mCurrentTV.setText(String.valueOf(count));
    }

    public int getCurrentCount() {
        return mCurrent;
    }

    public void setMaxValue(int max) {
        mMaxValue = max;
    }

    public void setMinValue(int min) {
        mMinValue = min;
    }

    @OnClick(R2.id.subtract)
    void clickSubtract() {

        if (mCurrent <= mMinValue) {
            return;
        }
        mCurrent = mCurrent - 1;
        mCurrentTV.setText(String.valueOf(mCurrent));
        if (mOnCountChangeListener != null) {
            mOnCountChangeListener.onCountChange(mCurrent);
        }


    }

    @OnClick(R2.id.add)
    void clickAdd() {

        if (mCurrent >= mMaxValue) {
            return;
        }
        mCurrent = mCurrent + 1;
        mCurrentTV.setText(String.valueOf(mCurrent));
        if (mOnCountChangeListener != null) {
            mOnCountChangeListener.onCountChange(mCurrent);
        }

    }

    public void setOnCountChangeListener(OnCountChangeListener onCountChangeListener) {
        mOnCountChangeListener = onCountChangeListener;
    }


}
