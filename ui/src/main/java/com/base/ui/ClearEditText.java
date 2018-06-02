package com.base.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;



public class ClearEditText extends android.support.v7.widget.AppCompatEditText implements View.OnTouchListener, View.OnFocusChangeListener, TextWatcher {

    private Drawable mClearIcon;

    private int mClearIconHeight;
    private int mClearIconWidth;
    private OnTouchListener mOnTouchListener;
    private OnFocusChangeListener mOnFocusChangeListener;

    public ClearEditText(Context context) {
        this(context, null);
    }

    public ClearEditText(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.editTextStyle);
    }

    public ClearEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ClearEditText, defStyleAttr, 0);
        mClearIconHeight = a.getDimensionPixelSize(R.styleable.ClearEditText_clearIconHeight, 0);
        mClearIconWidth = a.getDimensionPixelSize(R.styleable.ClearEditText_clearIconWidth, 0);


        a.recycle();

        mClearIcon = getCompoundDrawables()[2];
        if (mClearIcon == null) {
            //没有设置，就用默认的
            Drawable drawable = ContextCompat.getDrawable(context, R.drawable.icon_clear);
            Drawable wrappedDrawable = DrawableCompat.wrap(drawable);
            DrawableCompat.setTint(wrappedDrawable, getCurrentHintTextColor());
            mClearIcon = wrappedDrawable;
        }
        if (mClearIconHeight == 0 || mClearIconWidth == 0) {
            mClearIconHeight = mClearIcon.getIntrinsicHeight();
            mClearIconWidth = mClearIcon.getIntrinsicWidth();
        }
        mClearIcon.setBounds(0, 0, mClearIconWidth, mClearIconHeight);


        setClearIconVisible(false);
        super.setOnTouchListener(this);
        super.setOnFocusChangeListener(this);
        addTextChangedListener(this);

    }


    private void setClearIconVisible(boolean visible) {
        mClearIcon.setVisible(visible, false);
        Drawable[] drawables = getCompoundDrawables();

        setCompoundDrawables(drawables[0], drawables[1], visible ? mClearIcon : null, drawables[3]);


    }

    public void setOnTouchListener(OnTouchListener listener) {
        mOnTouchListener = listener;
    }

    public void setOnFocusChangeListener(OnFocusChangeListener listener) {
        mOnFocusChangeListener = listener;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int x = (int) event.getX();
        if (mClearIcon.isVisible() && x > getWidth() - getPaddingRight() - mClearIconWidth) {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                setError(null);
                setText("");
            }
            return true;
        }

        return mOnTouchListener != null && mOnTouchListener.onTouch(v, event);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {
            setClearIconVisible(getText().length() > 0);
        } else {
            setClearIconVisible(false);
        }
        if (mOnFocusChangeListener != null) {
            mOnFocusChangeListener.onFocusChange(v, hasFocus);
        }

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {


    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (isFocused()) {
            setClearIconVisible(s.length() > 0);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
