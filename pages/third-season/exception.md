# 异常与异常处理

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

> [!TIP|style:flat]

> `运行时异常` 会由Java虚拟机自动抛出，并自动捕获。

> 运行时异常的出现，多数情况下说明代码本身出了问题，应该从逻辑上去改进代码。

### 检查异常 CheckException

比如：文件异常 IOException，SQl异常 SQLException等等很多，需要开发人员自己捕获及处理。

### 异常处理

```
try-catch, try-catch-finally
```

### 原视频教程出处

https://www.imooc.com/learn/110
