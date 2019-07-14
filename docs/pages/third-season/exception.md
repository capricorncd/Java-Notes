# 异常与异常处理

```
exception /ɪkˈsepʃn/
n. 一般情况以外的人(或事物);例外;规则的例外;例外的事物
```

字面意思：有异于常态，和正常情况不一样，有错误出现。

程序中：阻止当前方法或作用域正常运行的情况，称之为异常。

> [!TIP|style:flat|label:Exception异常]

> 异常指的是在程序运行过程中发生的异常事件，通常是由外部问题（如硬件错误、输入错误）所导致的。在Java等面向对象的编程语言中异常属于对象。

### 导致的问题：

1、程序得不到正常的运行，不能正常退出

2、导致用户数据丢失

3、程序运行的资源得不到有效的释放

### 异常处理作用：

1、对异常正确的处理，能将异常提示给编程人员或者是用户

2、使已中断的程序，以适当的方式继续运行或退出，并且可以保存用户的当前操作，或数据回滚

3、最后再把占用的资源释放掉

### Throwable类

主要有两个儿子`Error`与`Exception`，即`Error`与`Exception`类继承`Throwable`类

* Error 错误

> [!TIP|style:flat|label:Error]

> 系统错误，内存溢出

> 虚拟机错误 VirtualMachineError

> 线程死锁 ThreadDeath

> 它的出现，即意味着程序挂了，即程序终结者

> 好比工厂停水/停电/机器挂了

* Exception 异常

> [!TIP|style:flat|label:Exception]

> 编码、环境、用户操作输入出现问题

> 主要有 RuntimeException 称之为非检查异常

> 其他异常称之为：检查异常 CheckException

### 非检查异常 RuntimeException

引起RuntimeException的原因：

1、引用了一个空对象或方法。`空指针异常` `NullPointerException`

```java
String str = null;
System.out.println(str.length());
```

2、数组访问越界。`数组下标越界异常` `ArrayIndexOutOfBoundsException`

```java
int[] arr = { 1, 2, 3 }
for (int i = 0; i <= 3; i++) {
    System.out.println(arr[i]);
}
```

3、错误的类型转换。`类型转换异常` `ClassCastException`

```java
class Animal {}
class Dog extends Animal {}
class Cat extends Animal {}
public class Test {
    public static void main (String[] args) {
        Animal a1 = new Dog();
        Animal a2 = new Cat();
        Dog d1 = (Dog)a1;
        Dog d2 = (Dog)a2;
    }
}
```

4、运算异常，整数去整除零。`算术异常` `ArithmeticException`

```java
int a = 12;
int b = 0;
System.out.println(a / b);
```

5、等等...

> [!TIP|style:flat|label:RuntimeException]

> `运行时异常` 会由Java虚拟机自动抛出，并自动捕获。

> 运行时异常的出现，多数情况下说明代码本身出了问题，应该从逻辑上去改进代码。

### 检查异常 CheckException

比如：文件异常 IOException，SQl异常 SQLException等等很多，需要开发人员自己捕获及处理。

### 异常处理

```
try-catch, try-catch-finally
```

语法

```java
try {
    // 一些会抛出异常的方法
} catch (Exception e) {
    // 处理该异常的代码块
}
```

> [!WARNING|style:flat|label:如果try抛出异常将会发生什么？]

> 抛出异常的方法会终止执行！

> 程序的控制权将被移交给catch块中的异常处理程序

##### catch中可以做的事情：

根据业务情况，可以发出一些警告，提示用户或开发人员

也可以记录错误日志等操作等等

```java
try {
    System.out.print("请输入你的年龄：");
    Scanner input = new Scanner(System.in);
    int age = input.nextInt();
    System.out.println("The ten years ago, you will" + (age + 10));
} catch (InputMismatchException e) {
    System.out.println("你应该输入整数！");
}
System.out.println("程序结束啦！");
```

try会抛出很多种类型的异常，该如何处理？

```java
Scanner input = new Scanner(System.in);
try {
    System.out.print("请输入第一个数：");
    int one = input.nextInt(); // input 12
    System.out.print("请输入第二个数：");
    int tow = input.nextInt(); // input 0
    System.out.println(one / tow);
} catch (InputMismatchException e) {
    // 输入不匹配异常
    System.out.println("你应该输入整数！");
} catch (ArithmeticException e) {
    // 英 [əˈrɪθmətɪk]   美 [əˈrɪθmɪtɪk]
    // 算术异常
    System.out.println("除数不能为0！");
} catch (Exception e) {
    System.out.println("不知名异常！");
} finally {
    // 最终将要执行的一些代码
}
System.out.println("程序结束啦！");
```

#### 异常处理注意事项

异常捕获顺序，一定要按先小后大，即先子类再父类：

```
子类 -> 父类
```

当异常发生时，异常处理系统会就近寻找匹配的异常处理的catch程序。子类继承于父类，针对于子类的处理程序，父类也是适用的。

#### 善后工作处理 finally

异常发生后，可以使用finally关闭连接，或关闭文件等善后操作。

#### 例子

```java
package com.trycatch.test;

public class TryCatchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TryCatchTest tc = new TryCatchTest();
		int result = tc.test();
		System.out.println("result: " + result);
	}

	/**
	 * test method
	 * @return
	 */
	public int test() {
		int divider = 10;
		int result = 0;
		try {
			while (divider > -1) {
				divider--;
				result += 100 / divider;
			}
			return result;
		} catch (Exception e) {
			// 打印异常
			e.printStackTrace();
			System.out.println("程序抛出异常了！！");
			return -1;
		}
	}
}
```

结果

```
java.lang.ArithmeticException: / by zero
	at com.trycatch.test.TryCatchTest.test(TryCatchTest.java:22)
	at com.trycatch.test.TryCatchTest.main(TryCatchTest.java:8)
程序抛出异常了！！
result: -1
```

test2

```java
package com.trycatch.test;

public class TryCatchTest {

	public static void main(String[] args) {
		TryCatchTest tc = new TryCatchTest();
		int result2 = tc.test2();
		System.out.println("test2返回值result为: " + result2);
	}

	/**
	 * test method
	 * @return
	 */
	public int test2() {
		int divider = 10;
		int result = 0;
		try {
			while (divider > -1) {
				divider--;
				result += 100 / divider;
			}
			return result;
		} catch (Exception e) {
			// 打印异常
			e.printStackTrace();
			System.out.println("Test2抛出异常了！！");
			return 999;
		} finally {
			System.out.println("这是finally！");
			System.out.println("Result值为：" + result);
		}
	}
}

```

结果

```
java.lang.ArithmeticException: / by zero
	at com.trycatch.test.TryCatchTest.test2(TryCatchTest.java:45)
	at com.trycatch.test.TryCatchTest.main(TryCatchTest.java:10)
Test2抛出异常了！！
这是finally！
Result值为：281
test2返回值result为: 999
```

> [!TIP|style:flat|label:总结]

> catch块跟在try语句后面，它可以是一个或多个

> catch块有一个参数，该参数是某种异常类的对象

> 多重catch语句中，异常类型必须子类在前，父类在后

### 原视频教程出处

https://www.imooc.com/learn/110
