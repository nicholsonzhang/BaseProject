package com.user.base.wxapi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.user.base.pay.PayApi;
import com.user.base.utils.ToastUtils;


public class WXPayEntryActivity extends AppCompatActivity implements IWXAPIEventHandler {


    private IWXAPI iwxapi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        iwxapi = PayApi.getInstance().getIWXAPI();

        if (iwxapi != null) {
            iwxapi.handleIntent(getIntent(), this);

        }

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if (iwxapi != null) {
            iwxapi.handleIntent(intent, this);
        }
    }

    @Override
    public void onReq(BaseReq baseReq) {

    }

    @Override
    public void onResp(BaseResp resp) {
        if (resp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {
            int code = resp.errCode;
            if (code == 0) {
                //成功，去后端查询具体的结果
                ToastUtils.show(this, "微信支付成功");

            } else if (code == -1) {
                ToastUtils.show(this, "微信支付错误");

            } else if (code == -2) {
                ToastUtils.show(this, "用户取消了");
            }
        }
    }
}
