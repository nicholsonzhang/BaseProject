package com.user.base;

import com.user.base.base.BaseFragment;
import com.user.base.base.BasePresenter;

/**
 * 公共基类，和业务有关的，所有fragment都继承这个
 */
public abstract class AppBaseFragment<T extends BasePresenter> extends BaseFragment<T> {
}
