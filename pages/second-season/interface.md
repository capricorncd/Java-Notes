# 接口

接口可以理解为一种特殊的`类`，由`全局常量`和`公共的抽象方法`所组成。

![](img/interface-example.jpg)

> [!TIP|style:flat|label:Concept]

> 类是一种具体实现，而接口定义了某一批类所需要遵守的 `规范`，接口不关心这些类的内部数据，及类里方法的实现细节，它只规定这些类必须提供某些方法。

### 语法：

```
[修饰符] abstract interface 接口名称 [extends 父接口1, 父接口2...] {
    零到多个常量定义...
    零到多个抽象方法的定义...
}
```

关键字`abstract`可以省略，系统自动默认会添加`abstract`关键字。

接口就是用来被继承、被实现的，修饰符一般建议用`public`

> [!WARNING|style:flat]

> 不能使用private和protected修饰接口

### 接口定义

常量：

接口中的属性是常量，即使定义时不添加 `public static final` 修饰符，系统也会自动加上。

方法：

接口中的方法只能是抽象方法，即使定义时不添加 `public abstract` 修饰符，系统也会自动加上。

### 使用接口

一个类可以实现一个或多个接口，实现接口使用implements关键字。Java中一个类只能继承一个父类，是不够灵活的，通过实现多个接口来做补充（弥补）。

继承父类实现的接口语法：

```
[修饰符] class 类名 extends 父类 implements 接口1, 接口2... {
    // 类体部分
    // 如果继承了抽象类，则必须实现继承的抽象方法
    // 如果遵守了某个接口，则必须实现接口中的抽象方法
}
```

> [!WARNING|style:flat]

> 如果继承了抽象类，则必须实现继承的抽象方法

> 如果遵守了某个接口，则必须实现接口中的抽象方法

> 如果要继承父类，则继承父类必须在实现接口以前，即extends与
implements不能交换位置。

```java
// new -> interface
// IPlayGame.java
package com.phone;

public interface IPlayGame {
	public void playGame();
}

// 系统会默认添加abstract关键字
//public abstract interface IPlayGame {
//	public abstract void playGame();
//}
```

```java
// SmartPhone.java
package com.phone;

public class SmartPhone extends Phone implements IPlayGame {

	@Override
	public void call() {
		// TODO Auto-generated method stub
		System.out.println("智能手机，是通过语音来打电话");
	}

	@Override
	public void message() {
		// TODO Auto-generated method stub
		System.out.println("智能手机，是通过语音来发短信");
	}

	@Override
	public void playGame() {
		// TODO Auto-generated method stub
		System.out.println("智能手机具有了玩游戏的功能");
	}

}
```

```java
// Psp.java
package com.phone;

public class Psp implements IPlayGame {

	@Override
	public void playGame() {
		// TODO Auto-generated method stub
		System.out.println("PSP具有了玩游戏的功能");
	}

}
```

```java
// Initial.java
package com.phone;

public class Initial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Phone tel1 = new CellPhone();
		tel1.call();
		tel1.message();
		Phone tel2 = new SmartPhone();
		tel2.call();
		tel2.message();

		// Interface
		IPlayGame ip1 = new SmartPhone();
		ip1.playGame();
		IPlayGame ip2 = new Psp();
		ip2.playGame();
	}

}
```

### 匿名内部类

匿名内部类：就是没有名称的内部类。

接口在使用过程当中，还经常与匿名内部类配合使用。

多用于关注实现，而不关注实现类的名称。

语法：

```java
Interface i = new Interface() {
    public void method() {
        System.out.println("匿名内部类实现接口的方式");
    }
}
```

```java
package com.phone;

public class Initial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Phone tel1 = new CellPhone();
		tel1.call();
		tel1.message();
		Phone tel2 = new SmartPhone();
		tel2.call();
		tel2.message();

		// Interface
		IPlayGame ip1 = new SmartPhone();
		ip1.playGame();
		IPlayGame ip2 = new Psp();
		ip2.playGame();

		// 匿名内部类实现接口
		IPlayGame ip3 = new IPlayGame() {

			@Override
			public void playGame() {
				// TODO Auto-generated method stub
				System.out.println("匿名内部类实现接口的方式");
			}

		};
		ip3.playGame();

        // 直接new
        // Android中使用较为频繁
		new IPlayGame() {

			@Override
			public void playGame() {
				// TODO Auto-generated method stub
				System.out.println("直接使用new，实现匿名内部类接口");
			}

		}.playGame();
	}

}
```
