package com.user.base.modules.mine;

import android.widget.TextView;

import com.user.base.AppBaseActivity;
import com.user.base.R;
import com.user.base.widget.wheelview.OnWheelChangedListener;
import com.user.base.widget.wheelview.OnWheelScrollListener;
import com.user.base.widget.wheelview.WheelView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class TestWheelViewActivity extends AppBaseActivity {


    @BindView(R.id.wheel_view)
    WheelView wheelView;

    @BindView(R.id.select)
    TextView select;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_test_wheel_view;
    }

    @Override
    protected void initViews() {

        List<String> data = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            data.add(i + "");
        }
        wheelView.setViewAdapter(new TestWheelViewAdapter(this, data));
        wheelView.addScrollingListener(onWheelScrollListener);
        wheelView.addChangingListener(onWheelChangedListener);
        wheelView.setVisibleItems(4);

    }

    OnWheelChangedListener onWheelChangedListener = new OnWheelChangedListener() {
        @Override
        public void onChanged(WheelView wheel, int oldValue, int newValue) {
            select.setText(newValue+"");

        }
    };

    OnWheelScrollListener onWheelScrollListener = new OnWheelScrollListener() {
        @Override
        public void onScrollingStarted(WheelView wheel) {

        }

        @Override
        public void onScrollingFinished(WheelView wheel) {


        }
    };
}
