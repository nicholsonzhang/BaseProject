package com.user.base.modules.mine;

import android.content.Context;

import com.user.base.widget.wheelview.adapters.AbstractWheelTextAdapter;

import java.util.List;

public class TestWheelViewAdapter extends AbstractWheelTextAdapter {

    private List<String> items;

    protected TestWheelViewAdapter(Context context, List<String> data) {
        super(context);
        items = data;
    }

    @Override
    protected CharSequence getItemText(int index) {
        return items.get(index);
    }

    @Override
    public int getItemsCount() {
        return items.size();
    }
}
