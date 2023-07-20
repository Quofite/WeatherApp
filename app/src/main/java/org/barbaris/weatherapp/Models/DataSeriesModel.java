package org.barbaris.weatherapp.Models;

public class DataSeriesModel {
    private int date;
    private String weather;
    private TemperatureModel temp2m;
    private int wind10m_max;

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public TemperatureModel getTemp2m() {
        return temp2m;
    }

    public void setTemp2m(TemperatureModel temp2m) {
        this.temp2m = temp2m;
    }

    public int getWind10m_max() {
        return wind10m_max;
    }

    public void setWind10m_max(int wind10m_max) {
        this.wind10m_max = wind10m_max;
    }
}
