# Spring MVC实操

### 从配置文件开始

src/main/webapp/WEB-INF/web.xml

```xml
<!-- 
	Maven自动生成使用的2.3版本的标准，该标准默认会将jsp页面的el表达式语言关闭
-->
<!--
<!DOCTYPE web-app PUBLIC
 "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
 "http://java.sun.com/dtd/web-app_2_3.dtd" >
-->
<?xml verrsion="1.0" encoding="UTF-8"?>
<web-app version="2.4" xmlns="http://java.sun.com/xml/ns/j2ee"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee
		http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd">
		
  <display-name>Spring MVC DEMO</display-name>
  
  <!-- Spring应用上下文，理解层次化的ApplicationContext -->
  <context-param>
  	<param-name>contextConfigLocation</param-name>
  	<param-value>/WEB-INF/configs/spring/applicationContext*.xml</param-value>
  </context-param>
  
  <listener>
  	<listener-class>
  		org.springframework.web.context.ContextLoaderListener
  	</listener-class>
  </listener>
  
  <!-- DispatcherServlet, Spring MVC的核心 -->
  <servlet>
  	<servlet-name>mvc-dispatcher</servlet-name>
  	<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
  	<!-- DispatcherServlet对应的上下文配置，默认为/WEB-INF/$servlet-name$-servlet.xml -->
  	<!-- 以下配置，改变默认参数 -->
  	<init-param>
  		<param-name>contextConfigLocation</param-name>
  		<param-value>/WEB-INF/configs/spring/mvc-dispatcher-servlet.xml</param-value>
  	</init-param>
  	<load-on-startup>1</load-on-startup>
  </servlet>
  
  <servlet-mapping>
  	<servlet-name>mvc-dispatcher</servlet-name>
  	<!-- mvc-dispatcher拦截所有的请求  -->
  	<url-pattern>/</url-pattern>
  </servlet-mapping>
  
</web-app>
```

**Spring MVC的上下文层级**

![spring-context](img/spring-context.png)

src/main/webapp/WEB-INF/configs/spring/mvc-dispatcher-servlet.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
   xmlns:context="http://www.springframework.org/schema/context"
   xmlns:mvc="http://www.springframework.org/schema/mvc"
   xsi:schemaLocation="
   	http://www.springframework.org/schema/beans 
   	http://www.springframework.org/schema/beans/spring-beans.xsd
   	http://www.springframework.org/schema/context
   	http://www.springframework.org/schema/context/spring-context.xsd
   	http://www.springframework.org/schema/mvc
   	http://www.springframework.org/schema/mvc/spring-mvc.xsd">
   	
   	<!-- 本配置文件是工名为mvc-dispatcher的DispatcherServlet使用，提供其相关的Spring MVC配置 -->
   	
	<!-- 启用Spring基于annotation的DI，使用户可以在Spring MVC中使用Spring的强大功能。
		激活 @Required @Autowired,JSR 250's @PostConstruct, @PreDestroy and @Resource等标注 
	-->
	<context:annotation-config/>
	
	<!-- DispatcherServlet上下文，只管理@Controller类型的bean，忽略其他类型的bean，如@Service -->
	<context:component-scan base-package="com.test.mvcdemo">
		<context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
	</context:component-scan>
	
	<!-- HandlerMapping，无需配置，Spring MVC可以默认启动。即默认会启动：
		DefaultAnnotationHandlerMapping annotation-driven HandlerMapping
	-->

	<!-- 扩充了注解驱动，可以将请求参数绑定到控制器参数
		Url中的查询参数，可以直接映射到Controller中某个输入方法的参数
	 -->
	<mvc:annotation-driven/>
	
	<!-- 静态资源处理，css、js、images -->
	<mvc:resources mapping="/resources/**" location="/resources/"/>
	
	<!-- 配置ViewResolver
		可以用多个ViewResolver
		使用order属性排序
		InternalResourceViewResolve放在最后
	-->
	<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>
		<property name="prefix" value="/WEB-INF/jsps/"/>
		<property name="suffix" value=".jsp"/>
	</bean>
	
</beans>
```

### 3中不同形式编写Controller类

```java
package com.test.mvcdemo.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.mvcdemo.model.Course;
import com.test.mvcdemo.service.CourseService;

@Controller
@RequestMapping("/courses")
// /courses/*
public class CourseController {
  
  private static Logger log = LoggerFactory.getLogger(CourseController.class);
  
  private CourseService courseService;
  
  @Autowired
  public void setCourseServiceImpl(CourseService courseService) {
    this.courseService = courseService;
  }
  
  // 本方法仅处理 /course/view?courseId=123
  @RequestMapping(value="/view", method=RequestMethod.GET)
  public String viewCourse(@RequestParam("courseId") Integer courseId, Model model) {
    
    log.debug("In viewCourse, courseId = {}", courseId);
    
    Course course = courseService.getCourseById(courseId);
    model.addAttribute(course);
    // 返回jsp的文件名
    return "course-overview";
  }
  
  // /courses/view2/{courseId}
  @RequestMapping(value="/view2/{courseId}", method=RequestMethod.GET)
  public String viewCourse2(@PathVariable("courseId") Integer courseId, Map<String, Object> model) {
    log.debug("In viewCourse2, courseId = {}", courseId);
    Course course = courseService.getCourseById(courseId);
    model.put("course", course);
    return "course-overview";
  }
  
  // /course/view?courseId=333
  @RequestMapping("view3")
  public String viewCourse3(HttpServletRequest request) {
    Integer courseId = Integer.valueOf(request.getParameter("courseId"));
    Course course = courseService.getCourseById(courseId);
    request.setAttribute("course", course);
    return "course-overview";
  }
}
```

> [!TIP|style:flat|label:总结]

> 通过@Controller声明一个Controller

> 通过@RequestMapping 映射URL和方法，通常出现在我们的类级别和方法级别，二者组合完成了对URL映射请求的拦截

> 通过URL template(@RequestParam and @PathVariable)将URL中的参数，绑定到Controller中method的入参

> 同时也可以通过HTTPServletRequest and/or HttpSession等对象来获取我们想要的结果

### Binding 数据绑定

将请求中的字段按照名字匹配的原则填入模型对象。

```java
// CourseController.java

  @RequestMapping(value="/admin", method=RequestMethod.GET, params="add")
  public String createCourse() {
    return "admin/edit";
  }
  
  // 接收处理表单数据
  @RequestMapping(value="/save", method=RequestMethod.POST)
//  public String doSave(Course course) {
  public String doSave(@ModelAttribute Course course) {
    
    log.debug("Info of Course");
    log.debug(ReflectionToStringBuilder.toString(course));
    
    System.out.println(course.toString());
    
    // 在此进行业务操作，比如数据库持久化
    course.setCourseId(555);
    return "redirect:view2/" + course.getCourseId();
  }
```

> [!TIP|style:flat|label:总结]

> 在Controller参数上，使用@ModelAttribute实现模型与页面数据的绑定，及如果在MVC中使用重定向或转发redirect/forward

### 源码

codes/spring-mvc-demo1