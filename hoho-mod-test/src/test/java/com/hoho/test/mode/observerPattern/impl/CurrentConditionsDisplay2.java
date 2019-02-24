package com.hoho.test.mode.observerPattern.impl;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay2 implements Observer {
    private float temperature;
    private float humidity;
    private float pressure;
    private Observable observable;

    public CurrentConditionsDisplay2(Observable observable){
        this.observable=observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable obs, Object arg) {
        if(obs instanceof WeatherData2){
            WeatherData2 weatherData2=(WeatherData2)obs;
            this.temperature=weatherData2.getTemperature();
            this.humidity=weatherData2.getHumidity();
            this.pressure=weatherData2.getPressure();
            display();
        }
    }

    public void display() {
        System.out.println("当前的温度是:"+temperature+",湿度是："+humidity+",气压是："+pressure);
    }
}
