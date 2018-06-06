package com.user.base.utils;

import android.support.annotation.Nullable;

public class TextUtils {

    public static boolean isValid(@Nullable CharSequence str){
        return str != null && str.length() != 0;
    }

}
