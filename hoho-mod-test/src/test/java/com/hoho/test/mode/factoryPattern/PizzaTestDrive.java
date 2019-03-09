package com.hoho.test.mode.factoryPattern;

/**
 * 工厂方法
 * 一个店可以制作不同风味的比萨
 */
public class PizzaTestDrive {
    public static void main(String[] args) {
        PizzaStore nyStore=new NYPizzaStore();
        Pizza pizza=nyStore.orderPizza("cheese");
        System.out.println("订购一份披萨："+pizza.name);

        Pizza pizza2=nyStore.orderPizza("veggie");
        System.out.println("订购一份披萨："+pizza2.name);
    }
}
