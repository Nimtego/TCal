package com.nimtego.tcal;

import android.provider.ContactsContract;

public class CalculateData {
    private String bill;
    private String[] tip;
    private String[] total;
    private String custom;
    private String totalForCustom;


    private CalculateData() {

    }
    public static DataBuilder dataBuilder() {
        return new CalculateData().new DataBuilder();
    }

    public class DataBuilder {
        private DataBuilder(){}

        public DataBuilder bill(String bill) {
            CalculateData.this.bill = bill;
            return this;
        }

    }
}
