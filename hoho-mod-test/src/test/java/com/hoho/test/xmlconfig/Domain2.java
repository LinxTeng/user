package com.hoho.test.xmlconfig;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.support.DefaultConversionService;
import com.hoho.test.validation.ParentType;
import com.hoho.user.JavaTest;

public class Domain2 extends JavaTest {
  @Autowired
  private ConversionService conversionService;

  @Test
  public void testaa() {
    ApplicationContext ctx =
        new ClassPathXmlApplicationContext("classpath*:/spring/testApplicationContext.xml");

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
