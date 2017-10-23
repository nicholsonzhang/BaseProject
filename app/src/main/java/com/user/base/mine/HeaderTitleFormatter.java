package com.user.base.mine;

import android.text.SpannableStringBuilder;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.format.TitleFormatter;

/**
 * Created by user on 2017/10/20.
 * 日历头部的月份 年份显示
 */

public class HeaderTitleFormatter implements TitleFormatter {
    private CharSequence[] months;

    public HeaderTitleFormatter(CharSequence[] months) {
        this.months = months;
    }

    @Override
    public CharSequence format(CalendarDay day) {
        return new SpannableStringBuilder()
                .append(months[day.getMonth()])
                .append(" ")
                .append(String.valueOf(day.getYear()));
    }
}
