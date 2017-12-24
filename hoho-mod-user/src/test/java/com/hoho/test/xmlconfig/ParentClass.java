package com.hoho.test.xmlconfig;

public class ParentClass {
  private String sex;

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public void say(String... name) {
    for (String n : name) {
      System.out.println(n);
    }

  };

  public static void main(String[] args) {
    new ParentClass().say("你", "我", "它");
  }

}
