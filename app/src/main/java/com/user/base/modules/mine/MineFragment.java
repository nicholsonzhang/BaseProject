package com.user.base.modules.mine;

import android.content.Intent;

import com.user.base.base.BaseFragment;
import com.user.base.R;
import com.user.base.mine.CustomizedCalendarActivity;
import com.user.base.mine.CustomizedDatePickerActivity;
import com.user.base.mine.GoogleCalendarActivity;
import com.user.base.mine.TestFragmentActivity;

import butterknife.OnClick;

/**
 * Created by user on 2017/8/2.
 */

public class MineFragment extends BaseFragment {
    @Override
    protected int getContentViewId() {
        return R.layout.f_mine;
    }

    @Override
    protected void initViews() {

    }

    @OnClick(R.id.calendar)
    void clickCalendar() {
        Intent intent = new Intent(getActivity(), CustomizedCalendarActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.calendar2)
    void clickCalendar2() {
        Intent intent = new Intent(getActivity(), GoogleCalendarActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.test_fragment)
    void clickTestFragment() {
        Intent intent = new Intent(getActivity(), TestFragmentActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.date_picker)
    void clickDatePicker() {
        Intent intent = new Intent(getActivity(), CustomizedDatePickerActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.test_edit)
    void clickTestEdit() {
        Intent intent = new Intent(getActivity(), TestEditText.class);
        startActivity(intent);
    }

    @OnClick(R.id.test_component)
    void clickTestComponent() {
        Intent intent = new Intent(getActivity(), TestComponentActivity.class);
        startActivity(intent);
    }


}