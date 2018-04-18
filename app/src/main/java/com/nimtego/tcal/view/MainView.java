package com.nimtego.tcal.view;

import com.nimtego.tcal.model.InputData;

public interface MainView extends CommonView {
    InputData getData();
    void setData(InputData calculateData);
}
