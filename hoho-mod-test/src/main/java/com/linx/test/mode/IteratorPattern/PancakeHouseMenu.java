package com.linx.test.mode.IteratorPattern;

import java.util.ArrayList;

public class PancakeHouseMenu {
    ArrayList menuItems;

    public PancakeHouseMenu(){
        menuItems=new ArrayList();
        addItem("西红柿蛋汤","西红柿和鸡蛋烹煮的汤料",true,3);
    }

    public void addItem(String name,String description,boolean vegetarin,double price){
        MenuItem menuItem=new MenuItem(name,description,vegetarin,price);
        menuItems.add(menuItem);
    }

    public Iterator createIterator(){
        return new PancakeHouseIterator(menuItems);
    }

}
