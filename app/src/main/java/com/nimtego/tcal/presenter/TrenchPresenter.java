package com.nimtego.tcal.presenter;

import android.view.View;

import com.nimtego.tcal.R;
import com.nimtego.tcal.model.CalculateData;
import com.nimtego.tcal.view.MainView;

public class TrenchPresenter extends AbstractBasePresenter {


    @Override
    public void viewIsReady() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_button:
                getDataFromActivity();
                break;
            case R.id.clear_button:
                clear();
        }
    }

    private void clear() {
        ((MainView)commonView).setData(CalculateData.dataBuilder().build());
    }

    private void getDataFromActivity() {

    }
}
