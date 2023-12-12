# 包装类

基本数据类型(int、float、double、boolean、char等)是不具备对象的特性的。比如不能调用方法、功能简单。

为了使基本数据类型也 `具备对象的特性`， Java 为每个基本数据类型都提供了一个 `包装类`，这样我们就可以像操作对象那样来操作基本数据类型。

### 基本类型和包装类之间的对应关系：

|基本类型|对应的包装类|
|:--|:--|
|byte|Byte|
|short|Short|
|int|Integer|
|long|Long|
|float|Float|
|double|Double|
|char|Character|
|boolean|Boolean|

### 包装类主要提供了两大类方法：

1、将本类型和其他基本类型进行转换的方法。

2、将字符串和本类型及包装类互相转换的方法。

以 Integer 包装类为例，来看下包装类的特性。

Integer 包装类的构造方法：

|Integer(int value)|创建一个Integer对象，表示指定的int值|
|:--|:--|
|Integer(String s)|创建一个Integer对象，表示String参数所指示的int值|

```java
int i = 2;
// 定义Integer包装类对象，值为5
Integer m = new Integer(5);
// 定义Integer包装类对象，值为8
Integer n = new Integer("8");
```

### Integer包装类的常用方法：

|方法名|返回值|说明|
|:--|:--|:--|
|byteValue()|byte|将Integer转为byte类型|
|doubleValue()|double|转为double类型|
|floatValue()|float|转为float类型|
|intValue()|int|转为int类型|
|longValue()|long|转为long类型|
|parseInt(String s)|static int|将字符串转为int类型|
|toString()|String|转为字符串类型|
|valueOf(String s)|static Integer|将字符串转换为Integer类型|

```java
public class WrapperClass {

	public static void main(String[] args) {
		int i = 2;
		Integer m = new Integer(5);
		Integer n = new Integer("8");
		System.out.println(i);
		System.out.println(m);
		System.out.println(n);

		// 定义int类型变量，值为86
		int score1 = 86;

		// 创建Integer包装类对象，表示变量score1的值
		Integer score2 = new Integer(score1);

		// 将Integer包装类转换为double类型
		double score3 = score2.doubleValue();

		// 将Integer包装类转换为float类型
		float score4 = score2.floatValue();

		// 将Integer包装类转换为int类型
		int score5 = score2.intValue();

		System.out.println("Integer包装类：" + score2);
		System.out.println("double类型：" + score3);
		System.out.println("float类型：" + score4);
		System.out.println("int类型：" + score5);
	}

}
```

运行结果：

```
2
5
8
Integer包装类：86
double类型：86.0
float类型：86.0
int类型：86
```

### 基本类型和包装类之间的转换

基本类型和包装类之间经常需要互相转换，以 Integer 为例（其他几个包装类的操作与此雷同）：

```java
// 定义Integer包装类对象，值为3
Integer a = new Integer(3);
// 将对象和基本类型进行运算
int b = a + 5;
```

在 JDK1.5 引入自动装箱和拆箱的机制后，包装类和基本类型之间的转换就更加轻松便利了。

那什么是装箱和拆箱呢？我们分别来看下

**装箱**：把基本类型转换成包装类，使其具有对象的性质，又可分为手动装箱和自动装箱

```java
// 定义一个int类型值
int i = 10;
// 手动装箱
Integer x = new Integer(i);
// 自动装箱
Integer y = i;
```

**拆箱**：和装箱相反，把包装类对象转换成基本类型的值，又可分为手动拆箱和自动拆箱

```java
// 定义一个Integer包装类对象，值为8
Integer j = new Integer(8);
// 手动拆箱为int类型
int m = j.intValue();
// 自动拆箱为int类型
int n = j;
```

::: tip 总结

Integer 类型可以自动转化为 int 基本类型
:::

int 类型对应的包装类是 java.lang.Integer
:::

long 类型可以自动转化为 Long类型
:::

### 基本类型和字符串之间的转换

在程序开发中，我们经常需要在基本数据类型和字符串之间进行转换。

##### 其中，基本类型转换为字符串有三种方法：

1、使用包装类的 toString() 方法

2、使用String类的 valueOf() 方法

3、用一个空字符串加上基本类型，得到的就是基本类型数据对应的字符串

```java
// 将基本类型转化为字符串
int c = 10;
String str1 = Integer.toString(c);
String str2 = String.valueOf(c);
String str3 = c + "";
```

##### 再来看，将字符串转换成基本类型有两种方法：

1、调用包装类的 parseXxx 静态方法

2、调用包装类的 valueOf() 方法转换为基本类型的包装类，会自动拆箱

```java
// 将字符串转化为基本类型
String str = "8";
int d = Integer.parseInt(str);
int e = Integer.valueOf(str);
```

PS：其他基本类型与字符串的相互转化这里不再一一列出，方法都类似。

::: tip 总结

每一个基本数据类型，都对应一个包装类
:::

包装类都在 java.lang 包中
:::

包装类提供了在不同类型间进行转换的方法
:::

