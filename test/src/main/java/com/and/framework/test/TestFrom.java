package com.and.framework.test;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class TestFrom {

    public static void main(String args[]){


        Integer[] items = {1,2,3,4,5,6};
        Observable.fromArray(items)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        System.out.println("onSubscribe");

                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("onNext="+integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError");

                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");

                    }
                });
    }
}
