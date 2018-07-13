package com.user.base.modules.mine;

import android.widget.TextView;

import com.user.base.component.ok.OkUtils;
import com.user.base.AppBaseActivity;
import com.user.base.R;

import butterknife.BindView;

public class TestOkActivity extends AppBaseActivity {

    @BindView(R.id.content)
    TextView tvContent;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_test_ok;
    }

    @Override
    protected void initViews() {



    }
}
