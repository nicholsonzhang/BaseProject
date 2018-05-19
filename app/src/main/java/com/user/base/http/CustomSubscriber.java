package com.user.base.http;

import io.reactivex.subscribers.ResourceSubscriber;

public class CustomSubscriber<T> extends ResourceSubscriber<T> {

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable t) {

    }

    @Override
    public void onComplete() {

    }
}
