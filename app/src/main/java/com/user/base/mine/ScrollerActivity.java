package com.user.base.mine;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.user.base.BaseActivity;
import com.user.base.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by user on 2017/11/6.
 */

public class ScrollerActivity extends BaseActivity {

    @BindView(R.id.content)
    TextView mContent;

    private NameViewModel mModel;
    @Override
    protected int getContentViewId() {
        return R.layout.activity_scroller;
    }

    @Override
    protected void initViews() {
        mModel = ViewModelProviders.of(this).get(NameViewModel.class);
        Observer<String> nameObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                mContent.setText(s);
            }
        };

        mModel.getCurrentName().observe(this,nameObserver);

    }


    @OnClick(R.id.start)
    void start(){
//        mContent.scrollBy(-10,-20);

        mModel.getCurrentName().setValue("Live Date");
    }

}
