package com.user.base.modules.mine;

import com.user.base.AppBaseActivity;
import com.user.base.R;
import com.user.base.component.ZDownloadManager;

import butterknife.OnClick;

public class TestOkActivity extends AppBaseActivity {


    @Override
    protected int getContentViewId() {
        return R.layout.activity_test_ok;
    }

    @Override
    protected void initViews() {

    }

    @OnClick(R.id.btn_download)
    void startDownload(){
//        ZDownloadManager.getInstance().download(downloadUrl);
    }
}
