# Java中的集合框架

## 集合的概念

**现实生活中**：把很多的事物凑在一起。比如购物车是商品的集合，军队是军人的集合等。

**数学中的集合**：具有共同属性的事物的总体。比如有理数，整数等。

**Java中的集合类**：是一种工具类，就像是容器，储存任意数量的具有共同属性的对象。

![](img/set-xxx.jpg)

#### 集合的作用

在类的内部，对数据进行组织；

![](img/set-effect.jpg)

简单而快捷的搜索大数量的条目；

有的集合接口，提供了一系列排列有序的元素，并且可以在序列中间快速的插入或者删除有关元素。

有的集合接口，提供了映射关系，可以通过关键字key去快速查找到对应的唯一对象，而这个关键字可以是任意类型。

#### 与数组对比

数组长度固定，超出长度时，需要重新创建拷贝数据到新的数据。

集合：长度可以根据数据数量自动改变。

> [!TIP|style:flat|label:总结]

> 数组的长度固定，集合长度可变。

> 数组只能通过下标访问元素，类型固定，查找数据需要逐个遍历。而有的集合可以通过任意类型查找所映射的具体对象。

## Java集合框架体系结构

主要由两大家族（两个根接口）组成：Collection、Map

#### Collection子接口：List、Queue、Set

List（序列）、Queue（队列）：元素排列有序，且可以重复。

Set（集）：元素无序，且不可重复。

List与Set较为常用。

List中一个很重要的实现类ArrayList（数组序列）。

Queue中一个重要的实现类LinkedList（链表），同时也是List的实现类。

Set中一个重要的实现类HashSet（哈希集）。

![](img/collection-map.jpg)

#### Map

Map也有很多子接口。

Map中一个很重要的实现类：HashMap（哈希表）。

> [!TIP|style:flat|label:数据存储]

> Collection中存储一个个独立的对象。

> Map内以Key、Value键值对形式存储数据，即一个Entry（键值对，Map的内部类）类的实例。Key、Value可以是任意类型的对象。

> Collection可以想象为单身宿舍，里面存储的一个一个的光棍。

> Map内存储的一对一对的夫妇。

### Collection接口、子接口以及实现类

Collection接口

是List、Set和Queue接口的父接口。

定义了可用于操作List、Set、Queue的方法：增删改查。

#### List接口及其实现类：ArrayList

List是元素有序，并且可以重复的集合，被称为序列。

List可以精确的控制每个元素的插入位置，或删除某个指定位置元素。

ArrayList：数组序列，是List的一个重要实现类。

ArrayList底层是由数组实现的。

```java
// List接口
import java.util.List;
```

![](img/interface-list-methods.png)

> [!NOTE|label:练习-模拟学生选课功能]

> 选择课程（往集合中添加课程）

> 删除所选的某门课程（删除集合中的元素）

> 查看所选课程

> 修改所选课程

Course.java

```java
public class Course {
	public int id;
	public String name;

	public Course (int id, String name) {
		this.id = id;
		this.name = name;
	}
}
```

CourseStorage.java

```java
package com.test.collection;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 备选课程库
 * @author capricorncd
 *
 */
public class CourseStorage {
	// 用于存放课程的List
	public List coursesToSelect;

	// constructor
	public CourseStorage () {
		// 初始化coursesToSelect属性
		// List是一个接口类，不能直接实例化，
		// 所以使用实现类ArrayList
		this.coursesToSelect = new ArrayList();
	}

	/**
	 * 往coursesToSelect中添加课程
	 */
	public void addCourse (int id, String name) {
		try {
			// 创建一个课程对象
			Course cr = new Course(id, name);
			// 调用add方法，添加到备选课程List中
			coursesToSelect.add(cr);
			System.out.println("Success in addCourse (int id, String name): " + id + "=>" + name);
		} catch (Exception e) {
			System.out.println("Failure to addCourse (int id, String name): " + id + "=>" + name);
		}
	}

	public void addCourse (int index, int id, String name) {
		try {
			// 创建一个课程对象
			Course cr = new Course(id, name);
			// 调用add方法，添加到备选课程List中
			coursesToSelect.add(index, cr);
			Course temp = (Course) coursesToSelect.get(index);
			System.out.println("Success in addCourse (int index, int id, String name): " + temp.id + "=>" + temp.name);
		} catch (Exception e) {
			System.out.println("Failure to addCourse (int index, int id, String name): " + id + "=>" + name);
		}
	}

	public void addCourses (Course[] courses) {
		try {
			coursesToSelect.addAll(Arrays.asList(courses));
			for (Course cr : courses) {
				System.out.println("Success in addCourses (Course[] courses): " + cr.id + "=>" + cr.name);
			}
		} catch (Exception e) {
			System.out.println("Failure to addCourses (Course[] courses): " + courses.toString());
		}
	}

	public void addCourses (int index, Course[] courses) {
		try {
			coursesToSelect.addAll(index, Arrays.asList(courses));
			for (Course cr : courses) {
				System.out.println("Success in addCourses (int index, Course[] courses): " + cr.id + "=>" + cr.name);
			}
		} catch (Exception e) {
			System.out.println("Failure to addCourses (int index, Course[] courses): " + courses.toString());
		}
	}

	public void printAllCourses () {
		int size = coursesToSelect.size();
		Course cr;
		for (int i = 0; i < size; i++) {
			cr = (Course) coursesToSelect.get(i);
			System.out.println("Course: " + cr.id + " " + cr.name);
		}
	}

	public static void main(String[] args) {
		CourseStorage cs = new CourseStorage();
		// 添加课程
		cs.addCourse(1, "数据结构");
		cs.addCourse(0, 2, "C语言");
		// 批量添加课程
		Course[] courses = { new Course(3, "离散数学"), new Course(4, "汇编语言") };
		cs.addCourses(courses);
		Course[] courses2 = { new Course(5, "高等数学"), new Course(6, "GoLang") };
		cs.addCourses(2, courses2);
		// 打印所有元素
		cs.printAllCourses();
	}
}
```






