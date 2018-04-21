package com.nimtego.tcal.model;

public class ElectricalData {
    private float power;
    private int voltage;
    private float current;

    private ElectricalData(){}

    public float getPower() {
        return power;
    }

    public void setPower(float power) {
        this.power = power;
    }

    public int getVoltage() {
        return voltage;
    }

    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }

    public float getCurrent() {
        return current;
    }

    public void setCurrent(float current) {
        this.current = current;
    }

    public static Builder electricalDate() {
        return new ElectricalData().new Builder();
    }
    
    public class Builder {
        private Builder(){}

        public Builder projectName(float power) {
            ElectricalData.this.power = power;
            return this;
        }
        public Builder lineLong(int voltage) {
            ElectricalData.this.voltage = voltage;
            return this;
        }
        public Builder power(float current) {
            ElectricalData.this.current = current;
            return this;
        }
        public ElectricalData build() {
            ElectricalData electricalData = new ElectricalData();
            electricalData.voltage = ElectricalData.this.voltage;
            electricalData.power = ElectricalData.this.power;
            electricalData.current = ElectricalData.this.current;
            return electricalData;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Power = ").append(power).append("\n").
                    append("Voltage = ").append(voltage).append("\n").
                    append("Current = ").append(current).append("\n");
            return String.valueOf(sb);
        }
    }
}
