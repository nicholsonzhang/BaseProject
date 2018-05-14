package com.user.base.modules.news;

import android.content.Intent;

import com.user.base.base.BaseFragment;
import com.user.base.R;
import com.user.base.news.QRCodeActivity;
import com.user.base.presenter.MyPayPresenter;
import com.user.base.presenter.MyPayView;
import com.user.base.utils.ToastUtils;

import butterknife.OnClick;

/**
 * Created by user on 2017/8/2.
 */

public class NewsFragment extends BaseFragment<MyPayPresenter> implements MyPayView {




    @Override
    protected int getContentViewId() {
        return R.layout.f_news;
    }

    @Override
    protected void initViews() {
        mPresenter.attachView(this);
    }

    @Override
    protected MyPayPresenter getPresenter() {
        return new MyPayPresenter();
    }

    @OnClick(R.id.ic_qrcode)
    void clickQRcodeScan(){
        Intent intent = new Intent(getActivity(),QRCodeActivity.class);
        startActivity(intent);
    }

    @Override
    public void showMessage(String message) {
        ToastUtils.show(getActivity(),message);
    }

    @OnClick(R.id.btn_getdata)
    void clickBtn(){
        mPresenter.getData();
    }
}
