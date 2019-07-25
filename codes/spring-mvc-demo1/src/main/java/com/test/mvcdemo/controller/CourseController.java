package com.test.mvcdemo.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
  
  // /courses/view2/{courseId}
  @RequestMapping(value="/view2/{courseId}", method=RequestMethod.GET)
  public String viewCourse2(@PathVariable("courseId") Integer courseId, Map<String, Object> model) {
    log.debug("In viewCourse2, courseId = {}", courseId);
    Course course = courseService.getCourseById(courseId);
    model.put("course", course);
    return "course-overview";
  }
  
  // /course/view?courseId=333
  @RequestMapping("view3")
  public String viewCourse3(HttpServletRequest request) {
    Integer courseId = Integer.valueOf(request.getParameter("courseId"));
    Course course = courseService.getCourseById(courseId);
    request.setAttribute("course", course);
    return "course-overview";
  }
  
  @RequestMapping(value="/admin", method=RequestMethod.GET, params="add")
  public String createCourse() {
    return "admin/edit";
  }
  
  // 接收处理表单数据
  @RequestMapping(value="/save", method=RequestMethod.POST)
//  public String doSave(Course course) {
  public String doSave(@ModelAttribute Course course) {
    
    log.debug("Info of Course");
    log.debug(ReflectionToStringBuilder.toString(course));
    
    System.out.println(course.toString());
    
    // 在此进行业务操作，比如数据库持久化
    course.setCourseId(555);
    return "redirect:view2/" + course.getCourseId();
  }
  
  @RequestMapping(value="/upload", method=RequestMethod.GET)
  public String showUploadPage() {
    return "admin/file";
  }
  
  @RequestMapping(value="/do-upload", method=RequestMethod.POST)
  public String doUploadFile(@RequestParam("file") MultipartFile file) throws IOException {
    
    if (!file.isEmpty()) {
      FileUtils.copyInputStreamToFile(file.getInputStream(), new File("D:/java/temp", System.currentTimeMillis() + "_" + file.getOriginalFilename()));
    }
    
    return "home";
  }
  
  @RequestMapping(value="/{courseId}", method=RequestMethod.GET)
  public @ResponseBody Course getCourseInJson(@PathVariable Integer courseId) {
    return courseService.getCourseById(courseId);
  }
  
  @RequestMapping(value="/json/{courseId}", method=RequestMethod.GET)
  public ResponseEntity<Course> getCourseInJson2(@PathVariable Integer courseId) {
    Course course = courseService.getCourseById(courseId);
    return new ResponseEntity<Course>(course, HttpStatus.OK);
  }
  
}
