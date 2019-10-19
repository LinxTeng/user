package com.linx.test.mode.TemplatePattern;

public class BeverageTestDrive {
    public static void main(String[] args) {
        Tea tea=new Tea();
        Coffee coffee=new Coffee();

        tea.prepareRecipe();
        coffee.prepareRecipe();
    }
}
