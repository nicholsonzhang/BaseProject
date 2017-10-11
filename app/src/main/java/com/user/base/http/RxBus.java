package com.user.base.http;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/**
 * Created by user on 2017/10/11.
 */

public class RxBus {
    private static volatile  RxBus mInstance;
    private final Subject<Object> bus;

    private RxBus(){
        bus = PublishSubject.create().toSerialized();

    }
    public static RxBus getDefault(){
        if (mInstance == null){
            synchronized (RxBus.class){
                if (mInstance == null){
                    mInstance = new RxBus();
                }
            }
        }
        return mInstance;
    }

    /**
     * 发送一个新的事件,例如
     * RxBus.getDefault().post(new XXXEvent());
     */
    public void post(Object o){
        bus.onNext(o);
    }

    /**
     * 订阅event事件
     * @param eventType
     */
    public <T> Observable<T> toObservable(Class<T> eventType){
        return bus.ofType(eventType);
    }

}
