package com.user.base.modules.news;

import android.content.Intent;

import com.user.base.base.BaseFragment;
import com.user.base.R;
import com.user.base.news.QRCodeActivity;

import butterknife.OnClick;

/**
 * Created by user on 2017/8/2.
 */

public class NewsFragment extends BaseFragment {




    @Override
    protected int getContentViewId() {
        return R.layout.f_news;
    }

    @Override
    protected void initViews() {

        
    }

    @OnClick(R.id.ic_qrcode)
    void clickQRcodeScan(){
        Intent intent = new Intent(getActivity(),QRCodeActivity.class);
        startActivity(intent);
    }

}
