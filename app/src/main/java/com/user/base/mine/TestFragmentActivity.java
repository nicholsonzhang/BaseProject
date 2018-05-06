package com.user.base.mine;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.user.base.base.BaseActivity;
import com.user.base.R;

/**
 * Created by user on 2017/10/30.
 */

public class TestFragmentActivity extends BaseActivity {
    private  FragmentManager mFragmentManager;
    @Override
    protected int getContentViewId() {
        return R.layout.activity_test_fragment;
    }

    @Override
    protected void initViews() {

        TestFragment testFragment = TestFragment.newInstance("1");
        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.add(R.id.container, testFragment,"test");
        transaction.commit();

    }

    public void onHide(View v){
        TestFragment testFragment = (TestFragment) mFragmentManager.findFragmentByTag("test");
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.hide(testFragment);
        transaction.commit();


    }
    public void onShow(View v){
        TestFragment testFragment = (TestFragment) mFragmentManager.findFragmentByTag("test");
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.show(testFragment);
        transaction.commit();


    }
}
