package com.nimtego.tcal.model;

public class InputData {
    private String projectName;
    private String lineLong;
    private String power;
    private String intersection;
    private String voltage;
    private boolean plate;


    private InputData() {

    }

    public String getProjectName() {
        return projectName;
    }

    public String getLineLong() {
        return lineLong;
    }

    public String getPower() {
        return power;
    }

    public String getIntersection() {
        return intersection;
    }

    public String getVoltage() {
        return voltage;
    }

    public boolean isPlate() {
        return plate;
    }

    public static DataBuilder dataBuilder() {
        return new InputData().new DataBuilder();
    }

    public class DataBuilder {
        private DataBuilder(){}

        public DataBuilder projectName(String projectName) {
            InputData.this.projectName = projectName;
            return this;
        }
        public DataBuilder lineLong(String lineLong) {
            InputData.this.lineLong = lineLong;
            return this;
        }
        public DataBuilder power(String power) {
            InputData.this.power = power;
            return this;
        }
        public DataBuilder intersection(String intersection) {
            InputData.this.intersection = intersection;
            return this;
        }
        public DataBuilder plate(boolean plate) {
            InputData.this.plate = plate;
            return this;
        }
        public DataBuilder voltage(String voltage) {
            InputData.this.voltage = voltage;
            return this;
        }
        public InputData build() {
            InputData inputData = new InputData();
            inputData.projectName = InputData.this.projectName;
            inputData.lineLong = InputData.this.lineLong;
            inputData.power = InputData.this.power;
            inputData.intersection = InputData.this.intersection;
            inputData.plate = InputData.this.plate;
            inputData.voltage = InputData.this.voltage;
            return inputData;
        }

    }
}
