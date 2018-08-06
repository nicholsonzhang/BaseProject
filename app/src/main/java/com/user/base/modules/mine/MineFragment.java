package com.user.base.modules.mine;

import android.content.Intent;

import com.user.base.AppBaseFragment;
import com.user.base.R;
import com.user.base.mine.CustomizedCalendarActivity;
import com.user.base.mine.CustomizedDatePickerActivity;
import com.user.base.mine.GoogleCalendarActivity;
import com.user.base.mine.TestFragmentActivity;
import com.user.base.modules.mine.kotlin.TestKotlinActivity;

import butterknife.OnClick;

/**
 * Created by user on 2017/8/2.
 */

public class MineFragment extends AppBaseFragment {
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
        Intent intent = new Intent(getActivity(), TestEditTextActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.test_component)
    void clickTestComponent() {
        Intent intent = new Intent(getActivity(), TestComponentActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.test_recycler_view)
    void clickTestRV() {
        Intent intent = new Intent(getActivity(), TestRecyclerViewActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.test_web_view)
    void clickWebView() {
        Intent intent = new Intent(getActivity(), TestWebViewActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.test_pay)
    void clickPay() {
        Intent intent = new Intent(getActivity(), TestPayActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.test_wheel_view)
    void clickWheelView() {
        Intent intent = new Intent(getActivity(), TestWheelViewActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.test_ok_http)
    void clickokhttp() {
        Intent intent = new Intent(getActivity(), TestOkActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.test_pull_down)
    void clickPullDown() {
        Intent intent = new Intent(getActivity(), TestPullDownActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.test_kotlin)
    void clickKotlin() {
        Intent intent = new Intent(getActivity(), TestKotlinActivity.class);
        startActivity(intent);
    }

}
