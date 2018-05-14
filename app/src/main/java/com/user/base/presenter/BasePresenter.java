package com.user.base.presenter;


public class BasePresenter<V extends BaseView> {


    private V mvpView;


    public void attachView(V mvpView) {
        this.mvpView = mvpView;
    }

    public void detachView() {
        this.mvpView = null;
    }

    public boolean isViewAttached(){
        return this.mvpView != null;
    }

    public V getView(){
        return mvpView;
    }

}