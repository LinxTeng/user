package com.hoho.test.mode.strategyPattern.impl;

import com.hoho.test.mode.strategyPattern.FlyBehavior;

public class FlyWithWings implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("我可以飞行");
    }
}
