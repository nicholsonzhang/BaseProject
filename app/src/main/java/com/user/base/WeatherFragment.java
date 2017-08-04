package com.user.base;

import android.util.Log;

/**
 * Created by user on 2017/8/2.
 */

public class WeatherFragment extends BaseFragment {
    @Override
    protected int getContentViewId() {
        return R.layout.f_weather;
    }

    @Override
    protected void initViews() {
        Log.e("yyzhang","WeatherFragment initViews");

    }
}
