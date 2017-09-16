package com.user.base;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.user.base.widget.SectionedSpanSizeLookup;

import butterknife.BindView;

/**
 * Created by user on 2017/8/2.
 */

public class NewsFragment extends BaseFragment {


    @BindView(R.id.section_rv)
    RecyclerView mSectionRV;


    @Override
    protected int getContentViewId() {
        return R.layout.f_news;
    }

    @Override
    protected void initViews() {

        NewsSectionAdapter adapter = new NewsSectionAdapter(getActivity());

        GridLayoutManager manager = new GridLayoutManager(getActivity(),4);

        SectionedSpanSizeLookup lookup = new SectionedSpanSizeLookup(adapter, manager);


        manager.setSpanSizeLookup(lookup);

        mSectionRV.setLayoutManager(manager);
        mSectionRV.setAdapter(adapter);


    }

}
