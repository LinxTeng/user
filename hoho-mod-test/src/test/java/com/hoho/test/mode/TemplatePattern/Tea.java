package com.hoho.test.mode.TemplatePattern;

public class Tea extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("Steeping the team");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding lemon");
    }
}
