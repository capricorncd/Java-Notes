# Java中的抽象类

语法：使用`abstract`关键字修饰，则该类为抽象类。

> [!TIP|style:flat|label:应用场景]

> 1. 在某些情况下，某个父类只是知道其子类应该包含怎样的方法，但无法准确知道这些子类如何实现这些方法。（父类规定子类必须包含哪些方法，但不关心子类如何实现）

> 2. 从多个具有相同特征的类中抽象出一个抽象类，以这个抽象类作为子类的模板，从而避免了子类设计的随意性。

作用：

    限制规定子类必须实现某些方法，但不关心实现细节。

使用规则：

1. abstract 定义抽象类

2. abstract 定义抽象方法，只有声明，不需要实现

3. 包含抽象方法的类是抽象类

4. 抽象类中可以包含普通的方法，也可以没有抽象方法

5. 抽象类不能直接创建，可以定义引用变量

> [!WARNING|style:flat|label:注意]

> 抽象方法`没有方法体`，以`分号`直接结束。

```java
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
