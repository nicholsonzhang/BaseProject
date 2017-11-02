package com.user.base.mine;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import android.widget.NumberPicker;

import com.user.base.BaseActivity;
import com.user.base.R;
import com.user.base.widget.HnNumberPicker;

import butterknife.BindView;

/**
 * Created by user on 2017/10/31.
 */

public class CustomizedDatePickerActivity extends BaseActivity {

    @BindView(R.id.number_picker)
    HnNumberPicker mHnNumberPicker;
    @BindView(R.id.number_picker2)
    HnNumberPicker mHnNumberPicker2;
    @BindView(R.id.number_picker3)
    HnNumberPicker mHnNumberPicker3;
    @Override
    protected int getContentViewId() {
        return R.layout.activity_customized_date_picker;
    }

    @Override
    protected void initViews() {
        mHnNumberPicker.setMaxValue(10);
        mHnNumberPicker.setMinValue(1);
        mHnNumberPicker.setValue(3);
        mHnNumberPicker.setSelectionDividerColor(mHnNumberPicker);

        mHnNumberPicker2.setMaxValue(10);
        mHnNumberPicker2.setMinValue(1);
        mHnNumberPicker2.setValue(4);

        mHnNumberPicker3.setMaxValue(10);
        mHnNumberPicker3.setMinValue(1);
        mHnNumberPicker3.setValue(5);



    }
}
