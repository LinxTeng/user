package com.hoho.test.validation;

public class Customer {
  private Integer age;
  private String name;

  Customer() {

  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Customer [age=" + age + ", name=" + name + "]";
  }

}
