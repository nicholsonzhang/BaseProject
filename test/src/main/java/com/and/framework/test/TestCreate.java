package com.and.framework.test;



import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class TestCreate {

    public static void main(String args[]) {



        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) {
                emitter.onNext("hello");
                emitter.onNext("world");
                emitter.onComplete();

            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext=" + s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });


    }
}
