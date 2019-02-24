package com.hoho.test.mode.strategyPattern.impl;

import com.hoho.test.mode.strategyPattern.FlyBehavior;

public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("我无法飞行");
    }
}
