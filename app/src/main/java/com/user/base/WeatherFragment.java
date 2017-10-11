package com.user.base;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.InputFilter;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;

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
