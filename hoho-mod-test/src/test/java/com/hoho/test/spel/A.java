package com.hoho.test.spel;

import java.util.ArrayList;
import java.util.List;

public class A<T extends List> {
  public static void main(String[] args) {
    A<? extends ArrayList> a = new A<ArrayList>();

    Class[] b = new Class[] {};

  }
}
