package com.nimtego.tcal.view;

import com.nimtego.tcal.model.CalculateData;

public interface MainView extends CommonView {
    CalculateData getData();
    void setData(CalculateData calculateData);
}
