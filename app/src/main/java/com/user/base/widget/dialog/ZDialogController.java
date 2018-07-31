package com.user.base.widget.dialog;

import android.content.Context;

class ZDialogController {

    public final Context mContext;
    public CharSequence mTitle;
    public CharSequence mContent;
    public boolean mCancelable;
    public CharSequence mPositiveText;
    public ZDialogInterface.OnClickListener mPositiveButtonListener;
    public ZDialogController(Context context) {
        mContext = context;
    }
}
