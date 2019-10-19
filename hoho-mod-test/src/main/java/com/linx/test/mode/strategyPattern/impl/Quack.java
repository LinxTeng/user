package com.linx.test.mode.strategyPattern.impl;

import com.linx.test.mode.strategyPattern.QuackBehavior;

public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("我能叫");
    }
}
