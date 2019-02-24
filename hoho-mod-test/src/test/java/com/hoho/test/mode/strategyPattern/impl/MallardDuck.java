package com.hoho.test.mode.strategyPattern.impl;

import com.hoho.test.aop.Main;
import com.hoho.test.mode.strategyPattern.Duck;

public class MallardDuck extends Duck {
    MallardDuck(){
        setFlyBehavior(new FlyWithWings());
        setQuackBehavior(new Squeck());
    }

    @Override
    public void display() {
        System.out.println("我是一只真实的鸭子");
    }

    public static void main(String[] args) {
        MallardDuck mallardDuck=new MallardDuck();
        mallardDuck.setFlyBehavior(new FlyNoWay());
        mallardDuck.performFly();
        mallardDuck.performQuack();
    }
}
