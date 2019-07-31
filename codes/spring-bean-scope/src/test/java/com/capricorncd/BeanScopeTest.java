package com.capricorncd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class BeanScopeTest extends UnitBaseClass {
  
  public BeanScopeTest() {
    super("classpath*:spring-bean-scope.xml");
  }
  
  @Test
  public void testSay() {
    BeanScope beanScope = (BeanScope)super.getBean("beanScope");
    beanScope.say();
    
    BeanScope beanScope2 = (BeanScope)super.getBean("beanScope");
    beanScope2.say();
  }
}
