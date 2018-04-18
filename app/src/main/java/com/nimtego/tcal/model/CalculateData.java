package com.nimtego.tcal.model;

public class CalculateData {
    private String projectName;
    private String lineLong;
    private String power;
    private String intersection;
    private String voltage;
    private boolean plate;


    private CalculateData() {

    }
    public static DataBuilder dataBuilder() {
        return new CalculateData().new DataBuilder();
    }

    public class DataBuilder {
        private DataBuilder(){}

        public DataBuilder projectName(String projectName) {
            CalculateData.this.projectName = projectName;
            return this;
        }
        public DataBuilder lineLong(String lineLong) {
            CalculateData.this.lineLong = lineLong;
            return this;
        }
        public DataBuilder power(String power) {
            CalculateData.this.power = power;
            return this;
        }
        public DataBuilder intersection(String intersection) {
            CalculateData.this.intersection = intersection;
            return this;
        }
        public DataBuilder plate(boolean plate) {
            CalculateData.this.plate = plate;
            return this;
        }
        public DataBuilder voltage(String voltage) {
            CalculateData.this.voltage = voltage;
            return this;
        }
        public CalculateData build() {
            CalculateData calculateData = new CalculateData();
            calculateData.projectName = CalculateData.this.projectName;
            calculateData.lineLong = CalculateData.this.lineLong;
            calculateData.power = CalculateData.this.power;
            calculateData.intersection = CalculateData.this.intersection;
            calculateData.plate = CalculateData.this.plate;
            calculateData.voltage = CalculateData.this.voltage;
            return calculateData;
        }

    }
}
