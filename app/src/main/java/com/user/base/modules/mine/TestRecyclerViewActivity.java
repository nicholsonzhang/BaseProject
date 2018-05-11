package com.user.base.modules.mine;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.user.base.R;
import com.user.base.base.BaseActivity;

import butterknife.BindView;

/**
 * 还需对装饰者完善
 */
public class TestRecyclerViewActivity extends BaseActivity {

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private TestRecyclerViewAdapter mAdapter;
    private RecyclerViewAdapterWrapper wrapper;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_test_recycler_view;
    }

    @Override
    protected void initViews() {
        mAdapter = new TestRecyclerViewAdapter(this);
        initHeaderView();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        mRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        mRecyclerView.setAdapter(mAdapter);

    }

    private void initHeaderView(){
        wrapper = new RecyclerViewAdapterWrapper(mAdapter);
        TextView textView = new TextView(this);
        textView.setText("这是heade view");
        wrapper.addHeadView(textView);

        TextView t2 = new TextView(this);
        t2.setText("这是第二个headerview");
        wrapper.addHeadView(t2);
    }

}
