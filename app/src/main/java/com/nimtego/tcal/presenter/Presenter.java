package com.nimtego.tcal.presenter;

import android.view.View;

import com.nimtego.tcal.view.CommonView;

public interface Presenter<T extends CommonView> extends View.OnClickListener{
    void attachView(T commonView);
    void detachView();
    void viewIsReady();
    void destroy();
}
