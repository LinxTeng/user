package com.hoho.test.mode.strategyPattern;

public abstract class Duck {
   private FlyBehavior flyBehavior;
   private QuackBehavior quackBehavior;

    public Duck(){};

    public abstract void display();

    public void performFly(){
        flyBehavior.fly();
    }

    public void performQuack(){
        quackBehavior.quack();
    }
    public void swim(){
        System.out.println("所有的鸭子都能游泳");
    }

    public void setFlyBehavior(FlyBehavior flyBehavior){
        this.flyBehavior=flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior){
        this.quackBehavior=quackBehavior;
    }

}
