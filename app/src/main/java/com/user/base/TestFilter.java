package com.user.base;

import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;

/**
 * Created by user on 2017/9/27.
 */

public class TestFilter implements InputFilter {
    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {

        return source;
    }
}
