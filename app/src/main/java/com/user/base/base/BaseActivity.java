package com.user.base.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;



import butterknife.ButterKnife;

/**
 * 公共基类，和业务无关的
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView {

    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getContentViewId() > 0) {
            setContentView(getContentViewId());
        }

        mPresenter = getPresenter();

        ButterKnife.bind(this);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            disposeBundle(extras);
        }

        initViews();
        executeRequest();
    }

    protected abstract int getContentViewId();

    protected abstract void initViews();

    protected void executeRequest() {
    }

    protected void disposeBundle(Bundle bundle) {

    }

    public T getPresenter(){
        return null;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null){
            mPresenter.detachView();
        }
    }
}
