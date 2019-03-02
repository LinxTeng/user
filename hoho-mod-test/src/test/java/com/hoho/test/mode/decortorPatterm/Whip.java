package com.hoho.test.mode.decortorPatterm;

public class Whip extends CondimentDecorator {
    Beverage beverage;

    public Whip(Beverage beverage){
        this.beverage=beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+",whip";
    }

    @Override
    public double cost() {
        return 0.5+beverage.cost();
    }
}
