package com.user.base.mine;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewConfigurationCompat;
import android.util.Log;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.DatePicker;

import com.user.base.BaseActivity;
import com.user.base.R;
import com.user.base.widget.HnNumberPicker;

import java.util.Calendar;

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

    @BindView(R.id.date_picker)
    DatePicker mDatePicker;

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


        mDatePicker.setMaxDate(Calendar.getInstance().getTimeInMillis());
//        getLifecycle().addObserver(new MyObserver());
        ViewConfiguration configuration = ViewConfiguration.get(this);
        Log.e("yyzhang","getScaledMaximumFlingVelocity="+configuration.getScaledMaximumFlingVelocity());
        Log.e("yyzhang","getScaledDoubleTapSlop="+configuration.getScaledDoubleTapSlop());
        Log.e("yyzhang","getScaledEdgeSlop="+configuration.getScaledEdgeSlop());
        Log.e("yyzhang","getScaledFadingEdgeLength="+configuration.getScaledFadingEdgeLength());
        Log.e("yyzhang","getScaledTouchSlop="+configuration.getScaledTouchSlop());
        Log.e("yyzhang","getScaledMinimumFlingVelocity="+configuration.getScaledMinimumFlingVelocity());
        Log.e("yyzhang","getDoubleTapTimeout="+ViewConfiguration.getDoubleTapTimeout());
        Log.e("yyzhang","getLongPressTimeout="+ViewConfiguration.getLongPressTimeout());
//        setBadge();
    }

    private void setBadge(){
        Bundle bundle = new Bundle();
        bundle.putString("package", getPackageName());
        String launchClassName = getPackageManager().getLaunchIntentForPackage(getPackageName()).getComponent().getClassName();
        bundle.putString("class", launchClassName);
        bundle.putInt("badgenumber", 3);
        getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", null, bundle);

    }

}
