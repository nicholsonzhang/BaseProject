package com.user.base.mine;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.user.base.R;

/**
 * Created by user on 2017/10/20.
 */

public class SelectedDecorator implements DayViewDecorator {
    private Drawable selectedDrawable;
    public SelectedDecorator(Context context){
        selectedDrawable =  context.getResources().getDrawable(R.drawable.my_selector);

    }
    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return true;
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.setSelectionDrawable(selectedDrawable);
//        view.setDaysDisabled(true);
    }
}
