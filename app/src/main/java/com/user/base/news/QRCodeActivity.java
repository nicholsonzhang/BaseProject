package com.user.base.news;

import android.util.Log;

import com.user.base.AppBaseActivity;
import com.user.base.base.BaseActivity;
import com.user.base.R;
import com.yanzhenjie.zbar.camera.CameraPreview;
import com.yanzhenjie.zbar.camera.ScanCallback;

import butterknife.BindView;

/**
 * Created by user on 2017/10/24.
 */

public class QRCodeActivity  extends AppBaseActivity{
    private static final String TAG =   QRCodeActivity.class.getName();
    @BindView(R.id.preview)
    CameraPreview mPreview;
    @Override
    protected int getContentViewId() {
        return R.layout.activity_qrcode;
    }

    @Override
    protected void initViews() {
        mPreview.setScanCallback(mScanCallback);

    }



    ScanCallback mScanCallback = new ScanCallback() {
        @Override
        public void onScanResult(String content) {
            Log.e(TAG,"content"+content);
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        mPreview.start();
    }

    @Override
    protected void onPause() {
        mPreview.stop();
        super.onPause();
    }
}
