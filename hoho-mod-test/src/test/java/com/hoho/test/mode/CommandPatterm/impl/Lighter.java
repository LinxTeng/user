package com.hoho.test.mode.CommandPatterm.impl;

public class Lighter {
    String name;

    public Lighter(String name){
        this.name=name;
    }

    public void on(){
        System.out.println(name+"电灯被打开了");
    }

    public void off(){
        System.out.println(name+"电灯被关闭了");
    }
}
