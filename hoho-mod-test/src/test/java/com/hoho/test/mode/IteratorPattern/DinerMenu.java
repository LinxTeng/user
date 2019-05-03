package com.hoho.test.mode.IteratorPattern;

public class DinerMenu {
    static final int Max_ITEMS=6;
    int numberOfItems =0;
    MenuItem[] menuItems;

    public DinerMenu(){
        menuItems=new MenuItem[Max_ITEMS];
     addItems("红烧牛肉面","牛肉汤配上面条",false,20);
    }

    public void addItems(String name,String descriprion,boolean vegetarian,double price){
        MenuItem menuItem=new MenuItem(name,descriprion,vegetarian,price);
        if(numberOfItems>=Max_ITEMS){
            System.err.println("对不起，菜单已经满了，不能再添加了");
        }else{
            menuItems[numberOfItems]=menuItem;
            numberOfItems++;
        }
    }

    public Iterator createIterator(){
        return new DinerMenuIterator(menuItems);
    }
}
