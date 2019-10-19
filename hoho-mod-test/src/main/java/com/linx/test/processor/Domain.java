package com.linx.test.processor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Domain {
  public static void main(final String[] args) throws Exception {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    ctx.scan("com.hoho.test.processor");
    ctx.refresh();
    MyBesiness myBesiness = ctx.getBean(MyBesiness.class);
    myBesiness.doBesiness();
    myBesiness.doBesiness();
    myBesiness.doBesiness();
  }
}
