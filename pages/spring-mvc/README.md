# Spring MVC起步

![font-controller](/img/spring-mvc/font-controller.jpg)

* Font Controller分发调度

* Controller 业务数据抽取

* View template 页面呈现

**MVC**的核心思想是业务数据抽取同业务数据呈现相分离

### MVC

Model-View-Controller

**视图层**为用户提供UI，重点关注数据的呈现

**模型层**业务数据的信息表示，关注支持的信息构成，通常是多个业务实体的组合。

**控制层**调用业务逻辑产生合适的数据(Model)传递给视图层用于呈现

::: tip MVC

**MVC是一种架构模式**
:::

程序分层，分工合作，既相互独立，又协同工作。
:::

**MVC是一种思考方式**
:::

需要将什么信息展示给用户？如何布局？调用哪些业务逻辑？
:::

### Spring MVC静态概念

* DispatcherServlet

![dispatcher-servlet](/img/spring-mvc/dispatcher-servlet.png)

* Controller

* HandlerAdapter：DispatcherServlet内部使用类，就是Controller的一个表现形式

![handler-adapter](/img/spring-mvc/handler-adapter.png)

```
adapter 英 [əˈdæptə]   美 [əˈdæptər]  
n.(电器设备的)转接器，适配器;改编者;改写者
```

扩展阅读：适配器模式 https://blog.csdn.net/zxt0601/article/details/52848004

* HandlerInterceptor

* HandlerMapping 告诉Controller用哪一个Controller1来响应请求

* HandlerExecutionChain

![handler-execution-chain](/img/spring-mvc/handler-execution-chain.png)

内部实现使用的是Java的反射机制

* ModelAndView model的具体表现

* ViewResolver 视图解析器，通知Dispatcher使用哪个视图来呈现；作用：根据我们的配置，找出对应的视图对象

* View 

### Spring MVC动态概念

![handler-flow](/img/spring-mvc/handler-flow.png)

![handler-flow](/img/spring-mvc/handler-flow2.png)

### Maven 搭建Spring MVC项目开发环境

* POM(Project Object Model) 配置依赖管理、生命周期、依赖需要等，dependencies, developers, organization, licenses ...

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd"
  child.project.url.inherit.append.path=.. >
  <modelVersion/>
 
  <parent>
    <groupId/>
    <artifactId/>
    <version/>
    <relativePath/>
  </parent>
 
  <groupId/>
  <artifactId/>
  <version/>
  <packaging/><project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd"
  child.project.url.inherit.append.path="...">
  <modelVersion/>
 
  <parent>
    <groupId/>
    <artifactId/>
    <version/>
    <relativePath/>
  </parent>
 
  <groupId/>
  <artifactId/>
  <version/>
  <packaging/>
  
  ...
</project>
```

https://maven.apache.org/ref/3.6.1/maven-model/maven.html

* Dependency Management 依赖

```xml
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>${junit.version}</version>
    <scope>test</scope>
</dependency>

<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
</dependency>

<dependency>
    <groupId>org.codehaus.jackson</groupId>
    <artifactId>jackson-mapper-asl</artifactId>
    <version>${jackson.version}</version>
</dependency>
```

* Coordinates 坐标

四个属性：groupId, artifactId, version, packaging(默认值jar)，通过这四个属性就可以标识唯一的一个坐标??

![maven-coordinates](/img/spring-mvc/maven-coordinates.jpg)

## 安装Maven

* 下载并解压Maven https://maven.apache.org/download.cgi

* 配置环境变量(M2_HOME, Path)

![system-variables](/img/spring-mvc/system-variables.png)

```
拷贝conf/setting.xml到user/.m2/目录中
```

根据需要修改setting.xml

```xml
  <!-- localRepository
   | The path to the local repository maven will use to store artifacts.
   |
   | Default: ${user.home}/.m2/repository
  <localRepository>/path/to/local/repo</localRepository>
  -->
  <!-- 每次加载依赖包都去UK下载，减少对中心仓库的请求，防止请求量过大出现被拒绝访问现象 -->
  <mirror>
    <id>UK</id>
    <name>UK Central</name>
    <url>http://uk.maven.org/maven2</url>
    <mirrorOf>central</mirrorOf>
  </mirror>
```

* 配置Maven配置文件(本地仓库路径，镜像)

* Eclipse集成Maven(下载eclipse kepler自带m2e)

![eclipse-maven-installations](/img/spring-mvc/eclipse-maven-installations.png)

```
# 创建目录结构
mvn archetype:generate -DgroupId=test-java-maven -DartifactId=spring-mvc-demo1 -DarchetypeArtifactId=maven-archetype-webapp
```

Eclipse导入通过命令创建的项目：

![eclipse-import-maven-project](/img/spring-mvc/eclipse-import-maven-project.png)

修改pom.xml

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>test-java-maven</groupId>
  <artifactId>spring-mvc-demo1</artifactId>
  <packaging>jar</packaging>
  <version>1.0-SNAPSHOT</version>
  <name>spring-mvc-demo1 Maven Webapp</name>
  <url>http://maven.apache.org</url>
  
  <properties>
  	<commons-lang.version>2.6</commons-lang.version>
  	<slf4j.version>1.7.6</slf4j.version>
  	<spring.version>4.1.3.RELEASE</spring.version>
  </properties>
  
  <dependencyManagement>
  	<dependencies>
		<dependency>
  			<groupId>org.springframework</groupId>
  			<artifactId>spring-framework-bom</artifactId>
  				<version>${spring.version}</version>
  			<type>pom</type>
  			<scope>import</scope>
  		</dependency>
  	</dependencies>
  </dependencyManagement>
  
  <dependencies>
  
  	<dependency>
  		<groupId>org.springframework</groupId>
  		<artifactId>spring-webmvc</artifactId>
  		<!-- 上面配置已经制定了版本，所以这里不需要再指定版本 -->
  	</dependency>
  
    <dependency>
    	<groupId>commons-lang</groupId>
    	<artifactId>commons-lang</artifactId>
    	<version>${commons-lang.version}</version>
    </dependency>
    
    <dependency>
    	<groupId>org.slf4j</groupId>
    	<artifactId>slf4j-log4j12</artifactId>
    	<version>${slf4j.version}</version>
    	<exclusions>
    		<exclusion>
    			<artifactId>slf4j-api</artifactId>
    			<groupId>org.slf4j</groupId>
    		</exclusion>
    	</exclusions>
    </dependency>
    
    <!-- 
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>
      <scope>test</scope>
    </dependency>
    -->
    
  </dependencies>
  
  <!-- 加入插件 -->
  <build>
    <finalName>spring-mvc-demo1</finalName>
    
    <plugins>
    	<plugin>
    		<groupId>org.eclipse.jetty</groupId>
    		<artifactId>jetty-maven-plugin</artifactId>
    		<version>9.2.20.v20161216</version>
    	</plugin>
    </plugins>
    
  </build>
  
</project>
```

修改web.xml

```xml
<!-- src/main/webapp/WEB-INF/web.xml -->
<!DOCTYPE web-app PUBLIC
 "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
 "http://java.sun.com/dtd/web-app_2_3.dtd" >

<web-app>
  <display-name>Archetype Created Web Application</display-name>
  
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

创建/WEB-INF/configs/spring/mvc-dispatcher-servlet.xml

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
   	
	<!-- 激活 @Required @Autowired,JSR 250's @PostConstruct, @PreDestroy and @Resource等标注 -->
	<context:annotation-config/>
	
	<!-- DispatcherServlet上下文，只搜索@Controller标注的类 不搜索其他标注的类 -->
	<context:component-scan base-package="com.test.mvcdemo">
		<context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
	</context:component-scan>
	
	<mvc:annotation-driven/>

	<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>
		<property name="prefix" value="/WEB-INF/jsps/"/>
		<property name="suffix" value=".jsp"/>
	</bean>

	
</beans>
```

创建/spring-mvc-demo1/src/main/webapp/WEB-INF/jsps/home.jsp

```jsp
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<h1>Hello Spring MVC!</h1>
</body>
</html>
```

创建/spring-mvc-demo1/src/main/java/com/test/mvcdemo/controller/HelloMVCController.java

```java
package com.test.mvcdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloMVCController {

  @RequestMapping("/mvc")
  // 该方法会响应请求host:8080/hello/mvc
  // 返回到home.jsp
  public String helloMVC() {
    // 返回到home.jsp
    return "home";
  }
  
}
```

运行项目

```
mvn jetty:run
```

如果报错，需要检查和修改响应错误配置。

如果一切顺利，以下页面就能正常访问：

```
http://localhost:8080/hello/mvc
```

### 资源

https://www.imooc.com/learn/47

https://maven.apache.org/