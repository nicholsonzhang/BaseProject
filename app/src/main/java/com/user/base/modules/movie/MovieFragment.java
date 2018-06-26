package com.user.base.modules.movie;


import android.graphics.Typeface;

import com.user.base.AppBaseFragment;
import com.user.base.R;

/**
 * Created by user on 2017/8/2.
 */

public class MovieFragment extends AppBaseFragment {


    private String imageUril = "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2434998280,2186154073&fm=26&gp=0.jpg";

    @Override
    protected int getContentViewId() {
        return R.layout.f_movie;
    }

    @Override
    protected void initViews() {


    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);

    }
}
