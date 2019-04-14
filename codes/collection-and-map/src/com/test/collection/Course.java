package com.test.collection;

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
	// [Implicit super constructor Course() is undefined for default constructor. Must define an explicit constructor]
	public Course() {
		
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Course))
			return false;
		Course course = (Course) obj;
		if (this.name == null) {
			return course.name == null;
		} else {
			return this.name.equals(course.name);
		}
	}
}
