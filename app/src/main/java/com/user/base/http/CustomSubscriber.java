package com.user.base.http;

import io.reactivex.subscribers.ResourceSubscriber;

public abstract class CustomSubscriber<T> extends ResourceSubscriber<T> {



    @Override
    public void onError(Throwable t) {

    }

    @Override
    public void onComplete() {

    }
}
