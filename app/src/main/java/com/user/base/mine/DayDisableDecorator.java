package com.user.base.mine;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;

/**
 * Created by user on 2017/10/20.
 */

public class DayDisableDecorator implements DayViewDecorator {
    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return day.getDay() < 10;
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.setDaysDisabled(true);

    }
}
