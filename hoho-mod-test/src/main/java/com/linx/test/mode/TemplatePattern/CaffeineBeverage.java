package com.linx.test.mode.TemplatePattern;

public abstract class CaffeineBeverage {
    final void prepareRecipe(){//使用final，不要让子类覆盖
        boilWater();//把水煮沸
        brew();//冲泡
        pourIncup();//倒进杯子
        if(customerWantsCondiments()){
            addCondiments();//使用钩子，是否添加饮料
        }
    }

    boolean customerWantsCondiments(){
        return true;//子类可以覆盖这个方法
    }

    abstract void brew();

    abstract void addCondiments();

    void boilWater(){
        System.out.println("Boiling water");
    }

    void pourIncup(){
        System.out.println("Pouring into cup");
    }
}
