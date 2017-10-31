package com.user.base.mine;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.widget.TextView;
import android.widget.Toast;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.prolificinteractive.materialcalendarview.OnMonthChangedListener;
import com.user.base.BaseActivity;
import com.user.base.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import butterknife.BindView;

/**
 * Created by user on 2017/10/20.
 * 测试自定义日历控件
 */

public class CustomizedCalendarActivity extends BaseActivity implements OnDateSelectedListener, OnMonthChangedListener{
    private static final DateFormat FORMATTER = SimpleDateFormat.getDateInstance();
    @BindView(R.id.calendar_view)
    MaterialCalendarView mCalendarView;
    @BindView(R.id.current_date)
    TextView mCurrentDate;


    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_customized_calendar;
    }

    @Override
    protected void initViews() {
        mCalendarView.setOnDateChangedListener(this);
        mCalendarView.setOnMonthChangedListener(this);
//        mCalendarView.setShowOtherDates(MaterialCalendarView.SHOW_ALL);
        Calendar instance = Calendar.getInstance();
        mCalendarView.setSelectedDate(instance.getTime());

      //设置日历的日期上下限
        Calendar instance1 = Calendar.getInstance();
        instance1.set(instance1.get(Calendar.YEAR), Calendar.JANUARY, 1);
        Calendar instance2 = Calendar.getInstance();
        instance2.set(instance2.get(Calendar.YEAR), Calendar.DECEMBER, 31);
        mCalendarView.state().edit()
                .setMinimumDate(instance1.getTime())
                .setMaximumDate(instance2.getTime())
                .setCalendarDisplayMode(CalendarMode.MONTHS)
                .commit();

//        mCalendarView.addDecorators(new SelectedDecorator(this), new HighlightWeekendsDecorator());
//        mCalendarView.addDecorator(new DayDisableDecorator());
        mCalendarView.setArrowColor(getResources().getColor(R.color.colorAccent));
//        mCalendarView.setHeaderTextAppearance(R.style.text_14_fc6a21);
//        mCalendarView.setWeekDayTextAppearance(R.style.text_14_fc6a21);
//        mCalendarView.setDateTextAppearance(R.style.text_14_fc6a21);
        mCalendarView.setTitleFormatter(new HeaderTitleFormatter(getResources().getStringArray(R.array.months)));
        mCalendarView.setWeekDayFormatter(new WeekFormatter(getResources().getStringArray(R.array.weeks)));

    }

    @Override
    public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
        mCurrentDate.setText(getSelectedDatesString(date));
    }

    @Override
    public void onMonthChanged(MaterialCalendarView widget, CalendarDay date) {
        Toast.makeText(this, FORMATTER.format(date.getDate()), Toast.LENGTH_SHORT).show();
    }

    private String getSelectedDatesString(CalendarDay date) {

        if (date == null) {
            return "No Selection";
        }
        return FORMATTER.format(date.getDate());
    }



}
