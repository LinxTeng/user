package com.linx.test.java8;

import java.util.Random;

public class Fruit {
    private String name;//水果名称
    private Integer weight;//水果重量

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Fruit(String name){
        this.name = name;
        this.weight = new Random().nextInt(10);
    }

    public static void main(String[] args) {
        Object[] arr = new Integer[5];
        arr[0] = new String("abd");
        System.out.println(arr);
    }
}
