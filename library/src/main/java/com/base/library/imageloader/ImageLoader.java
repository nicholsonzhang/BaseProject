package com.base.library.imageloader;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageLoader {

    public static void display(Context context, String url, ImageView imageView) {
        Glide.with(context).load(url).into(imageView);

    }
}
