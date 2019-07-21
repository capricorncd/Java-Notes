<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/main.css"/>
</head>
<body>
	<div id="Main">
		<div class="course-title">${course.title}</div>
		<div class="course-image">
			<img src="${course.imgPath}"/>
		</div>
		<ul>
			<li>学习人数：<em>${course.learningNum}</em></li>
			<li>课程时长：<em>${course.duration}</em>s</li>
			<li>课程难度：<em>${course.level}</em></li>
			<li>难度描述：<em>${course.levelDesc}</em></li>
			<li>课程介绍：<em>${course.desc}</em></li>
			<h3 class="chapter-catalog">课程提纲</h3>
			<ol>
				<c:forEach items="${course.chapterList}" var="chapter">
					<li class="clearfix">
						<div class="outline-list">
							<h5 class="outline-name">${chapter.title}</h5>
							<p class="outline-descr">${chapter.desc}</p>
						</div>
					</li>
				</c:forEach>
			</ol>
		</ul>
	</div>
</body>
</html>