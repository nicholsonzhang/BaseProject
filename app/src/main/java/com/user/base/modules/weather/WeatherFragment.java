package com.user.base.modules.weather;

import android.widget.ImageView;

import com.user.base.base.BaseFragment;
import com.user.base.R;

import butterknife.BindView;

/**
 * Created by user on 2017/8/2.
 */

public class WeatherFragment extends BaseFragment {
    @BindView(R.id.test)
    ImageView mImageView;
    @Override
    protected int getContentViewId() {
        return R.layout.f_weather;
    }

    @Override
    protected void initViews() {


    }


}
