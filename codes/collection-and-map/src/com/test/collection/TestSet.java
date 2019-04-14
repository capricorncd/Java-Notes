package com.test.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TestSet {
	
	public List<Course> coursesToSelect;
	
	// constructor
	public TestSet() {
		coursesToSelect = new ArrayList<Course>();
	}
	
	/**
	 * System.out.println
	 * @param str
	 */
	public static void print(String str) {
		System.out.println(str);
	}
	
	/**
	 * 通过for each方法访问集合元素
	 */
	public void testForEach() {
		print("-------------- testForEach ---------------");
		print("有以下课程待选(通过forEach访问)：");
		for (Object obj : coursesToSelect) {
			Course cr = (Course) obj;
			print("Course: " + cr.id + " " + cr.name);
		}
		print("-------------- 华丽的分割线 ---------------");
	}
	
	/**
	 * 添加备课程
	 */
	public void testAdd() {
		coursesToSelect.add(new Course(1, "数据结构"));
		coursesToSelect.add(new Course(2, "C语言"));
		// 批量添加课程
		Course[] courses = { new Course(3, "离散数学"), new Course(4, "汇编语言"), new Course(5, "高等数学"), new Course(6, "GoLang") };
		coursesToSelect.addAll(Arrays.asList(courses));
	}
	
	/**
	 * 遍历输出学生的课程
	 * @param student
	 */
	public void forEachForSet(Student student) {
		print(student.name + "成功选择了" + student.courses.size() + "门课程！");
		for (Course cr : student.courses) {
			print(cr.id + ":" + cr.name);
		}
	}
	
	/**
	 * 测试List的contains方法
	 */
	public void testLsitContains() {
		// 获取备选课程的第0个元素
		Course course = coursesToSelect.get(0);
		// 打印输出coursesToSelect是否包含course对象
		System.out.println("取得课程：" + course.name);
		System.out.println("备选课程中是否包含课程：" + course.name + ", " + coursesToSelect.contains(course));
		// 创建一个新的课程对象，ID和名称，与course对象完全一样
		// 注意对比，重写Course类equals方法后的结果
		Course courseB = new Course(course.id, course.name);
		System.out.println("取得课程：" + courseB.name);
		System.out.println("备选课程中是否包含课程B：" + courseB.name + ", " + coursesToSelect.contains(courseB));
		// 提示输入课程名称
		System.out.println("请输入课程名称：");
		Scanner console = new Scanner(System.in);
		String name = console.next();
		// 创建一个新的课程对象
		Course courseC = new Course();
		courseC.name = name;
		System.out.println("新创建的课程：" + courseC.name);
		System.out.println("备选课程中是否包含课程C：" + courseC.name + ", " + coursesToSelect.contains(courseC));
	}
	
	/**
	 * 测试Set的contains方法
	 */
	public void testSetContains() {
		// 模拟学生已选了课程
		Student student = new Student(1, "Maria");
		student.courses.add(coursesToSelect.get(0));
		student.courses.add(coursesToSelect.get(1));
		student.courses.add(coursesToSelect.get(2));
		// 提示输入课程名称
		System.out.println("请输入课程名称：");
		Scanner console = new Scanner(System.in);
		String name = console.next();
		// 创建一个新的课程对象
		Course courseC = new Course();
		courseC.name = name;
		System.out.println("新创建的课程：" + courseC.name);
		System.out.println("备选课程中是否包含课程C：" + courseC.name + ", " +
			student.courses.contains(courseC));
	}

	public static void main(String[] args) {
		TestSet ts = new TestSet();
		ts.testAdd();
		ts.testForEach();
		// 创建一个学生对象
		Student student = new Student(1, "John");
		print("欢迎学生：" + student.name + "选课！");
		// 创建一个Scanner对象，用来接收从键盘输入的课程ID
		Scanner input = new Scanner(System.in);
		// 循环三次，每次输入课程ID
		for (int i = 0; i < 3; i++) {
			System.out.print("请输入课程ID: ");
			Integer courseID = new Integer(input.next());
			for (Course cr : ts.coursesToSelect) {
//				if (cr.id.equals(courseID)) { // 字符串比较
				if (cr.id == courseID) {
					// 往学生的Courses属性中添加与输入的ID匹配的课程
					student.courses.add(cr);
				}
			}
		}
		// 输出学生选课的课程
		ts.forEachForSet(student);
		ts.testLsitContains();
		ts.testSetContains();
	}

}
