package com.user.base.mine;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;

/**
 * Created by user on 2017/11/9.
 */

public class MyObserver implements LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreateConnect(){
        Log.e("yyzhang","onCreateConnect");

    }
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResumeConnect(){
        Log.e("yyzhang","onResumeConnect");

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStartConnect(){
        Log.e("yyzhang","onStartConnect");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPauseConnect(){
        Log.e("yyzhang","onPauseConnect");

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStopConnect(){
        Log.e("yyzhang","onStopConnect");

    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroyConnect(){
        Log.e("yyzhang","onDestroyConnect");

    }
    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    public void onAnyConnect(){
//        Log.e("yyzhang","onAnyConnect");

    }


}
