package com.hoho.test.mode.decortorPatterm;

public class Espresso extends Beverage {
    public Espresso(){
        description="Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
