package com.linx.test.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.number.NumberFormatAnnotationFormatterFactory;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;

@Configuration
public class MyBeanfactory {

  @Bean
  public MyBean myBean() {
    return new MyBean();
  }

  public FormattingConversionService conversionService() {
    DefaultFormattingConversionService conversionService =
        new DefaultFormattingConversionService(false);
    conversionService.addFormatterForFieldAnnotation(new NumberFormatAnnotationFormatterFactory());


    DateFormatterRegistrar registrar = new DateFormatterRegistrar();
    registrar.setFormatter(new DateFormatter("yyyyMMdd"));
    registrar.registerFormatters(conversionService);
    return conversionService();
  }
}
