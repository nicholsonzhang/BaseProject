package com.user.base.widget;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;

/**
 * Created by user on 2017/8/21.
 */

public class SimpleDialog  extends Dialog{


    public SimpleDialog(@NonNull Context context) {
        super(context);
    }

    public SimpleDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }
}
