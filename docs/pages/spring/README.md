# Spring 框架简介

Spring 是一个开源框架，是为了解决企业应用程序开发复杂性而创建的。框架的主要优势之一就是其分层架构，分层架构允许您选择使用哪一个组件，同时为 J2EE 应用程序开发提供集成的框架。

![spring-framework](img/spring-framework.gif)

### 软件框架

维基百科：**软件框架**，通常指的是为了实现某个业界标准或完成特定基本任务的软件组件规范，也指为了实现某个软件组织规范时，提供规范所要求的基础功能的软件产品。

> ![TIP|style:flat|label:框架]

> 是制定一套规范或规则（思想），大家（程序员）在该规范或者规则（思想）下工作。或者说就是使用别人搭好的舞台，你来做表演。

**特点**：

* 半成品

* 封装了特定的处理流程和控制逻辑。（处理流程是为了完成自身的处理流程）

* 成熟的、不断升级改进的软件

**框架与类库的区别**

* 框架一般是封装了逻辑、高内聚的，类库则是松散的工具组合

* 框架专注于某一领域，类库则是更通用的

**为什么使用框架**

* 软件系统日趋复杂

* 重用度高，开发效率和质量提高

* 软件设计人员要专注于对领域的了解，使需求分析充分

* 框架有完整的文档，易于学习、上手、快速解决问题

### 接口

* 用于沟通的中介物的抽象化

* 实体把自己提供给外界的一种抽象化说明，用以由内部操作分离出外部沟通方法，使其能被修改内部而不影响外界其他实体与其交换的方式

* 对应Java接口即声明，声明了哪些方法时对外公开提供的

* 在Java8中，接口可以拥有方法体

### 面向接口编程

* 结构设计中，分清层次及调用关系，每层只向外（上层）提供一组功能接口，各层间仅依赖接口而非实现类

* 接口实现的变动不影响各层间的调用，这一点在公共服务中尤为重要

* "面向接口编程"中的"接口"是用于隐藏具体实现和实现多态性的组件

OneInterface.java

```java
package com.test;

public interface OneInterface {
	String hello(String str);
}
```

OneInterfaceImpl.java

```java
package com.test;

public class OneInterfaceImpl implements OneInterface {
	@Override
	public String hello(String str) {
		return "Word from interface \"OneInterface\": " + str;
	}
}
```

Main.java

```java
package com.test;

public class Main {

	public static void main(String[] args) {
		OneInterfaceImpl oif = new OneInterfaceImpl();
		System.out.println(oif.hello("World"));
	}

}
```

### 参考资料&&扩展阅读

https://www.imooc.com/learn/196

https://www.ibm.com/developerworks/cn/java/wa-spring1/