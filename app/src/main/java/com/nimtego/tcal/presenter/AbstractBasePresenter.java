package com.nimtego.tcal.presenter;


import com.nimtego.tcal.view.CommonView;

public abstract class AbstractBasePresenter<T extends CommonView> implements Presenter<T> {
    protected T commonView;

    @Override
    public void attachView(T commonView) {
        this.commonView = commonView;
    }

    @Override
    public void detachView() {
        commonView = null;
    }

    public T getView() {
        return commonView;
    }

    protected boolean isViewAttached() {
        return commonView != null;
    }

    @Override
    public void destroy() {

    }

}
