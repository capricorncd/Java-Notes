<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.jspcommands.entity.JspCookieItem"%>
<%@ page import="com.jspcommands.dao.JspCookieItemDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>案例：商品浏览记录的实现</title>
</head>
<body>
	<h1>采用Model1(JSP + JavaBean)实现</h1>
	<ul>
		<li>实现DBHelper类</li>
		<li>创建实体类</li>
		<li>创建业务逻辑类(DAO)，即JavaBeans</li>
		<li>创建页面层</li>
	</ul>
	<h2>商品列表：</h2>
	<%
	  JspCookieItemDAO jspCookieItemDao = new JspCookieItemDAO();
	  ArrayList<JspCookieItem> list = jspCookieItemDao.getAllItems();
	  if (list.size() == 0) {
	    out.print("数据为空！");
	  }
	%>
	<dl>
		<%
		  for (int i = 0; i < list.size(); i++) {
		    JspCookieItem item = list.get(i);
		%>
		<dd style="float:left;width:200px;">
			<a href="detail.jsp?id=<%=item.getId()%>" target="_blank">
				<h3 style="margin-bottom:5px;"><%=item.getName()%></h3>
				<div>
					<img src="<%=item.getCover()%>" height="80">
				</div>
				<div>价格：<%=item.getPrice()%></div>
				<div>产地：<%=item.getCity()%></div>
				<div>库存：<%=item.getStock()%></div>
			</a>
		</dd>
		<%
		  }
		%>
	</dl>
</body>
</html>