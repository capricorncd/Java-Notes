# 泛型

**集合**中的元素，可以是任意类型的对象（对象的引用）。

* 如果把某个对象放入集合，则会忽略他的类型，而把他当作Object处理。

### 泛型

> [!TIP|style:flat|label:什么是泛型]

> **泛型**是jdk5引入的类型机制，就是将类型参数化，它是早在1999年就制定的jsr14的实现。

> **泛型**机制将类型转换时的类型检查从运行时提前到了编译时。比杂乱得使用Object，并在需要时再 `强制类型转换的机制` 具有更好的可读性和安全性。

> **泛型**程序设计意味着程序可以被不同类型的对象重用，类似c++的模版。

> **泛型**对于集合类尤其有用，如ArrayList。这里可能有疑问，既然泛型为了适应不同的对象，ArrayList本来就可以操作不同类型的对象呀？那是因为没有泛型之前采用继承机制实现的，实际上它只维护了一个Object对象的数组。结果就是对List来说它只操作了一类对象Object，而在用户看来却可以保存不同的对象。

**泛型**则是规定了某个集合，只可以存放特定类型的对象。

* 会在编译期间进行类型检查。

* 可以直接按指定类型获取集合元素，即无需使用Object对象取出，再做类型转换。

```java
import java.util.ArrayList;
import java.util.List;

public class TestGeneric {

	// 带有泛型Course的List类型属性
	public List<Course> courses;

	// 构造器
	public TestGeneric() {
		this.courses = new ArrayList<Course>();
	}

	public void testAdd() {
		Course cr1 = new Course(1, "世界地理");
		courses.add(cr1);
		// 泛型集合中，不能添加泛型规定的类型以外的对象，否则会报错！
		// [WARNING:The method add(Course) in the type List<Course> is not applicable for the arguments (Strring)]
//		courses.add("添加一个奇怪的东西");
		Course cr2 = new Course(2, "Java基础");
		courses.add(cr2);
	}

	public void testForEach() {
		for (Course cr : courses) {
			System.out.println(cr.id + ":" + cr.name);
		}
	}

	public static void main(String[] args) {
		TestGeneric tg = new TestGeneric();
		tg.testAdd();
		tg.testForEach();
	}

}
```

* 泛型集合中，不仅可以存放规定的泛型类型，还可以存放 `泛型的子类型`。

* 泛型集合中，不支持基本类型，只支持引用类型。可以通过使用**包装类**限定允许存入的基本数量类型。

```java
public void testBasicType() {
    // [Syntax error, insert "Dimensions" to complete ReferenceType]
//	List<int> list = new ArrayList<int>();
    List<Integer> list = new ArrayList<Integer>();
    list.add(1000);
    System.out.println("基本类型必须使用包装类作为泛型！" + list.get(0));
}
```

### 例子

Course类

```java
/**
 * 课程类
 * @author capricorncd
 *
 */
public class Course {
	public int id;
	public String name;

	public Course (int id, String name) {
		this.id = id;
		this.name = name;
	}

	// 无参构造器，子类继承时必须调用该无参构造器，
	// 无，则在子类中编辑器会报错
	// [WARNING:Implicit super constructor Course() is undefined for default constructor. Must define an explicit constructor]
	public Course() {

	}
}
```

ChildCourse类

```java
public class ChildCourse extends Course {

}
```

TestGeneric类

```java
public class TestGeneric {

	// 带有泛型Course的List类型属性
	public List<Course> courses;

	// 构造器
	public TestGeneric() {
		this.courses = new ArrayList<Course>();
	}

	public void testAdd() {
		Course cr1 = new Course(1, "世界地理");
		courses.add(cr1);
		// 泛型集合中，不能添加泛型规定的类型(及其子类型)以外的对象，否则会报错！
		// [WARNING:The method add(Course) in the type List<Course> is not applicable for the arguments (Strring)]
//		courses.add("添加一个奇怪的东西");
		Course cr2 = new Course(2, "Java基础");
		courses.add(cr2);
	}

	public void testForEach() {
		for (Course cr : courses) {
			System.out.println(cr.id + ":" + cr.name);
		}
	}

	/**
	 * 泛型集合，可以添加泛型的子类对象实例
	 */
	public void testChild() {
		ChildCourse ccr = new ChildCourse();
		ccr.id = 3;
		ccr.name = "我是子类的对象实例";
		courses.add(ccr);
	}

	public static void main(String[] args) {
		TestGeneric tg = new TestGeneric();
		tg.testAdd();
		tg.testChild();
		tg.testForEach();
	}

}
```

运行结果：

```
1:世界地理
2:Java基础
3:我是子类的对象实例
```

### 扩张阅读

https://www.cnblogs.com/coprince/p/8603492.html

http://www.runoob.com/java/java-generics.html
