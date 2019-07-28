# 拦截器

```
interceptor
英 [ˌɪntəˈseptə(r)] 美 [ˌɪntərˈseptər]
n.截击机，拦截器
```

> [!TIP|style:flat|label:Interceptor]

> 拦截器是指通过统一拦截从浏览器发往服务器的请求来完成功能的增强。(相当于Node.js KOA2的中间件)

> 使用场景：解决请求的共性问题（如：乱码问题、权限验证问题等）

![interceptor-instruction](img/interceptor-instruction.png)

### 拦截器的基本工作原理

SpringMVC可以通过配置过滤器来解决乱码问题

拦截器的工作原理和过滤器非常相似

### 过滤器

src/main/webapp/WEB-INF/web.xml

```xml
  <servlet>
  	<servlet-name>viewSpace</servlet-name>
  	<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
  </servlet>
  
  <servlet-mapping>
  	<servlet-name>viewSpace</servlet-name>
  	<!-- <url-pattern>*.form</url-pattern> -->
  	<url-pattern>/</url-pattern>
  </servlet-mapping>
  
  <!-- 过滤器实现 src/main/webapp/WEB-INF/web.xml -->
  <filter>
  	<filter-name>encoding</filter-name>
  	<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
  	<init-param>
  		<param-name>encoding</param-name>
  		<param-value>utf8</param-value>
  	</init-param>
  </filter>
  
  <filter-mapping>
  	<filter-name>encoding</filter-name>
  	<url-pattern>*</url-pattern>
  </filter-mapping>
```

### 拦截器实现

1. 编写拦截器类实现HandlerInterceptor接口

2. 将拦截器注册进SpringMVC框架中

3. 配置拦截器规则

src/main/webapp/WEB-INF/viewSpace-servlet.xml

```xml
    <!-- 注册拦截器 -->
	<mvc:interceptors>
		<mvc:interceptor>
		    <!-- 配置拦截器规则 -->
			<mvc:mapping path="/**"/>
			<mvc:exclude-mapping path="/static/**"/>
			<bean class="com.zx.interceptor.ZxInterceptor"/>
		</mvc:interceptor>
	</mvc:interceptors>
```

```java
// 编写拦截器类实现HandlerInterceptor接口
package com.zx.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class ZxInterceptor implements HandlerInterceptor {

  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    System.out.println("进入了preHandle");
    return true;
  }

  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
    ModelAndView modelAndView) throws Exception {
    System.out.println("进入了postHandle");
  }

  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
      throws Exception {
    System.out.println("进入了afterCompletion");
  }
  
}
```

结果：

```
进入了preHandle
进入了控制器view()方法...
name = null
pwd = null
进入了postHandle
进入了afterCompletion
```

### 拦截器方法介绍

preHandle 在请求被处理之前进行调用

postHandle 在请求被处理之后进行调用

afterCompletion 在请求结束之后调用