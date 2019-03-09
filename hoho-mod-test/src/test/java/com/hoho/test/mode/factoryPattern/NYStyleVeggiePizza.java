package com.hoho.test.mode.factoryPattern;

public class NYStyleVeggiePizza extends Pizza {
    public NYStyleVeggiePizza(){
        name="芝加哥风味的比萨";
        dough="厚饼";
        sauce="小番茄酱";
        toppings.add("意大利白干酪");
    }

    void cut(){
        System.out.println("切成正方形");
    }
}
