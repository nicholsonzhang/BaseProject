package com.user.base;

import com.user.base.base.BaseFragment;
import com.user.base.presenter.BasePresenter;

public abstract class AppBaseFragment<T extends BasePresenter> extends BaseFragment<T> {
}
