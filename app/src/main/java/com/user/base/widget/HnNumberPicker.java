package com.user.base.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.NumberPicker;

import com.user.base.R;

import java.lang.reflect.Field;

/**
 * Created by nichol on 2017/11/2.
 */

public class HnNumberPicker extends NumberPicker{
    public HnNumberPicker(Context context) {
        super(context);
        init();
    }

    public HnNumberPicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HnNumberPicker(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    public void addView(View child) {
        super.addView(child);
        updateView(child);
    }

    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
        updateView(child);
    }

    @Override
    public void addView(View child, ViewGroup.LayoutParams params) {
        super.addView(child, params);
        updateView(child);
    }
    private void updateView(View view){
        if (view instanceof EditText){

//            ((EditText)view).setTextSize(50);
//            ((EditText)view).setTextColor(getResources().getColor(R.color.colorAccent));
        }
    }

    private void init(){
        setDescendantFocusability(FOCUS_BLOCK_DESCENDANTS);
    }

    public void setSelectionDividerColor(NumberPicker numberPicker){
        Field[] pickerFields = NumberPicker.class.getDeclaredFields();
        for (Field pf :pickerFields){
            if (pf.getName().equals("mSelectionDivider")){
                pf.setAccessible(true);
                try {
                    pf.set(numberPicker,new ColorDrawable(getResources().getColor(R.color.colorPrimaryDark)));
                }catch (Exception e){

                }
                break;
            }
        }

    }
}
