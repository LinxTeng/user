package com.linx.test.mode.decortorPatterm;

public class StarbuzzCoffee {
    public static void main(String[] args) {
        Beverage beverage=new Espresso();

        beverage=new Mocha(beverage);
        beverage=new Whip(beverage);

        System.out.println(beverage.getDescription()+"价格:"+beverage.cost());
    }
}
