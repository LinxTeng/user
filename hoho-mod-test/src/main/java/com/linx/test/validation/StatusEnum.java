package com.linx.test.validation;

public enum StatusEnum {
  Y("有效"), N("无效");
  String name;

  StatusEnum(String name) {
    this.name = name;
  }
}
