package com.user.base.mine;

import com.prolificinteractive.materialcalendarview.format.WeekDayFormatter;

/**
 * Created by user on 2017/10/20.
 * 日历中 星期几的显示
 */

public class WeekFormatter implements WeekDayFormatter {
    private CharSequence[] weeks;
    public WeekFormatter(CharSequence[] weeks) {
        this.weeks = weeks;
    }

    @Override
    public CharSequence format(int dayOfWeek) {
        return weeks[dayOfWeek-1];
    }
}
