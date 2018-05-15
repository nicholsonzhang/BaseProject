package com.user.base.modules.mine;

import android.view.Gravity;
import android.view.View;

import com.base.library.utils.DeviceUtils;
import com.user.base.widget.BaseDialogFragment;
import com.user.base.R;

public class MyDialogFragment extends BaseDialogFragment {
    @Override
    public int getLayoutId() {
        return R.layout.dialog_my_fragment;
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void initData() {

    }


    @Override
    protected int getDialogLocation() {
        return Gravity.CENTER;
    }


    @Override
    protected int getDialogWidth() {
        int width = DeviceUtils.getScreenWidth(getActivity());

        return (int) (width * 0.8);
    }
}
