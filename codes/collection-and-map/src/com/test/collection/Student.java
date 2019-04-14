package com.test.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * 学生类
 * @author capricorncd
 *
 */
public class Student implements Comparable<Student> {
	public int id;
	public String name;
	public Set<Course> courses;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Student))
			return false;
		Student other = (Student) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	public Student (int id, String name) {
		this.id = id;
		this.name = name;
		//  初始化
		this.courses = new HashSet<Course>();
	}

	@Override
	public int compareTo(Student o) {
		// String
		// return this.name.compareTo(o.name);
		return this.id - o.id;
	}
}
