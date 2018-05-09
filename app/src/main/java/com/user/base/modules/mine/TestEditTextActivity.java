package com.user.base.modules.mine;

import android.view.View;
import android.widget.EditText;

import com.user.base.R;
import com.user.base.base.BaseActivity;

import butterknife.BindView;

public class TestEditTextActivity extends BaseActivity {

    @BindView(R.id.edittext_1)
    EditText editText1;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_test_edit;
    }

    @Override
    protected void initViews() {
        editText1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
            }
        });
    }

}
