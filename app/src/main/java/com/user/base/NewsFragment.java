package com.user.base;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.user.base.widget.SectionedSpanSizeLookup;

import butterknife.BindView;
import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

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

        GridLayoutManager manager = new GridLayoutManager(getActivity(), 4);

        SectionedSpanSizeLookup lookup = new SectionedSpanSizeLookup(adapter, manager);


        manager.setSpanSizeLookup(lookup);

        mSectionRV.setLayoutManager(manager);
        mSectionRV.setAdapter(adapter);
//
//        Gson gson = new Gson();
//        String jsonArray = "[\"Android\",\"Java\",\"PHP\"]";
//        gson.fromJson(jsonArray,new TypeToken<List<String>>(){}.getType());


        
    }

}
