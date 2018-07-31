package com.user.base.widget.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;
import android.support.v7.app.AppCompatDialog;

import com.user.base.R;


public class ZDialog extends AppCompatDialog {


    public ZDialog(@NonNull Context context) {
        this(context, R.style.Simple_Dialog);
    }

    public ZDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }


//    public static class SingleMessageBuilder extends ZDialogBuilder<SingleMessageBuilder> {
//
//
//        public SingleMessageBuilder(Context context) {
//            super(context);
//        }
//
//
//        public SingleMessageBuilder setMessage(String message) {
//            this.mMessage = message;
//            return this;
//        }
//    }


    public static class Builder {

        private ZDialogController Z;

        public Builder(Context context) {
            Z = new ZDialogController(context);
        }


        public Builder setTitle(@StringRes int titleId) {
            Z.mTitle = Z.mContext.getText(titleId);
            return this;
        }

        public Builder setTitle(@Nullable CharSequence title) {
            Z.mTitle = title;
            return this;
        }

        public Builder setContent(@StringRes int contentId) {
            Z.mContent = Z.mContext.getText(contentId);
            return this;
        }

        public Builder setContent(@Nullable CharSequence content) {
            Z.mContent = content;
            return this;
        }

        public Builder setPositiveButton(@StringRes int textId, ZDialogInterface.OnClickListener listener) {
            Z.mPositiveText = Z.mContext.getText(textId);
            Z.mPositiveButtonListener = listener;
            return this;
        }

        public Builder setPositiveButton(CharSequence text, ZDialogInterface.OnClickListener listener) {
            Z.mPositiveText = text;
            Z.mPositiveButtonListener = listener;
            return this;
        }

        public Builder setCancelable(boolean cancelable) {
            Z.mCancelable = cancelable;
            return this;
        }

        public ZDialog create() {
            final ZDialog dialog = new ZDialog(Z.mContext);

            return dialog;
        }

        public ZDialog show() {
            final ZDialog dialog = create();
            dialog.show();
            return dialog;
        }
    }
}
