package com.test.collection;

import java.util.HashSet;
import java.util.Set;

public class Student2 {
	public String id;
	public String name;
	public Set<Course> courses;
	
	public Student2(String id, String name) {
		this.id = id;
		this.name = name;
		this.courses = new HashSet<Course>();
	}
}
