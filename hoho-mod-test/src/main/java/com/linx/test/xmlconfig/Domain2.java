package com.linx.test.xmlconfig;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.support.DefaultConversionService;
import com.linx.test.validation.ParentType;


public class Domain2 {

  public static void main(String[] args) {
    ApplicationContext ctx =
        new ClassPathXmlApplicationContext("classpath*:/spring/testApplicationContext.xml");
    ConversionService conversionService= ctx.getBean(ConversionService.class);

    ParentType parentType = ctx.getBean(ParentType.class);
    System.out.println(parentType.getBaseType().getName());

    // 测试conversionService,类型转换
    DefaultConversionService cs = new DefaultConversionService();
    List<Integer> input = new ArrayList<Integer>();
    input.add(1);
    List<String> converString =
        (List<String>) conversionService.convert(input, TypeDescriptor.forObject(input),
            TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(String.class)));
    System.out.println(converString);

  }
}
