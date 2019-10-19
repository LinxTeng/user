package com.linx.test.mode.factoryPattern;

import java.util.ArrayList;

public abstract class Pizza {
    String name;//名称
    String dough;//面团
    String sauce;//酱料
    ArrayList toppings=new ArrayList();//佐料

    void prepare(){
        System.out.println("准备 "+name);
        System.out.println("切 dough");
        System.out.println("添加... sauce");
        System.out.println("添加... toppings");
        for (int i=0;i<toppings.size();i++){
            System.out.println(" "+toppings.get(i));
        }
    }
    void bake(){
        System.out.println("烘烤25分钟");
    }
    void cut(){
        System.out.println("切成片");
    }
    void box(){
        System.out.println("装盘");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDough() {
        return dough;
    }


    public String getSauce() {
        return sauce;
    }


    public ArrayList getToppings() {
        return toppings;
    }

}
