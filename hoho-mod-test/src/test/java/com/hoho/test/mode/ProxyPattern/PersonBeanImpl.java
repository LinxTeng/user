package com.hoho.test.mode.ProxyPattern;

public class PersonBeanImpl implements PersonBean{
    String name;
    String gender;

    public PersonBeanImpl(String name,String gender){
        this.name=name;
        this.gender=gender;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }
}
