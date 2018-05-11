package com.user.base.modules.mine;


import android.util.Log;

import com.user.base.R;
import com.user.base.base.BaseActivity;
import com.user.base.pay.PayApi;
import com.user.base.utils.ToastUtils;


import butterknife.OnClick;


public class TestPayActivity extends BaseActivity {


    @Override
    protected int getContentViewId() {
        return R.layout.activity_test_pay;
    }

    @Override
    protected void initViews() {


    }


    @OnClick(R.id.btn_alipay)
    void clickAlipay() {


        PayApi.payAli(this, "", new PayApi.OnPayListener() {
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
}
