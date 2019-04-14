package com.test.collection;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * 备选课程库
 * @author capricorncd
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
	 * System.out.println
	 * @param str
	 */
	public static void print (String str) {
		System.out.println(str);
	}
	
	/**
	 * System.out.println
	 * @param type 1成功，0失败
	 * @param str
	 */
	public static void print (int type, String str) {
		System.out.println((type == 1 ? "Success in " : "Failure to ") + str);
	}
	
	/**
	 * 往coursesToSelect中添加课程
	 * @param id
	 * @param name
	 */
	public void addCourse (int id, String name) {
		try {
			// 创建一个课程对象
			Course cr = new Course(id, name);
			// 调用add方法，添加到备选课程List中
			coursesToSelect.add(cr);
			print(1, "addCourse(int id, String name): " + id + "=>" + name);
		} catch (Exception e) {
			print(0, "addCourse(int id, String name): " + id + "=>" + name);
		}
	}
	
	/**
	 * 往coursesToSelect中指定位置添加课程
	 * @param index 索引
	 * @param id 课程id
	 * @param name 课程名称
	 */
	public void addCourse (int index, int id, String name) {
		try {
			// 创建一个课程对象
			Course cr = new Course(id, name);
			// 调用add方法，添加到备选课程List中
			coursesToSelect.add(index, cr);
			Course temp = (Course) coursesToSelect.get(index);
			print(1, "addCourse(int index, int id, String name): " + temp.id + "=>" + temp.name);
		} catch (Exception e) {
			e.printStackTrace();
			print(0, "addCourse(int index, int id, String name): " + id + "=>" + name);
		}
	}
	
	/**
	 * 往coursesToSelect中批量添加课程
	 * @param courses 课程对象数组
	 */
	public void addCourses (Course[] courses) {
		try {
			coursesToSelect.addAll(Arrays.asList(courses));
			for (Course cr : courses) {
				print(1, "addCourses(Course[] courses): " + cr.id + "=>" + cr.name);	
			}
		} catch (Exception e) {
			print(0, "addCourses (Course[] courses): " + courses.toString());
		}
	}
	
	/**
	 * 往coursesToSelect中指定位置开始批量添加课程
	 * @param index
	 * @param courses
	 */
	public void addCourses (int index, Course[] courses) {
		try {
			// Arrays.asList() 将数组转换为一个集合
			coursesToSelect.addAll(index, Arrays.asList(courses));
			for (Course cr : courses) {
				print(1, "addCourses(int index, Course[] courses): " + cr.id + "=>" + cr.name);	
			}
		} catch (Exception e) {
			e.printStackTrace();
			print(0, "addCourses (int index, Course[] courses): " + courses.toString());
		}
	}
	
	/**
	 * 打印coursesToSelect
	 */
	public void printAllCourses () {
		print("-------------- 华丽的分割线 printAllCourses ---------------");
		int size = coursesToSelect.size();
		Course cr;
		for (int i = 0; i < size; i++) {
			cr = (Course) coursesToSelect.get(i);
			print("Course: " + cr.id + " " + cr.name);
		}
		print("-------------- 华丽的分割线 ---------------");
	}
	
	/**
	 * 通过迭代器遍历List
	 */
	public void testItetator () {
		print("-------------- 华丽的分割线 testItetator ---------------");
		// 通过集合的iterator方法，取得迭代器的实例
		Iterator it = coursesToSelect.iterator();
		print("有以下课程待选(通过迭代器访问)：");
		while(it.hasNext()) {
			Course cr = (Course) it.next();
			print("Course: " + cr.id + " " + cr.name);
		}
		print("-------------- 华丽的分割线 ---------------");
	}
	
	/**
	 * 通过for each方法访问集合元素
	 */
	public void testForEach () {
		print("-------------- 华丽的分割线 testForEach ---------------");
		print("有以下课程待选(通过forEach访问)：");
		for (Object obj : coursesToSelect) {
			Course cr = (Course) obj;
			print("Course: " + cr.id + " " + cr.name);
		}
		print("-------------- 华丽的分割线 ---------------");
	}
	
	/**
	 * 修改List中的元素
	 * @param index
	 * @param element
	 */
	public void testModify (int index, Course element) {
		coursesToSelect.set(index, element);
	}
	
	/**
	 * 删除List中的元素
	 * @param i
	 */
	public void testRemove (int i) {
//		Course cr = (Course) coursesToSelect.get(i);
//		print("我是课程：" + cr.id + ":" + cr.name + "，我即将被删除");
		print("即将删除索引为" + i + "的课程：");
		try {
			coursesToSelect.remove(i);
			print("=> 删除成功！");
			testForEach();
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
			print("=> 删除失败，索引为" + i + "的课程不存在！");
		}
	}
	
	/**
	 * 批量删除课程
	 * @param arr
	 */
	public void testRemoveAll (Course[] arr) {
		try {
			coursesToSelect.removeAll(Arrays.asList(arr));
			print("批量删除课程成功！");
			testForEach();
		} catch (Exception e) {
			e.printStackTrace();
			print("批量删除课程失败！");
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
		// 重复添加
		cs.addCourse(1, "数据结构");
		// 打印或遍历所有元素
//		cs.printAllCourses();
//		cs.testItetator();
		cs.testForEach();
		// 修改元素
		int modifyIndex = cs.coursesToSelect.size() - 1;
		cs.testModify(modifyIndex, new Course(7, "JavaScript"));
		cs.testItetator();
		// 删除元素
//		cs.testRemove(6);
		Course[] removeAllItems = { (Course) cs.coursesToSelect.get(4), (Course) cs.coursesToSelect.get(5) };
		cs.testRemoveAll(removeAllItems);
	}
}
