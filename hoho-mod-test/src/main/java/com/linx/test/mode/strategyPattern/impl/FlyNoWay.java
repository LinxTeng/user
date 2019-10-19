package com.linx.test.mode.strategyPattern.impl;

import com.linx.test.mode.strategyPattern.FlyBehavior;

public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("我无法飞行");
    }
}
