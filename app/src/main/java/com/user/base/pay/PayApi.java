package com.user.base.pay;

import android.app.Activity;

import com.alipay.sdk.app.PayTask;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PayApi {

    /**
     *payInfo是从服务端返回的，经过加签等操作的，以&连接的字符串
     */
    public static void payAli(final Activity activity, final String payInfo, final OnPayListener payListener) {


        Observable.create(new ObservableOnSubscribe<Map<String, String>>() {

            @Override
            public void subscribe(ObservableEmitter<Map<String, String>> emitter) throws Exception {
                //这个在非ui线程执行
                PayTask payTask = new PayTask(activity);
                Map<String, String> result = payTask.payV2(payInfo, true);
                emitter.onNext(result);
                emitter.onComplete();
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Map<String, String>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Map<String, String> resultMap) {
                        String resultStatus = resultMap.get("resultStatus");
                        String memo = resultMap.get("memo");
                        String resultInfo = resultMap.get("result");
                        if (resultStatus.equals("9000")) {
                            if (payListener != null) {
                                payListener.paySuccess(resultInfo);
                            }
                        } else {
                            if (payListener != null) {
                                payListener.payFail(memo);
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (payListener != null) {
                            payListener.payFail(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }





    public interface OnPayListener {
        void paySuccess(String success);

        void payFail(String error);
    }

}
