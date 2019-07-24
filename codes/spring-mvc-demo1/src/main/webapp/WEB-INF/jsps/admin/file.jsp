<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>文件上传</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/main.css"/>
</head>
<body>
	<form action="<%=request.getContextPath() %>/courses/do-upload" method="post" enctype="multipart/form-data">
		<h1 class="course-title">文件上传</h1>
		<div>
			<input type="file" name="file">
		</ul>
		<button type="submit">上传</button>
	</form>
</body>
</html>