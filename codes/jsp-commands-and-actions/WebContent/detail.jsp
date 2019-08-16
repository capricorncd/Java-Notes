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
	<%
	  JspCookieItemDAO jspCookieItemDao = new JspCookieItemDAO();
	  JspCookieItem item = jspCookieItemDao.getDetailById(Integer.parseInt(request.getParameter("id")));
	  if (item != null) {
	%>
	<dl>
		<dd>
			<h1><%=item.getName()%></h1>
		</dd>
		<dd>
			<p>
		价格：<%=item.getPrice()%>
				| 产地：<%=item.getCity()%>
				| 库存：<%=item.getStock()%>
				</p>
		</dd>
		<dd><img src="<%=item.getCover()%>" style="max-width:400px"></dd>
	</dl>
	<%
	  } else {
	  	out.println("无相关商品信息");
	  }
	%>
</body>
</html>