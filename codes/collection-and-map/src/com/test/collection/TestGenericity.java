package com.test.collection;

import java.util.ArrayList;
import java.util.List;

public class TestGenericity {
	
	// 带有泛型Course的List类型属性
	public List<Course> courses;
	
	// 构造器
	public TestGenericity() {
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
	
	/**
	 * 泛型集合中，不支持基本类型，只支持引用类型。可以通过使用**包装类**限定允许存入的基本数量类型。
	 */
	public void testBasicType() {
		// [Syntax error, insert "Dimensions" to complete ReferenceType]
//		List<int> list = new ArrayList<int>();
	    List<Integer> list = new ArrayList<Integer>();
	    list.add(1000);
	    System.out.println("基本类型必须使用包装类作为泛型！" + list.get(0));
	}

	public static void main(String[] args) {
		TestGenericity tg = new TestGenericity();
		tg.testAdd();
		tg.testChild();
		tg.testForEach();
		tg.testBasicType();
	}

}
