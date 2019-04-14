package com.test.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 需求：
 * 1、通过Collections.sort()方法，对Integer泛型的List进行排序；
 * 2、对String泛型的List进行排序；
 * 3、对其他类型泛型的List进行排序，以Student2为列
 */
public class TestCollection {
	
	/**
	 * 1、通过Collections.sort()方法，对Integer泛型的List进行排序；
	 * 创建Integer泛型的List，插入10个100以内的不重复随机整数
	 * 调用Collections.sort()方法对其进行排序
	 */
	public void testSort1() {
		List<Integer> integerList = new ArrayList<Integer>();
		// 插入十个100以内的不重复随机整数
		Random random = new Random();
		Integer k;
		for (int i = 0; i < 10; i++) {
			do {
				k = random.nextInt(100);
			} while (integerList.contains(k));
			integerList.add(k);
			System.out.println("成功添加整数：" + k);
		}
		System.out.println("------- before sort -------");
		StringBuilder str1 = new StringBuilder();
		for (Integer integer : integerList) {
			str1.append(integer + " ");
		}
		System.out.println(str1);
		// 排序
		System.out.println("------- after sort -------");
		Collections.sort(integerList);
		StringBuilder str2 = new StringBuilder();
		for (Integer integer : integerList) {
			str2.append(integer + " ");
		}
		System.out.println(str2);
	}
	
	/**
	 * 2、对String泛型的List进行排序；
	 * 创建String泛型的List，添加3个乱序的String元素
	 * 调用sort方法，再次输出排序后的顺序
	 */
	public void testSort2() {
		List<String> stringList = new ArrayList<String>();
		stringList.add("huawei");
		stringList.add("alibaba");
		stringList.add("jingdong");
		System.out.println("------- before sort -------");
		StringBuilder str1 = new StringBuilder();
		for (String str : stringList) {
			str1.append(str + " ");
		}
		System.out.println(str1);
		// 排序
		System.out.println("------- after sort -------");
		// string排序规则
		// 0-9，A-Z，a-z
		Collections.sort(stringList);
		StringBuilder str2 = new StringBuilder();
		for (String str : stringList) {
			str2.append(str + " ");
		}
		System.out.println(str2);
	}
	
	/**
	 * 3、对其他类型泛型的List进行排序，以Student2为列
	 * Comparable和Comparator
	 */
	public void testSort3() {
		List<Student> studentList = new ArrayList<Student>();
		Random random = new Random();
		studentList.add(new Student(random.nextInt(1000), "Jack"));
		studentList.add(new Student(random.nextInt(1000), "Maria"));
		studentList.add(new Student(random.nextInt(1000), "Tomson"));
		System.out.println("------- before sort -------");
		StringBuilder str1 = new StringBuilder();
		for (Student st : studentList) {
			str1.append(st.id + ":" + st.name + " ");
		}
		System.out.println(str1);
		// id排序
		System.out.println("------- after sort -------");
		// 未实现Comparable接口前，会报以下错误：
		// [WARNING:The method sort(List<T>) in the type Collections is not applicable for the arguments (List<Student>)]
		Collections.sort(studentList);
		StringBuilder str2 = new StringBuilder();
		for (Student st : studentList) {
			str2.append(st.id + ":" + st.name + " ");
		}
		System.out.println(str2);
		// 姓名排序
		System.out.println("------- sort by name -------");
		Collections.sort(studentList, new StudentComparator());
		StringBuilder str3 = new StringBuilder();
		for (Student st : studentList) {
			str3.append(st.id + ":" + st.name + " ");
		}
		System.out.println(str3);
	}

	public static void main(String[] args) {
		TestCollection tc = new TestCollection();
//		tc.testSort1();
//		tc.testSort2();
		tc.testSort3();
	}

}
