package com.linx.test.mode.observerPattern.impl;

import com.linx.test.mode.observerPattern.DisplayElement;
import com.linx.test.mode.observerPattern.Observer;
import com.linx.test.mode.observerPattern.Subject;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private float pressure;
    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData){
        this.weatherData=weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("当前的温度是:"+temperature+",湿度是："+humidity+",气压是："+pressure);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature=temp;
        this.humidity=humidity;
        this.pressure=pressure;
        display();
    }
}
