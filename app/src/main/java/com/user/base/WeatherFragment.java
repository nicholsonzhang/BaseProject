package com.user.base;

import android.text.InputFilter;
import android.widget.EditText;

import butterknife.BindView;

/**
 * Created by user on 2017/8/2.
 */

public class WeatherFragment extends BaseFragment {
    @BindView(R.id.edit)
    EditText mEditText;
    @Override
    protected int getContentViewId() {
        return R.layout.f_weather;
    }

    @Override
    protected void initViews() {

        mEditText.setFilters(new InputFilter[]{new TestFilter()});

    }


}
