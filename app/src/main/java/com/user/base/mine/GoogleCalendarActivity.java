package com.user.base.mine;

import android.widget.CalendarView;

import com.user.base.AppBaseActivity;
import com.user.base.R;

import butterknife.BindView;

/**
 * Created by user on 2017/10/20.
 */

public class GoogleCalendarActivity extends AppBaseActivity {

    @BindView(R.id.calendar)
    CalendarView mCalendarView;
    @Override
    protected int getContentViewId() {
        return R.layout.activity_google_calendar;
    }

    @Override
    protected void initViews() {


    }
}
