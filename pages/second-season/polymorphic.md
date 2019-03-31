# 多态

对象的多种形态。引用多态、方法多态。

> 继承是多态实现的基础

* 引用多态

    父类的引用可以指向`本类`的对象。

    父类的引用可以指向`子类`的对象。

* 方法多态

    创建`本类`对象时，调用的方法为`本类`方法。

    创建`子类`对象时，调用的方法为`子类重写`的方法或者`继承`的方法。

```java
// Animal.java
package com.polymorphic;

public class Animal {
	public void eat () {
		System.out.println("Animal has eat method.");
	}
}
```

```java
// Dog.java
package com.polymorphic;

public class Dog extends Animal {
	// overwrite
	public void eat () {
		System.out.println("Dogs eat meat.");
	}
}
```

```java
// Cat.java
package com.polymorphic;

public class Cat extends Animal {

}
```

```java
// Initial.java
package com.polymorphic;

public class Initial {

	public static void main(String[] args) {
		/*
		 * 引用多态/方法多态
		 */
		// 父类的引用可以指向本类的对象
		Animal obj1 = new Animal();
		// 父类的引用可以指向子类的对象
		Animal obj2 = new Dog();
		Animal obj3 = new Cat();
		// methods polymorphic
		obj1.eat();
		obj2.eat();
		obj3.eat();
		/*
		 * 引用类型转换
		 */
		Dog dog = new Dog();
		Animal animal = dog; // 自动类型提升，向上类型转换
		// Warning
		// Dog dog2 = animal; // Type mismatch: cannot convert from Animal to Dog
		Dog dog2 = (Dog)animal; // 向下类型转换 强制类型转换
		// error
		// Cat cat = (Cat)animal; // 编译时Cat类型(不会报错)，运行时Dog类型(抛出异常)
		// instanceof
		if (animal instanceof Cat) {
			Cat cat = (Cat)animal;
		} else {
			System.out.println("无法进行Cat类型转换");
		}
	}

}
```

### 多态中的引用类型转换

`向上`类型转换（隐式/自动类型转换），是小类型到大类型的转换。

`向下`类型转换（强制类型转换），是大类型到小类型。容易发送数据溢出。

`instanceof`运算符，来解决引用对象的类型，避免类型转换的安全性问题。

```java

package com.polymorphic;

public class Initial {

	public static void main(String[] args) {
		/*
		 * 引用多态/方法多态
		 */
		// 父类的引用可以指向本类的对象
		Animal obj1 = new Animal();
		// 父类的引用可以指向子类的对象
		Animal obj2 = new Dog();
		Animal obj3 = new Cat();
		// methods polymorphic
		obj1.eat();
		obj2.eat();
		obj3.eat();
		/*
		 * 引用类型转换
		 */
		Dog dog = new Dog();
		Animal animal = dog; // 自动类型提升，向上类型转换
		// Warning
		// Dog dog2 = animal; // Type mismatch: cannot convert from Animal to Dog
		Dog dog2 = (Dog)animal; // 向下类型转换 强制类型转换
		// error
		// Cat cat = (Cat)animal; // 编译时Cat类型(不会报错)，运行时Dog类型(抛出异常)
		// instanceof
		if (animal instanceof Cat) {
			Cat cat = (Cat)animal;
		} else {
			System.out.println("无法进行Cat类型转换");
		}
	}

}
```

### Java 中的抽象类

语法：使用`abstract`关键字修饰，则该类为抽象类。

应用场景：

1. 在某些情况下，某个父类只是知道其子类应该包含怎样的方法，但无法准确知道这些子类如何实现这些方法。（父类规定子类必须包含哪些方法，但不关心子类如何实现）

2. 从多个具有相同特征的类中抽象出一个抽象类，以这个抽象类作为子类的模板，从而避免了子类设计的随意性。

作用：

    限制规定子类必须实现某些方法，但不关心实现细节。

使用规则：

1. abstract 定义抽象类

2. abstract 定义抽象方法，只有声明，不需要实现

3. 包含抽象方法的类是抽象类

4. 抽象类中可以包含普通的方法，也可以没有抽象方法

5. 抽象类不能直接创建，可以定义引用变量

注意：

1. 抽象方法`没有方法体`，以`分号`直接结束。

```
public abstract void call();
public abstract void message();
```

例子

```java
// Phone.java
package com.phone;

public abstract class Phone {
	public abstract void call();
	public abstract void message();
}
```

```java
// CellPhone.java
package com.phone;

public class CellPhone extends Phone {

	@Override
	public void call() {
		// TODO Auto-generated method stub
		System.out.println("以前的手机，是通过键盘来打电话");
	}

	@Override
	public void message() {
		// TODO Auto-generated method stub
		System.out.println("以前的手机，是通过键盘来发短信");
	}

}
```

```java
// SmartPhone.java
package com.phone;

public class SmartPhone extends Phone {

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
	}

}
```

思考题：

```
现有Shape图形类，用Rectangle矩形和Circle圆形子类，求图形的周长和面积
```

```java
// Shape.java
package com.shape;

public abstract class Shape {
	public abstract float getPerimeter();
	public abstract float getArea();
}
```

```java
// Circle.java
package com.shape;

public class Circle extends Shape {
	final float PI = 3.1415926f;
	float radius;
	@Override
	public float getPerimeter() {
		// TODO Auto-generated method stub
		return this.checkRadius() ? 2 * PI * this.radius : 0;
	}

	@Override
	public float getArea() {
		// TODO Auto-generated method stub
		return this.checkRadius() ? PI * this.radius * this.radius : 0;
	}

	private boolean checkRadius() {
		if (this.radius == 0) {
			System.out.println("未设置圆半径");
			return false;
		}
		return true;
	}
}
```

```java
// Rectangle.java
package com.shape;

public class Rectangle extends Shape {

	public float width;
	public float height;

	@Override
	public float getPerimeter() {
		if (this.width == 0 || this.height == 0) {
			System.out.println("未设置矩形的长或宽");
			return 0;
		}
		// TODO Auto-generated method stub
		return (this.width + this.height) * 2;
	}

	@Override
	public float getArea() {
		// TODO Auto-generated method stub
		return this.width * this.height;
	}

}
```

```java
// Initial.java
package com.shape;

public class Initial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle rect = new Rectangle();
		rect.width = 20.0f;
		rect.height = 10.0f;
		System.out.println("长方形边长为：" + rect.getPerimeter() + "厘米");
		System.out.println("长方形面积为：" + rect.getArea() + "平方厘米");
		// circle
		Circle circle = new Circle();
		circle.radius = 20.0f;
		System.out.println("圆周为：" + circle.getPerimeter() + "厘米");
		System.out.println("圆面积为：" + circle.getArea() + "平方厘米");
	}

}
```
