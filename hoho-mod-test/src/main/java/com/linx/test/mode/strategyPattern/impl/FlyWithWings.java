package com.linx.test.mode.strategyPattern.impl;

import com.linx.test.mode.strategyPattern.FlyBehavior;

public class FlyWithWings implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("我可以飞行");
    }
}
