package com.nimtego.tcal;

import android.provider.ContactsContract;

public class CalculateData {
    private String bill;
    private String[] tip;
    private String[] total;
    private String customTip;
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
        public DataBuilder tip(String[] tip) {
            CalculateData.this.tip = tip;
            return this;
        }
        public DataBuilder total(String[] total) {
            CalculateData.this.total = total;
            return this;
        }
        public DataBuilder customTip(String customTip) {
            CalculateData.this.customTip = customTip;
            return this;
        }
        public DataBuilder tottalForCustom(String tottalForCustom) {
            CalculateData.this.totalForCustom = totalForCustom;
            return this;
        }
        public CalculateData build() {
            CalculateData calculateData = new CalculateData();
            calculateData.bill = CalculateData.this.bill;
            calculateData.tip = CalculateData.this.tip;
            calculateData.total = CalculateData.this.total;
            calculateData.customTip = CalculateData.this.customTip;
            calculateData.totalForCustom = CalculateData.this.totalForCustom;
            return calculateData;
        }

    }
}
