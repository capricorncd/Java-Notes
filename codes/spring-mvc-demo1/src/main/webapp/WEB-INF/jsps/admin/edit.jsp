<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>添加课程</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/main.css"/>
</head>
<body>
	<form action="<%=request.getContextPath() %>/courses/save" method="post">
		<h1 class="course-title">添加课程</h1>
		<ul>
			<li>课程名称：<input type="text" name="title"></li>
			<li>封面图地址：<input type="text" name="imgPath"></li>
			<li>学习人数：<input type="text" name="learningNum"></li>
			<li>课程时长：<input type="text" name="duration"> s</li>
			<li>课程难度：
				<select name="level">
					<option value="1">初级</option>
					<option value="2" selected>中级</option>
					<option value="3">高级</option>
				</select>
			</li>
			<li>难度描述：<input type="text" name="levelDesc"></li>
			<li>课程介绍：<input type="text" name="desc"></li>
		</ul>
		<button type="submit">提交</button>
	</form>
</body>
</html>