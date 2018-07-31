package com.user.base.widget.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.user.base.R;

public class ZDialogBuilder<T extends ZDialogBuilder> {

    protected Context mContext;

    protected String mTitle;

    protected String mMessage;
    protected ZDialog mDialog;
    protected LayoutInflater mInflater;
    protected LinearLayout mRootView;

    public ZDialogBuilder(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }


    public T setTitle(String title) {
        mTitle = title;
        return (T) this;
    }


    public ZDialog show() {
        ZDialog dialog = create();
        dialog.show();
        return dialog;
    }

    public ZDialog create() {
        mDialog = new ZDialog(mContext);
        //TODO


        return mDialog;
    }

    protected void setTitle() {

    }


    protected boolean hasTitle() {
        return !TextUtils.isEmpty(mTitle);
    }
}
