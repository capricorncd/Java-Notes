package com.test.mvcdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.test.mvcdemo.model.Chapter;
import com.test.mvcdemo.model.Course;

@Service("courseService")
public class CourseServiceImpl implements CourseService {

  public Course getCourseById(Integer courseId) {
    Course course = new Course();
    
    course.setCourseId(courseId);
    course.setTitle("测试Java MVC标题");
    course.setImgPath("http://tuchong.pstatp.com/1000000/f/273942758.jpg");
    course.setLearningNum(51122);
    course.setLevel(2);
    course.setLevelDesc("中级");
    course.setDuration(7200l);
    course.setDesc("总之是介绍，一句话说不完可以说两句");
    
    List<Chapter> chapterList = new ArrayList<Chapter>();
    
    warpChaterList(courseId, chapterList);
    
    course.setChapterList(chapterList);
    
    return course;
  }

  private void warpChaterList(Integer courseId, List<Chapter> chapterList) {
    Chapter chapter = new Chapter();
    chapter.setId(1);
    chapter.setCourseId(courseId);
    chapter.setOrder(1);
    chapter.setTitle("第1章 多线程背景知识介绍");
    chapter.setDesc("本章将介绍与多线程编程相关的背景概念");
    chapterList.add(chapter);
    
    chapter = new Chapter();
    chapter.setId(2);
    chapter.setCourseId(courseId);
    chapter.setOrder(2);
    chapter.setTitle("第2章 多线程背景知识介绍");
    chapter.setDesc("为视区别，balbalbabalblalb，本章将介绍与多线程编程相关的背景概念");
    chapterList.add(chapter);
  }

}
