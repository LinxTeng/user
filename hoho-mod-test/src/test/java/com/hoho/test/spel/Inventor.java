package com.hoho.test.spel;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Inventor {
  private String name;
  private Date birth;
  private String area;

  @Autowired
  Inventor(@Value("#{ T(java.lang.Math).random() * 100.0 }") String name,
      @Value("#{new java.util.Date()}") Date birth, @Value("${jdbc.username}") String area) {
    this.name = name;
    this.birth = birth;
    this.area = area;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getBirth() {
    return birth;
  }

  public void setBirth(Date birth) {
    this.birth = birth;
  }

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  @Override
  public String toString() {
    return "Inventor [name=" + name + ", birth=" + birth + ", area=" + area + "]";
  }

}
