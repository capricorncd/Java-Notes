package com.test.mvcdemo.service;

import org.springframework.stereotype.Service;

import com.test.mvcdemo.model.Course;

@Service
public interface CourseService {
  public Course getCourseById(Integer courseId);
}
