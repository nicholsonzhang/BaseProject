package com.user.base;

import com.user.base.base.BaseActivity;
import com.user.base.presenter.BasePresenter;

/**
 * 公共基类，和业务有关的，所有activity都集成这个
 */

public abstract class AppBaseActivity<T extends BasePresenter> extends BaseActivity<T> {
}