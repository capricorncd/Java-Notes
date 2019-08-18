<%@ page language="java" import="java.util.*, java.lang.String"
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
<%!
String[] slice(String[] arr, int index, int sliceLength) {
  int len = arr.length;
  if (index < 0 || len == 0 || index >= len) {
    return arr;
  }
  int end = Math.min(sliceLength + index, len);
  String[] list = new String[Math.min(sliceLength, len - index)];
  for (int i = index, j = 0; i < end; i++, j++) {
    list[j] = arr[i];
  }
  return list;
}

String[] push(String[] arr, String str) {
  int len = arr.length;
  String[] newArr = new String[len + 1];
  for (int i = 0; i < len; i++) {
    newArr[i] = arr[i];
  }
  newArr[len] = str;
  return newArr;
}

String toString(String[] arr, String connector) {
  String str = "";
  for (String s:arr) {
    str += s + connector;
  }
  return str.substring(0, str.length() - 1);
}

String checkStr(String str) {
  String newStr = "";
  String tmp;
  for (int i = 0; i < str.length(); i++) {
    tmp = str.substring(i, i + 1);
    if (i == 0 && tmp.indexOf("#") == 0) continue;
    newStr += tmp;
  }
  return newStr;
}
%>
	<%
	  JspCookieItemDAO jspCookieItemDao = new JspCookieItemDAO();
	  String id = request.getParameter("id");
	  JspCookieItem item = id != null && id != "" ? jspCookieItemDao.getDetailById(Integer.parseInt(id)) : null;
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
	<%
	String records = "";
	// 从客户端获取Cookie集合
	Cookie[] cookies = request.getCookies();
	// 遍历集合
	if (cookies != null) {
	  for (Cookie c:cookies) {
		if (c.getName().equals("recordsCookie")) {
		  records = checkStr(c.getValue());
		  out.println("getCookies: " + records + "<br>");
		}
	  }
	}
	// records += request.getParameter("id") + ",";
	// String id = request.getParameter("id");
	// 转换为数组
	String[] arr = records.split("#");
	int len = arr[0] != null && arr[0] != "" ? arr.length : 0;
	// 判断记录是否已存在
	if (id != null && !Arrays.asList(arr).contains(id)) {
	  //判断记录条数
	  String[] tmp = push(slice(arr, len - 4, 5), id);
	  // 保存Cookie
	  // 注意(使用逗号','作为字符串分隔符，jdk1.8中cookie会抛出以下异常：)
	  // java.lang.IllegalArgumentException: An invalid character [44] was present in the Cookie value
	  Cookie cookie = new Cookie("recordsCookie", toString(tmp, "#"));
	  // 最大有效时间
	  cookie.setMaxAge(24 * 3600 * 30);
	  // cookie.setPath("/");
	  response.addCookie(cookie);
	}
	%>
	
	<h2>最近浏览商品列表：</h2>
	<%
	  ArrayList<JspCookieItem> list = jspCookieItemDao.getViewList(records);
	  if (list.size() == 0) {
	    out.print("无浏览记录！");
	  } else {
	%>
	<dl>
		<%
		  for (int i = 0; i < list.size(); i++) {
		    JspCookieItem cookieItem = list.get(i);
		%>
		<dd style="float:left;width:200px;">
			<a href="detail.jsp?id=<%=cookieItem.getId()%>" target="_blank">
				<h3 style="margin-bottom:5px;"><%=cookieItem.getName()%></h3>
				<div>
					<img src="<%=cookieItem.getCover()%>" height="80">
				</div>
				<div>价格：<%=cookieItem.getPrice()%></div>
				<div>产地：<%=cookieItem.getCity()%></div>
				<div>库存：<%=cookieItem.getStock()%></div>
			</a>
		</dd>
		<%
		  }
	  }
		%>
	</dl>
	<div style="margin-bottom: 20px; clear:both;"></div>
</body>
</html>