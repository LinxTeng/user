package com.hoho.test.resource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

public class Domain {
  public static void main(String[] args) throws IOException {
    // 获取资源
    UrlResource url = new UrlResource("http://www.baidu.com");
    System.out.println(url);

    ClassPathResource classpath = new ClassPathResource("spring/testApplicationContext.xml");
    File file = classpath.getFile();
    FileReader input = new FileReader(file);
    // if (input.ready()) {
    // char[] str = new char[1024];
    // input.read(str);
    // System.out.println(str);
    // } ;

    BufferedReader buffReader = new BufferedReader(input);
    if (buffReader.readLine() != null) {
      System.out.println(buffReader.readLine());
    }

    System.out.println(classpath + "是否可读：" + classpath.isReadable());


    FileSystemResource fileResoure = new FileSystemResource("");

    ApplicationContext ctx =
        new ClassPathXmlApplicationContext("classpath:/spring/testApplicationContext.xml");
    Resource resource = ctx.getResource("classpath:/spring/testApplicationContext.xml");
    System.out.println(resource.getDescription());

  }
}
