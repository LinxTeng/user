package com.linx.test.xmlconfig;

import java.text.MessageFormat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Domain {
  public static void main(final String[] args) throws Exception {
    ApplicationContext ctx =
        new ClassPathXmlApplicationContext("classpath*:/spring/testApplicationContext.xml");
    ChildrenClass messenger = (ChildrenClass) ctx.getBean("alichildrenClass");
    System.out.println(messenger.getName());
    System.out.println(messenger.getSex());

    CommandMamager commandMamager = (CommandMamager) ctx.getBean(CommandMamager.class);
    commandMamager.process();

    // 测试国际资源的读取
    MessageSource resources =
        new ClassPathXmlApplicationContext("classpath*:/spring/testApplicationContext.xml");
    String message = resources.getMessage("message", new Object[] {"你好"}, "Default", null);
    System.out.println(message);

    // 占位符测试
    String logprefix = String.format("%s,做了一些事情,影响了%s", "你", "她");
    String logprefix2 = MessageFormat.format("{0}，喜欢{1}吗", "你", "她");
    System.out.println(logprefix);
    System.out.println(logprefix2);
  }
}
