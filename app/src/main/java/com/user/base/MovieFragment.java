package com.user.base;

import android.util.Log;
import android.widget.ImageView;

import com.user.base.imageloader.ImageLoaderClient;

import butterknife.BindView;

/**
 * Created by user on 2017/8/2.
 */

public class MovieFragment extends BaseFragment {
    @BindView(R.id.image)
    ImageView mImageView;

    private String imageUril = "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2434998280,2186154073&fm=26&gp=0.jpg";
    @Override
    protected int getContentViewId() {
        return R.layout.f_movie;
    }

    @Override
    protected void initViews() {
        ImageLoaderClient.display(this,imageUril,mImageView);

    }
}
