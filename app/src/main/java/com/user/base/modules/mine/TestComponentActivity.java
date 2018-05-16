package com.user.base.modules.mine;

import android.widget.CompoundButton;

import com.user.base.AppBaseActivity;
import com.user.base.R;
import com.user.base.utils.FileUtils;
import com.user.base.utils.ToastUtils;
import com.user.base.widget.CustomSwitch;
import com.user.base.widget.UpgradeDialog;

import java.io.File;

import butterknife.BindView;
import butterknife.OnClick;

public class TestComponentActivity extends AppBaseActivity {

    @BindView(R.id.custom_switch)
    CustomSwitch mSwitch;
    private UpgradeDialog upgradeDialog;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_test_component;
    }

    @Override
    protected void initViews() {
        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            }
        });

    }


    @OnClick(R.id.show_dialog)
    void showDialog() {
        MyDialogFragment dialogFragment = new MyDialogFragment();
        dialogFragment.show(getSupportFragmentManager(), "my_dialog_fragment");
    }

    @OnClick(R.id.show_upgrade_dialog)
    void clickUpgreade() {
        if (upgradeDialog == null) {
            upgradeDialog = new UpgradeDialog();
            upgradeDialog.setOnAppUpgradeListener(onAppUpgradelistener);
        }
        upgradeDialog.show(getSupportFragmentManager(), "app_upgrade_dialog");

    }

    private UpgradeDialog.OnAppUpgradeListener onAppUpgradelistener = new UpgradeDialog.OnAppUpgradeListener() {
        @Override
        public void onCancel() {
            upgradeDialog.dismiss();

        }

        @Override
        public void onUpgrade(File apkFile) {

            upgradeDialog.dismiss();
            ToastUtils.show(TestComponentActivity.this,"下载完成,开始安装....."+apkFile.getName());
            FileUtils.installApk(TestComponentActivity.this,apkFile);

        }
    };
}
