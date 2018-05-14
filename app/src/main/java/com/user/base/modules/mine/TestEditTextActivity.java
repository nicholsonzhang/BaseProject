package com.user.base.modules.mine;

import android.view.View;
import android.widget.EditText;

import com.user.base.AppBaseActivity;
import com.user.base.R;

import butterknife.BindView;

public class TestEditTextActivity extends AppBaseActivity {

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
