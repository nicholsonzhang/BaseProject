package com.user.base;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.pm.PackageManager;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.user.base.imageloader.GlideApp;
import com.user.base.imageloader.ImageLoader;
import com.user.base.utils.DeviceUtil;
import com.user.base.widget.GlideCircleTransform;
import com.user.base.widget.GlideRoundTransform;

import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by user on 2017/8/2.
 */

public class MovieFragment extends BaseFragment {




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
