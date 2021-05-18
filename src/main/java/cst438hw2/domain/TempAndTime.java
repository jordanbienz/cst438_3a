package cst438hw2.domain;

public class TempAndTime {
    public double temp;
    public String time;
    public int timezone;

    public TempAndTime(double temp, String convertedTime, int timezone){
        this.temp = temp;
        this.time = convertedTime;
        this.timezone = timezone;
    }
}
