package com.user.base;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;

/**
 * Created by user on 2017/8/2.
 */

public class NewsFragment extends BaseFragment {
    @Override
    protected int getContentViewId() {
        return R.layout.f_news;
    }

    @Override
    protected void initViews() {
//        Log.e("yyzhang","NewsFragment initViews");
        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Object> e) throws Exception {

            }
        });


    }
}
