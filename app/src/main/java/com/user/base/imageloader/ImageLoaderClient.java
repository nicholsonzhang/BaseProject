package com.user.base.imageloader;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.ImageView;
/**
 * Created by user on 2017/8/3.
 * 图片加载框架封装,使用glide
 */

public class ImageLoaderClient {


    public static void display(Context context, String url, ImageView imageView) {
        GlideApp.with(context).load(url).fitCenter().into(imageView);

    }

    public static void display(Fragment fragment, String url, ImageView imageView) {
        GlideApp.with(fragment).load(url).fitCenter().into(imageView);
    }
    public static void display(Fragment fragment, String url, ImageView imageView,int defaultId) {
        GlideApp.with(fragment).load(url).fitCenter().placeholder(defaultId).into(imageView);
        
    }

}
