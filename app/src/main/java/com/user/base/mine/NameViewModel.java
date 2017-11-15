package com.user.base.mine;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

/**
 * Created by user on 2017/11/13.
 */

public class NameViewModel extends ViewModel {

    private MutableLiveData<String> mCurrentName;

    public MutableLiveData<String> getCurrentName(){
        if (mCurrentName == null){
            mCurrentName = new MutableLiveData<>();
        }
        return mCurrentName;
    }
}
