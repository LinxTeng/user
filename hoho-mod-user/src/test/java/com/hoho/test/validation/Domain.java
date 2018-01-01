package com.hoho.test.validation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class Domain {
  public static void main(String[] args) throws Exception {
    Customer customer = new Customer();
    customer.setAge(12);
    customer.setName("你好");

    // 转换
    Customer custome1 = Domain.convert(Customer.class, customer);
    System.out.println(custome1);

    // 反射
    Field[] fields = Customer.class.getDeclaredFields();
    Field[] objectFields = customer.getClass().getDeclaredFields();


    for (Field field : fields) {
      System.out.println("FieldName=" + field.getName());
      System.out.println("FieldType=" + field.getType());
    }

    Method[] methods = Customer.class.getDeclaredMethods();
    for (Method method : methods) {
      System.out.println("Method=" + method.getName());
    }

    Constructor<?>[] constructors = Customer.class.getDeclaredConstructors();
    for (Constructor constructor : constructors) {
      if (constructor.getParameterCount() == 2) {
        System.out.println(constructor.getName());
        Customer customertest = (Customer) constructor.newInstance(12, "你好");
        System.out.println("Constructor=" + customertest.getName());
      }
    }


    // 属性值操控
    Customer customer2 = new Customer();
    BeanWrapper wrapper = new BeanWrapperImpl(customer2);
    wrapper.setPropertyValue("age", 12);
    wrapper.setPropertyValue("name", "wrapper设定");
    System.out.println(customer2);
    System.out.println(wrapper.getPropertyValue("name"));

    // 校验
    // Customer customer3 = new Customer();
    // DataBinder binder = new DataBinder(customer3);
    // binder.setValidator(new CustomerValidator());
    // 这里有问题不知道怎么解决PropertyValues的初始化。
    // PropertyValues propertyValue = (PropertyValues) new PropertyValue("name", "");
    // binder.bind(propertyValue);
    // binder.validate();

  }

  public static <T> T convert(Class<T> obj, Object src) throws Exception {
    T t = obj.newInstance();
    Field[] objFileds = obj.getDeclaredFields();
    Field[] srcFileds = src.getClass().getDeclaredFields();
    for (Field objFiled : objFileds) {
      objFiled.setAccessible(true);
      for (Field scrFiled : srcFileds) {
        if (objFiled.getName().equals(scrFiled.getName())
            && objFiled.getGenericType().equals(scrFiled.getGenericType())) {
          scrFiled.setAccessible(true);
          objFiled.set(t, scrFiled.get(src));
        }
      }
    }
    return t;
  };
}
