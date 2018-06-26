package com.user.base.widget.dialog;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.user.base.R;
import com.user.base.utils.TextUtils;

public class SimpleDialogBuilder<T extends SimpleDialogBuilder> {

    protected Context mContext;

    protected String mTitle;

    protected String mMessage;
    protected SimpleDialog mDialog;
    protected LayoutInflater mInflater;
    protected LinearLayout mRootView;
    public SimpleDialogBuilder(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }


    public T setTitle(String title) {
        mTitle = title;
        return (T) this;
    }



    public SimpleDialog show() {
        SimpleDialog dialog = create();
        dialog.show();
        return dialog;
    }

    public SimpleDialog create() {
        mDialog = new SimpleDialog(mContext, R.style.Simple_Dialog);
        //TODO




        return mDialog;
    }

    protected void createTitle(){

    }


    protected boolean hasTitle(){
       return TextUtils.isValid(mTitle);
    }
}
