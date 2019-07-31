package com.capricorncd;

import org.junit.After;
import org.junit.Before;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

public class UnitBaseClass {
  
  private ClassPathXmlApplicationContext context;
  
  private String xmlPath;
  
  public UnitBaseClass() {}
  
  public UnitBaseClass(String springXmlPath) {
    this.xmlPath = springXmlPath;
  }

  @Before
  public void before() {
    if (StringUtils.isEmpty(xmlPath)) {
      xmlPath = "classpath*:spring-*.xml";
    }
    try {
      context = new ClassPathXmlApplicationContext(xmlPath.split("[,\\s]+"));
      context.start();
    } catch(BeansException e) {
      e.printStackTrace();
    }
  }
  
  @After
  public void after() {
    context.destroy();
  }
  
  public BeanScope getBean(String string) {
    return (BeanScope)context.getBean(string);
  }

}
