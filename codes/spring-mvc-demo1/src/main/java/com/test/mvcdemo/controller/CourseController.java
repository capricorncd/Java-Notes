package com.test.mvcdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.mvcdemo.model.Course;
import com.test.mvcdemo.service.CourseService;

@Controller
@RequestMapping("/courses")
// /courses/*
public class CourseController {
  
  private static Logger log = LoggerFactory.getLogger(CourseController.class);
  
  private CourseService courseService;
  
  @Autowired
  public void setCourseServiceImpl(CourseService courseService) {
    this.courseService = courseService;
  }
  
  // 本方法仅处理 /course/view?courseId=123
  @RequestMapping(value="/view", method=RequestMethod.GET)
  public String viewCourse(@RequestParam("courseId") Integer courseId, Model model) {
    
    log.debug("In viewCourse, courseId = {}", courseId);
    
    Course course = courseService.getCourseById(courseId);
    model.addAttribute(course);
    // 返回jsp的文件名
    return "course-overview";
  }
}
