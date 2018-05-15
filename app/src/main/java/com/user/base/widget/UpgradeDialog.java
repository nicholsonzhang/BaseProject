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
import com.user.base.utils.ToastUtils;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class UpgradeDialog extends BaseDialogFragment {


    @BindView(R.id.upgrade_content)
    TextView upgradeContent;
    @BindView(R.id.progress)
    ProgressBar mProgressBar;
    private String url = "http://e.hiphotos.baidu.com/image/pic/item/aa18972bd40735fa324a79d792510fb30f240821.jpg";


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
        this.dismiss();

        if (mListener != null) {
            mListener.onCancel();
        }
    }

    @OnClick(R.id.upgrade)
    void upgrade() {
        if (mListener != null) {
            mListener.onUpgrade();
        }
        upgradeContent.setVisibility(View.GONE);
        mProgressBar.setVisibility(View.VISIBLE);



        FileDUClient.getInstance().downloadFile(url, FileUtils.getApkPath(getActivity(), "x.jpg"), new OnProgressListener() {
            @Override
            public void onProgress(long progress, long total, boolean done) {
                int current = (int)(progress/total*100);
                mProgressBar.setProgress(current);
            }

            @Override
            public void onComplete() {
                ToastUtils.show(getActivity(),"下载完成");
//                dismiss();

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

        void onUpgrade();

    }


}
