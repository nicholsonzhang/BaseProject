package com.user.base.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by user on 2017/8/1.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getContentViewId() > 0) {
            setContentView(getContentViewId());
        }
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
}
