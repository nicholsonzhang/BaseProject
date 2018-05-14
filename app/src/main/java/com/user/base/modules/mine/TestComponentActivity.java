package com.user.base.modules.mine;

import android.widget.CompoundButton;

import com.user.base.AppBaseActivity;
import com.user.base.R;
import com.user.base.widget.CustomSwitch;

import butterknife.BindView;

public class TestComponentActivity extends AppBaseActivity{

    @BindView(R.id.custom_switch)
    CustomSwitch mSwitch;
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
}
