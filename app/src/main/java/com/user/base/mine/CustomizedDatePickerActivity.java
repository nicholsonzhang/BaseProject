package com.user.base.mine;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import android.widget.NumberPicker;

import com.user.base.BaseActivity;
import com.user.base.R;

import butterknife.BindView;

/**
 * Created by user on 2017/10/31.
 */

public class CustomizedDatePickerActivity extends BaseActivity {

    @BindView(R.id.date_picker)
    DatePicker mDatePicker;
    @Override
    protected int getContentViewId() {
        return R.layout.activity_customized_date_picker;
    }

    @Override
    protected void initViews() {


    }
}
