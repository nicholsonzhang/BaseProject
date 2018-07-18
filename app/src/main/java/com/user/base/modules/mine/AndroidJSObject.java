package com.user.base.modules.mine;

import android.content.Context;
import android.webkit.JavascriptInterface;

import com.user.base.utils.ToastUtils;

public class AndroidJSObject {

    private Context mContext;

    public AndroidJSObject(Context context) {
        mContext = context;
    }

    @JavascriptInterface
    public void hello(String message) {
        ToastUtils.show(mContext, message);
    }
}
