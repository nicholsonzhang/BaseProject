package com.user.base.widget;

import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.base.library.listener.OnProgressListener;
import com.base.library.utils.DeviceUtils;
import com.user.base.R;
import com.user.base.http.FileDUClient;
import com.user.base.utils.FileUtils;

import java.io.File;

import butterknife.BindView;
import butterknife.OnClick;


public class UpgradeDialog extends BaseDialogFragment {

    @BindView(R.id.upgrade_content)
    TextView upgradeContent;
    @BindView(R.id.progress)
    ProgressBar mProgressBar;
    @BindView(R.id.layout_btn)
    View layoutbtn;
    private String url = "http://e.hiphotos.baidu.com/image/pic/item/aa18972bd40735fa324a79d792510fb30f240821.jpg";
    private String apkUrl = "http://sqdd.myapp.com/myapp/qqteam/tim/down/tim.apk";

    private static final String APK_NAME="tim.apk";
    private OnAppUpgradeListener mListener;

    @Override
    public int getLayoutId() {
        return R.layout.dialog_app_upgrade;
    }

    @Override
    public void initView(View view) {
        String content = "1.修复已知bug" + "\n" + "2.新增某一功能" + "\n" + "3.测试灰度发布";
        upgradeContent.setText(content);
    }

    @Override
    public void initData() {

    }

    public void setUpgradeContent(String content) {
        upgradeContent.setText(content);
    }

    @Override
    protected int getDialogWidth() {
        int width = DeviceUtils.getScreenWidth(getActivity());
        return (int) (width * 0.8);
    }

    @OnClick(R.id.cancel)
    void cancelUpgrade() {
        if (mListener != null) {
            mListener.onCancel();
        }
    }

    @OnClick(R.id.upgrade)
    void upgrade() {
        upgradeContent.setVisibility(View.GONE);
        mProgressBar.setVisibility(View.VISIBLE);

        layoutbtn.setVisibility(View.GONE);

        FileDUClient.getInstance().downloadFile(apkUrl, FileUtils.getApkPath(getActivity(), APK_NAME), new OnProgressListener() {
            @Override
            public void onProgress(long progress, long total, boolean done) {
                int current = (int)((float)progress/total*100);
                mProgressBar.setProgress(current);
            }

            @Override
            public void onComplete(File outFile) {
                if (mListener != null) {
                    mListener.onUpgrade(outFile);
                }



            }
        });
    }


    @Override
    protected boolean cancelable() {
        return false;
    }

    public void setOnAppUpgradeListener(OnAppUpgradeListener onAppUpgradelistener) {
        this.mListener = onAppUpgradelistener;
    }

    public interface OnAppUpgradeListener {

        void onCancel();

        void onUpgrade(File apkFile);

    }


}
