package com.hoho.test.mode.ProxyPattern;

import java.lang.reflect.Proxy;

public class MatchMarkingTestDrive {

    public static void main(String[] args) {
        MatchMarkingTestDrive test=new MatchMarkingTestDrive();

        PersonBean personBean=new PersonBeanImpl("小红","18");
        PersonBean personProxy=test.getOwerProxy(personBean);//获取代理

        System.out.println("名字："+personProxy.getName()+",年龄:"+personProxy.getGender());

        personProxy.setName("小白");
        personProxy.setGender("19");

    }

    PersonBean getOwerProxy(PersonBean personBean){
        return (PersonBean) Proxy.newProxyInstance(personBean.getClass().getClassLoader(),personBean.getClass().getInterfaces(),new OwnerInvoctionHandler(personBean));
    }
}
