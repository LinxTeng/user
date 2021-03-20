package com.linx.test.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class MyTest {

    public static void main(String[] args) {
        List<Fruit> list = new ArrayList<>();
        //构造函数的方法引用
        Function<String,Fruit> fruit = Fruit::new;
        list.add(fruit.apply("苹果"));
        list.add(fruit.apply("橘子"));
        list.add(fruit.apply("李子"));

        //对水果进行排序
        //1、传统方法
        list.sort(new Comparator<Fruit>() {
            @Override
            public int compare(Fruit o1, Fruit o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });

        //2、java8 方法1
        list.sort((o1,o2)->o1.getWeight().compareTo(o2.getWeight()));

        //3、java8 方法2
        list.sort(Comparator.comparing(o1->o1.getWeight()));

        //4、java8 方法3
        list.sort(Comparator.comparing(Fruit::getWeight));
    }
}
