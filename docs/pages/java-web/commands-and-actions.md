# 指令与动作

* include指令、include动作，及二者的区别

* jsp:forward动作

* jsp:param动作

* jsp:plugin动作

### include指令

```jsp
<%@ include file="PATH"%>
```

### include动作

```jsp
<jsp:include page="PATH" flush="true|false"/>
# flush 被包含的页面是否从缓冲区读取
```

||include指令|include动作|
|:--|:--|:--|
|语法格式|(见上面)|(见上面)|
|发生作用的时间|页面转换期间|请求期间|
|包含的内容|文件的实际内容|页面的输出|
|转换成的Servlet|主页面和包含页面转换为一个Servlet|主页面和包含页面转换为独立的Servlet|
|编译时间|较慢，资源必须被解析|较快|
|执行时间|稍快|较慢，每次资源必须被解析|

**总结**：页面内容经常变化时，更适合使用**\<jsp:include>动作**；不经常变化时，更适合使用**include指令**；**\<jsp:include>动作**包含的是执行结果，而**include指令**包含的是文件内容。

### jsp:forward动作

语法：

```jsp
<jsp:forward page="URL" />
```

等同于：

```jsp
<!-- 服务器转发 -->
request.getRequestDispatcher("/url").forward(request, response);
```

### jsp:param动作

语法：

```jsp
<jsp:param page="参数名" value="参数值" />
```

常与 `<jsp:forward>` 一起使用，作为其的子标签。

```jsp
<jsp:forward page="URL">
    <!-- 新增一个参数emial -->
    <jsp:param value="admin@xxxx.com" name="email" />
</jsp:forward>
```

### jsp:plugin动作

略

### 商品浏览记录实例

/jsp-commands-and-actions/WebContent/index.jsp

```jsp
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
```

/jsp-commands-and-actions/WebContent/detail.jsp

```jsp
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
```
/jsp-commands-and-actions/src/com/jspcommands/util/DBHelper.java

```java
package com.jspcommands.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
  // 数据库驱动
  // private static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
  private static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver"; //驱动
  // 连接数据库的URL地址
  // private static final String DB_URL = "jdbc:mysql://localhost:3306/shopping?useUnicode=true&charaterEncoding=UTF-8";
  private static final String DB_URL = "jdbc:oracle:thin:@//127.0.0.1:1521/orcl";
  // 数据库用户名
  private static final String USER_NAME = "system";
  // 数据库密码
  private static final String PASSWORD = "admin";
  // 
  private static Connection conn = null;
  
  // 静态代码块负责加载驱动
  static
  {
    try {
      Class.forName(ORACLE_DRIVER);
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  // 单列模式返回数据库连接对象
  public static Connection getConnection() {
    if (conn == null) {
      try {
        conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    return conn;
  }
  
  public static void main(String[] args) {
    try {
      Connection conn = DBHelper.getConnection();
      if (conn != null) {
        System.out.println("数据库连接成功!");
      } else {
        System.out.println("数据库连接失败!");
      }
    } catch(Exception e) {
      System.out.println("数据库连接失败，发生异常：");
      e.printStackTrace();
    }
  }
}
```

/jsp-commands-and-actions/src/com/jspcommands/dao/JspCookieItemDAO.java

```java
package com.jspcommands.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.jspcommands.entity.JspCookieItem;
import com.jspcommands.util.DBHelper;

// 商品业务逻辑类
public class JspCookieItemDAO {
  // 获取所有商品列表
  public ArrayList<JspCookieItem> getAllItems() {
    Connection conn = null;
    PreparedStatement stat = null;
    ResultSet rs = null;
    
    ArrayList<JspCookieItem> list = new ArrayList<JspCookieItem>();
    
    // System.out.println("=============ArrayList下面尝试获取数据");
    
    try {
      conn = DBHelper.getConnection();
      String sql = "select * from jsp_cookie_items";
      stat = conn.prepareStatement(sql);
      rs = stat.executeQuery();
      // System.out.println("=============执行try");
      while(rs.next()) {
        JspCookieItem item = new JspCookieItem();
        item.setId(rs.getInt("id"));
        item.setName(rs.getString("name"));
        item.setCity(rs.getString("city"));
        item.setPrice(rs.getDouble("price"));
        item.setStock(rs.getInt("stock"));
        item.setCover(rs.getString("cover"));
        System.out.println("=========while循环中: " + rs.getString("name"));
        list.add(item);
      }
      return list;
    } catch(Exception ex) {
      ex.printStackTrace();
    } finally {
      // 释放数据集对象
      if (rs != null) {
        try {
          rs.close();
          rs = null;
        } catch(Exception ex) {
          ex.printStackTrace();
        }
      }
      // 释放语句对象
      if (stat != null) {
        try {
          stat.close();
          stat = null;
        } catch(Exception ex) {
          ex.printStackTrace();
        }
      }
    }
    
    return null;
  }
  
  /**
   * 获取商品详情
   * @param id
   * @return
   */
  public JspCookieItem getDetailById(int id) {
    Connection conn = null;
    PreparedStatement stat = null;
    ResultSet rs = null;
    try {
      conn = DBHelper.getConnection();
      String sql = "select * from jsp_cookie_items where id=?";
      stat = conn.prepareStatement(sql);
      stat.setInt(1, id);
      rs = stat.executeQuery();
      // System.out.println("=============执行try");
      if(rs.next()) {
        JspCookieItem item = new JspCookieItem();
        item.setId(rs.getInt("id"));
        item.setName(rs.getString("name"));
        item.setCity(rs.getString("city"));
        item.setPrice(rs.getDouble("price"));
        item.setStock(rs.getInt("stock"));
        item.setCover(rs.getString("cover"));
        return item;
      }
    } catch(Exception ex) {
      ex.printStackTrace();
    } finally {
      // 释放数据集对象
      if (rs != null) {
        try {
          rs.close();
          rs = null;
        } catch(Exception ex) {
          ex.printStackTrace();
        }
      }
      // 释放语句对象
      if (stat != null) {
        try {
          stat.close();
          stat = null;
        } catch(Exception ex) {
          ex.printStackTrace();
        }
      }
    }
    
    return null;
  }
  
  /**
   * get 获取最近浏览的5条记录
   * @param records
   * @return
   */
  public ArrayList<JspCookieItem> getViewList(String records) {
    ArrayList<JspCookieItem> list = new ArrayList<JspCookieItem>();
    if (records != null && records.length() > 0) {
      String[] arr = records.split("#");
      int id;
      for (int i = arr.length - 1; i >= 0; i--) {
        id = arr[i] != "" ? Integer.parseInt(arr[i]) : 0;
        if (id > 0) list.add(getDetailById(id));
      }
    }
    return list;
  }
}
```

/jsp-commands-and-actions/src/com/jspcommands/entity/JspCookieItem.java

```java
package com.jspcommands.entity;

// 商品实体类
public class JspCookieItem {
  private int id;
  private String name;
  private String city;
  private Double price;
  private int stock;
  private String cover;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  public String getCover() {
    return cover;
  }

  public void setCover(String cover) {
    this.cover = cover;
  }
}
```

源码位置：

```
codes/jsp-commands-and-actions
```
