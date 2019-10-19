package com.linx.test.spel;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;


public class Domain {
  public List<Boolean> booleanList = new ArrayList<Boolean>();

  public List<String> list;

  public static void main(String[] args) {
    // spel应用
    ExpressionParser parser = new SpelExpressionParser();
    // ?表示如果前面的字符串为null则返回null，而不会报错
    Expression exp = parser.parseExpression("'hello world'?.concat('!')");
    Expression exp2 = parser.parseExpression("new String('hello world').toUpperCase()");
    double exp3 = (double) parser.parseExpression("6.0666").getValue();
    System.out.println(exp.getValue());
    System.out.println(exp2.getValue());
    System.out.println(exp3);

    // map嵌套
    Map<String, Object> mapp = new HashMap<>();
    mapp.put("one", 1);
    // List<String> list = new ArrayList<>();
    // list.add("aa");
    StandardEvaluationContext simpleContext = new StandardEvaluationContext();
    simpleContext.setVariable("name", "myName");

    ExpressionParser paser2 = new SpelExpressionParser();
    String i = paser2.parseExpression("['one']").getValue(mapp, String.class);
    System.out.println(i);

    // list直接变为list对象
    List number = paser2.parseExpression("{1,2,3,4}").getValue(List.class);
    // map
    Map inventorInfo =
        parser.parseExpression("{name:'Nikola',dob:'10-July-1856'}").getValue(Map.class);
    Iterator<Map.Entry<String, Object>> bb = inventorInfo.entrySet().iterator();

    inventorInfo.entrySet();

    while (bb.hasNext()) {
      Entry<String, Object> dd = bb.next();
      System.out.println("myMapEntry=" + dd);
    }

    // boolean
    boolean trueValue = parser.parseExpression("'black' < 'block'").getValue(Boolean.class);
    // math
    int two = parser.parseExpression("1 + 1").getValue(Integer.class); // 2
    // 此处StandardEvaluationContext和TemplateParserContext的区别。前面是默认的
    String randomPhrase = parser.parseExpression("random number is #{T(java.lang.Math).random()}",
        new TemplateParserContext()).getValue(String.class);
    System.out.println(randomPhrase);
    System.out.println(number);
    System.out.println(inventorInfo);
    System.out.println(trueValue);
    System.out.println(two);
    System.out.println(parser.parseExpression("'myName'==#name").getValue(simpleContext));

  }

  public void test() {
    // 读取值
    GregorianCalendar c = new GregorianCalendar();
    c.set(1992, 12, 9);
    Inventor testa = new Inventor("Nikola", c.getTime(), "beijin");
    EvaluationContext context = new StandardEvaluationContext(testa);

    ExpressionParser parser = new SpelExpressionParser();
    Expression exp = parser.parseExpression("name");
    System.out.println(exp.getValue(context));

    Domain simple = new Domain();
    simple.booleanList.add(true);
    StandardEvaluationContext simpContext = new StandardEvaluationContext(simple);
    parser.parseExpression("booleanList[0]").setValue(simpContext, "false");
    System.out.println(simple.booleanList.get(0));

    SpelParserConfiguration config = new SpelParserConfiguration(true, true);
    ExpressionParser parser2 = new SpelExpressionParser(config);
    Expression expression2 = parser2.parseExpression("list[3]");
    Domain domain2 = new Domain();

    System.out.println(expression2.getValue(domain2));

    ApplicationContext ctx =
        new ClassPathXmlApplicationContext("classpath*:/spring/testApplicationContext.xml");
    Inventor inventor = ctx.getBean(Inventor.class);
    Environment env = ctx.getEnvironment();

  }

}
