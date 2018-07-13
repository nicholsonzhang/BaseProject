package com.user.base;

import com.user.base.base.BaseActivity;
import com.user.base.base.BasePresenter;

import io.reactivex.disposables.CompositeDisposable;

/**
 * 公共基类，和业务有关的，所有activity都继承这个
 */

public abstract class AppBaseActivity<T extends BasePresenter> extends BaseActivity<T> {


    protected CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
        }
    }
}
