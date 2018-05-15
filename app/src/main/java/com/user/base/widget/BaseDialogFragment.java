package com.user.base.widget;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import butterknife.ButterKnife;

import com.user.base.R;

/**
 * 对DialogFragment进行简易封装，使用更简单
 * 主题，位置，是否dialog外取消，宽高 都可以自定义
 */
public abstract class BaseDialogFragment extends AppCompatDialogFragment {


    protected static final int THEME_1 = R.style.DialogFragment_Theme_1;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_TITLE, initTheme());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this, view);
        initView(view);
        return view;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        initDialog();
    }

    private void initDialog() {
        this.getDialog().setCancelable(cancelable());
        this.getDialog().setCanceledOnTouchOutside(cancelable());
        Window window = this.getDialog().getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.gravity = getDialogLocation();
        lp.width = getDialogWidth();
        lp.height = getDialogHeight();
        window.setAttributes(lp);
    }


    public abstract int getLayoutId();

    public abstract void initView(View view);

    public abstract void initData();

    /**
     * 点击dialog外能否是dialog消失
     */
    protected boolean cancelable() {
        return true;
    }

    /**
     * 设置dialog在屏幕的位置，Gravity
     */
    protected int getDialogLocation() {
        return Gravity.CENTER;
    }

    /**
     * 自定义theme,可以在子类中修改
     */
    protected int initTheme() {
        return THEME_1;
    }

    protected int getDialogHeight() {
        return WindowManager.LayoutParams.WRAP_CONTENT;
    }

    protected int getDialogWidth() {
        return WindowManager.LayoutParams.WRAP_CONTENT;
    }
}
