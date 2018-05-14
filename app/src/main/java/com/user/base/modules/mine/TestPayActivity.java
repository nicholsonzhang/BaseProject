package com.user.base.modules.mine;


import com.user.base.R;
import com.user.base.base.BaseActivity;
import com.user.base.pay.PayApi;
import com.user.base.pay.WXPayReq;
import com.user.base.presenter.MyPayPresenter;
import com.user.base.presenter.MyPayView;
import com.user.base.utils.ToastUtils;


import butterknife.OnClick;


public class TestPayActivity extends BaseActivity<MyPayPresenter> implements MyPayView {



    @Override
    protected int getContentViewId() {
        return R.layout.activity_test_pay;
    }

    @Override
    protected void initViews() {

        mPresenter.attachView(this);


    }

    @Override
    public MyPayPresenter getPresenter() {
        return new MyPayPresenter();
    }

    @OnClick(R.id.btn_alipay)
    void clickAlipay() {


        PayApi.getInstance().payAli(this, "", new PayApi.OnPayListener() {
            @Override
            public void paySuccess(String success) {
                ToastUtils.show(TestPayActivity.this, success);
            }

            @Override
            public void payFail(String error) {
                ToastUtils.show(TestPayActivity.this, error);


            }
        });
    }

    @OnClick(R.id.btn_wechat)
    void clickWeChat() {

        WXPayReq request = new WXPayReq();
        request.setAppId("wxd930ea5d5a258f4f");
        request.setPartnerId("1900000109");
        request.setPrepayId("1101000000140415649af9fc314aa427");
        request.setPackageValue("Sign=WXPay");
        request.setNonceStr("1101000000140429eb40476f8896f4c9");
        request.setTimeStamp("1398746574");
        request.setSign("7FFECB600D7157C5AA49810D2D8F28BC2811827B");

        PayApi.getInstance().payWeChat(this, request);
    }

    @OnClick(R.id.btn_getdata)
    void getData() {
        mPresenter.getData();
    }

    @Override
    public void showMessage(String message) {

        ToastUtils.show(this,message);

    }
}
