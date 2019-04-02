# 多态

对象的多种形态。引用多态、方法多态。

> [!TIP|style:flat]

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
