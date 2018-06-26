package com.user.base.widget.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.support.v7.app.AppCompatDialog;

import com.user.base.R;

/**
 * Created by user on 2017/8/21.
 */

public class SimpleDialog extends AppCompatDialog {


    public SimpleDialog(@NonNull Context context) {
        this(context, R.style.Simple_Dialog);
    }

    public SimpleDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }


    public static class SingleMessageBuilder extends SimpleDialogBuilder<SingleMessageBuilder> {


        private String mMessage;

        public SingleMessageBuilder(Context context) {
            super(context);
        }


        public SingleMessageBuilder setMessage(String message) {
            mMessage = message;
            return this;
        }
    }
}
