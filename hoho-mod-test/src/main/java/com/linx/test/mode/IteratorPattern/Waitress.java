package com.linx.test.mode.IteratorPattern;

public class Waitress {
    PancakeHouseMenu pancakeHouseMenu;
    DinerMenu dinerMenu;

    public Waitress(PancakeHouseMenu pancakeHouseMenu,DinerMenu dinerMenu){
        this.pancakeHouseMenu=pancakeHouseMenu;
        this.dinerMenu=dinerMenu;
    }

    public void printMenu(){
        Iterator pancakeIterator=pancakeHouseMenu.createIterator();
        Iterator dinerIterator=dinerMenu.createIterator();
        System.out.println("菜单一");
        printMenu(pancakeIterator);
        System.out.println("\n菜单二");
        printMenu(dinerIterator);
    }

    private void printMenu(Iterator iterator){
        while (iterator.hasNext()){
            MenuItem menuItem=(MenuItem)iterator.next();
            System.out.println(menuItem.getName()+",");
            System.out.println(menuItem.getPrice()+",");
            System.out.println(menuItem.getDescription());
        }
    }

    public static void main(String[] args) {
        PancakeHouseMenu pancakeHouseMenu=new PancakeHouseMenu();
        DinerMenu dinerMenu=new DinerMenu();
        Waitress waitress=new Waitress(pancakeHouseMenu,dinerMenu);
        waitress.printMenu();
    }
}
