package com.hoho.test.mode.strategyPattern.impl;

import com.hoho.test.mode.strategyPattern.QuackBehavior;

public class Squeck implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("我能呱呱叫");
    }
}
