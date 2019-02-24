package com.hoho.test.mode.observerPattern.impl;

/**
 * 观察者模式：气象站
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData=new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay=new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasurements(32,56,87);
        weatherData.setMeasurements(12,67,54);

        WeatherData2 weatherData2=new WeatherData2();
        CurrentConditionsDisplay2 currentConditionsDisplay2=new CurrentConditionsDisplay2(weatherData2);
        weatherData2.setMeasurements(45,12,78);
        weatherData2.setMeasurements(48,18,74);
    }
}
