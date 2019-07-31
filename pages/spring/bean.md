# Bean装配

* Bean配置项

* Bean的作用域

* Bean的生命周期

* Bean的自动装配

* Resources & ResourceLoader

### Bean配置项

|常用配置项|说明|
|:--|:--|
|id |bean的唯一标识|
|class |具体要实例化的哪一个类|
|scope |作用域
|constructor arguments |构造器参数|
|properties |属性|
|autowiring mode |自动装配模式|
|lazy-initialization mode |懒加载|
|initialization/destruction method |初始化和销毁的方法|

### Bean的作用域

|作用域|说明|
|:--|:--|
|singleton|单列，指一个Bean容器中只存在一份|
|prototype|每次请求（每次使用）创建新的实例，destroy方式不生效|
|request|每次http请求创建一个实例，且仅在当前request内有效|
|session|同时，每次http请求创建，当前session内有效|
|global session|基于portlet的web中有效（portlet定义了global session），如果是在web中，同session|

```java
package com.test.bean;

public class BeanScope {
	public void say() {
		System.out.println("BeanScope say: " + this.hashCode());
	}
}
```

```java
package com.test.bean;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeTest {

	private static ApplicationContext context;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("bean-scope.xml");
	}

	@Test
	public void testSay() {
		BeanScope beanScope = (BeanScope) context.getBean("beanScope");
		beanScope.say();
		
		BeanScope beanScope2 = (BeanScope) context.getBean("beanScope");
		beanScope2.say();
	}

}
```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
	  http://www.springframework.org/schema/beans/spring-beans.xsd">
    <bean id="beanScope" class="com.test.bean.BeanScope" scope="singleton"></bean>
</beans>
```

singleton结果：

```
BeanScope say: 951880373
BeanScope say: 951880373
```

prototype结果：

```
BeanScope say: 1045941616
BeanScope say: 161960012
```

实例代码见：codes/spring-bean-scope

### Bean的生命周期

定义、初始化、使用、销毁

> [!TIP|style:flat|label:初始化的两种方式]

> 实现org.springframework.beans.factory.InitializingBean接口，覆盖afterPropertiesSet方法

> 配置init-method

覆盖afterPropertiesSet方法

```java
public class ExampleInitializingBean implements InitializingBean {
    @Override
    public void afterPropertiesSet() throw Exception {
        // do something
    }
}
```

配置init-method

```xml
<bean id="exampleBean" class="examples.ExampleBean" init-method="init"/>
```

```java
public class ExampleBean {
    public void init() {
        // do some initialization work
    }
}
```

> [!TIP|style:flat|label:销毁的两种方式]

> 实现org.springframework.beans.factory.DisposableBean接口，覆盖destroy方法

> 配置destroy-method

覆盖destroy方法

```java
public class ExampleDisposableBean implements DisposableBean {
    @Override
    public void destroy() throw Exception {
        // do something
    }
}
```

配置destroy-method

```xml
<bean id="exampleBean" class="examples.ExampleBean" destroy-method="cleanup"/>
```

```java
public class ExampleBean {
    public void cleanup() {
        // do some destruction work (like releasing pooled connections)
    }
}
```

**配置全局默认初始化、销毁方法**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
	  http://www.springframework.org/schema/beans/spring-beans.xsd"
	  default-init-method="init" default-destroy-method="destroy">
</beans>
```

```java
package com.test.bean;

public class BeanLifeCycle {
	public BeanLifeCycle() {
		// do
	}
	public void init() {
		System.out.println("BeanLifeCycle init");
	}
	
	public void destroy() {
		System.out.println("BeanLifeCycle destroy");
	}
}
```

```java
package com.test.bean;

import org.junit.After;
//import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@RunWith(BlockJUnit4ClassRunner.class)
public class BeanLifeCycleTest {

	private static ClassPathXmlApplicationContext context;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			context = new ClassPathXmlApplicationContext("bean-lifecycle.xml");
			context.start();
		} catch(BeansException e) {
			e.printStackTrace();
		}
	}
	
//	@Before
//	public void before() throws Exception {
//		try {
//			context = new ClassPathXmlApplicationContext("bean-lifecycle.xml");
//			context.start();
//		} catch(BeansException e) {
//			e.printStackTrace();
//		}
//	}
	
	@After
	public void after() throws Exception {
		context.destroy();
	}

	@Test
	public void test() {
		context.getBean("beanLifeCycle");
	}

}
```

运行结果：

```
七月 15, 2019 3:14:15 下午 org.springframework.context.support.AbstractApplicationContext prepareRefresh
信息: Refreshing org.springframework.context.support.ClassPathXmlApplicationContext@1c2c22f3: startup date [Mon Jul 15 15:14:15 JST 2019]; root of context hierarchy
七月 15, 2019 3:14:15 下午 org.springframework.beans.factory.xml.XmlBeanDefinitionReader loadBeanDefinitions
信息: Loading XML bean definitions from class path resource [bean-lifecycle.xml]
BeanLifeCycle init
七月 15, 2019 3:14:15 下午 org.springframework.context.support.AbstractApplicationContext doClose
信息: Closing org.springframework.context.support.ClassPathXmlApplicationContext@1c2c22f3: startup date [Mon Jul 15 15:14:15 JST 2019]; root of context hierarchy
BeanLifeCycle destroy
```

覆盖destroy方法 && 覆盖afterPropertiesSet方法

```xml
<bean id="beanLifeCycleOverride" class="com.test.bean.BeanLifeCycleOverride"></bean>
```

```java
package com.test.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BeanLifeCycleOverride implements InitializingBean, DisposableBean {
	
	@Override
	public void afterPropertiesSet() {
		System.out.println("BeanLifeCycleOverride: afterPropertiesSet");
	}
	
	@Override
	public void destroy() {
		System.out.println("BeanLifeCycleOverride: destroy");
	}
}
```

结果：

```
信息: Refreshing org.springframework.context.support.ClassPathXmlApplicationContext@1c2c22f3: startup date [Mon Jul 15 15:46:16 JST 2019]; root of context hierarchy
七月 15, 2019 3:46:16 下午 org.springframework.beans.factory.xml.XmlBeanDefinitionReader loadBeanDefinitions
信息: Loading XML bean definitions from class path resource [bean-lifecycle-override.xml]
BeanLifeCycleOverride: afterPropertiesSet
七月 15, 2019 3:46:16 下午 org.springframework.context.support.AbstractApplicationContext doClose
信息: Closing org.springframework.context.support.ClassPathXmlApplicationContext@1c2c22f3: startup date [Mon Jul 15 15:46:16 JST 2019]; root of context hierarchy
BeanLifeCycleOverride: destroy
```

同时使用全局和单个bean的init、destroy属性

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
	  http://www.springframework.org/schema/beans/spring-beans.xsd"
	  default-init-method="defaultInit" default-destroy-method="defaultDestroy">
    <bean id="beanLifeCycle" class="com.test.bean.BeanLifeCycleOverride" init-method="start" destroy-method="stop"></bean>
</beans>
```

```java
package com.test.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BeanLifeCycleOverride implements InitializingBean, DisposableBean {
	
	public void defaultInit() {
		System.out.println("Bean defaultInit");
	}
	
	public void defaultDestroy() {
		System.out.println("Bean defaultDestroy");
	}
	
	@Override
	public void afterPropertiesSet() {
		System.out.println("BeanLifeCycleOverride: afterPropertiesSet");
	}
	
	@Override
	public void destroy() {
		System.out.println("BeanLifeCycleOverride: destroy");
	}
	
	public void start() {
		System.out.println("BeanLifeCycle init");
	}
	
	public void stop() {
		System.out.println("BeanLifeCycle destroy");
	}
}
```

```java
package com.test.bean;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@RunWith(BlockJUnit4ClassRunner.class)
public class BeanLifeCycleTest {

	private static ClassPathXmlApplicationContext context;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			context = new ClassPathXmlApplicationContext("bean-lifecycle-multiple.xml");
			context.start();
		} catch(BeansException e) {
			e.printStackTrace();
		}
	}
	
	@After
	public void after() throws Exception {
		context.destroy();
	}

	@Test
	public void test() {
		context.getBean("beanLifeCycle");
	}

}
```

运行结果：

```
七月 15, 2019 4:00:04 下午 org.springframework.context.support.AbstractApplicationContext prepareRefresh
信息: Refreshing org.springframework.context.support.ClassPathXmlApplicationContext@1c2c22f3: startup date [Mon Jul 15 16:00:04 JST 2019]; root of context hierarchy
七月 15, 2019 4:00:04 下午 org.springframework.beans.factory.xml.XmlBeanDefinitionReader loadBeanDefinitions
信息: Loading XML bean definitions from class path resource [bean-lifecycle-multiple.xml]
BeanLifeCycleOverride: afterPropertiesSet
BeanLifeCycle init
七月 15, 2019 4:00:04 下午 org.springframework.context.support.AbstractApplicationContext doClose
信息: Closing org.springframework.context.support.ClassPathXmlApplicationContext@1c2c22f3: startup date [Mon Jul 15 16:00:04 JST 2019]; root of context hierarchy
BeanLifeCycleOverride: destroy
BeanLifeCycle destroy
```
> [!WARNING|style:flat|label:注意]

> 默认的default-init(destroy)-method配置未生效。

### Aware接口

* Spring中提供了一些以Aware结尾的接口，实现了Aware接口的bean在被初始化之后，可以获取相应资源

* 通过Aware接口，可以对Spring相应资源进行操作（一定要慎重）

* 为对Spring进行简单的扩展提供了方便的入口

|Name|Injected Dependency|
|:--|:--|
|ApplicationContextAware|Declaring ApplicationContext|
|ApplicationEventPubilsherAware||
|BeanClassLoaderAware||
|BeanFactoryAware||
|BeanNameAware|Name of the declaring bean|
|BootstrapContextAware||
|LoadTimeWeaverAware||
|ServletConfigAware||
|ServletContextAware||

### Bean的自动装配

### Resources & ResourceLoader