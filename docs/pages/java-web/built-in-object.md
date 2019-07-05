# JSP内置对象

* 内置对象简介

* 四种作用域范围

* out

* request/response

* session

* application

* 其它内置对象

* 项目案例

### 内置对象简介

是Web容器创建的一组对象，不使用new关键字就可以使用的内置对象。

```
<%
int[] value = {50, 60, 70};
for (int i : value) {
  out.println(i);
}
%>
```

> [!TIP|style:flat|label:JSP九大内置对象]

> **常用内置对象**

> out, request, response, session, application

> **其它内置对象**

> Page, pageContext, exception, config

Web程序的请求响应模式：用户发送请求(request)，服务器给用户响应(response)。

### 什么是缓冲区

缓冲区(Buffer)，所属缓冲区就是内存的一块区域，用来保存临时数据。

### out对象

是JspWriter类的实例，是向客户端输出内容常用的对象。

**常用方法：**

void println() 向客户端打印字符串。

void clear() 清除缓冲区的内容。注意，如果在flush之后调用会抛出异常。

void clearBuffer() 清除缓冲区的内容，不会向客户端输出任何内容。在flush之后调用不会抛出异常。

void flush() 将缓冲区内容输出到客户端。

int getBufferSize() 获取缓冲区字节数的大小，如不设置缓冲区则为0。

int getRemaining() 获取缓冲区剩余可用字节大小（可用空间）。

boolean isAutoFlush() 返回缓冲区满时，是自动清空还是抛出异常。

void close() 关闭输出流。

```
<body>
  <h1>out内置对象</h1>
  <%
    out.println("<h2>静夜思</h2>");
    out.println("床前明月光<br>");
    out.println("疑是地上霜<br>");
    out.println("举头望明月<br>");
    out.println("低头思故乡<br><br>");
  %>
  缓冲区大小：<%=out.getBufferSize() %>byte<br>
  缓冲区剩余空间：<%=out.getRemaining() %>byte<br>
  是否自动清空缓冲区：<%=out.isAutoFlush() %><br>
</body>
```

结果：

```
静夜思
床前明月光
疑是地上霜
举头望明月
低头思故乡

缓冲区大小：8192byte
缓冲区剩余空间：7513byte
是否自动清空缓冲区：true
```

使用 `out.flush()`

```
<body>
  <h1>out内置对象</h1>
  <%
    out.println("<h2>静夜思</h2>");
    out.println("床前明月光<br>");
    out.flush();
    out.println("疑是地上霜<br>");
    out.println("举头望明月<br>");
    out.println("低头思故乡<br><br>");
  %>
  缓冲区大小：<%=out.getBufferSize() %>byte<br>
  缓冲区剩余空间：<%=out.getRemaining() %>byte<br>
  是否自动清空缓冲区：<%=out.isAutoFlush() %><br>
</body>
```

结果：注意`缓冲区剩余空间`的值

```
静夜思
床前明月光
疑是地上霜
举头望明月
低头思故乡

缓冲区大小：8192byte
缓冲区剩余空间：8126byte
是否自动清空缓冲区：true
```

### get 与 post

```html
<form name="regForm" action="动作" method="GET或POST"></form>
```

```html
<body>
    <h2>GET</h2>
    <form action="logindo.jsp" method="get">
    	<p>用户名: <input type="text" name="username"></p>
    	<p>密 &nbsp;&nbsp;码: <input type="password" name="password"></p>
    	<p><input type="submit" value="登 录"></p>
    </form>
    <hr>
    
    <h2>POST</h2>
    <form action="logindo.jsp" method="post">
    	<p>用户名: <input type="text" name="username"></p>
    	<p>密 &nbsp;&nbsp;码: <input type="password" name="password"></p>
    	<p><input type="submit" value="登 录"></p>
    </form>
</body>
```

### request/response

> [!TIP|style:flat|label:request对象]

> 客户端的请求信息被封装在request对象中，通过它才能了解到客户端的需求，然后做出响应。

> 它是HttpServletRequest类的实例。

> 具有请求域，即完成客户端的请求之前，该对象一直有效。

常用方法如下：

String getParameter(String name) 返回name指定参数的值

String[] getParameterValues(String name) 返回包含参数name的所有值得数组

void setAttribute(String name, Object obj); 存储此请求中的属性。

Object getAttribute(String name) 返回指定属性的属性值

String getContentType() 得到请求体的MIME类型

String getProtocol() 获取请求用的协议类型及版本号

String getServerName() 返回接受请求的服务器主机名

```
<body>
    <h2>注册</h2>
    <form action="regdo.jsp" method="post">
    	<p>用户名: <input type="text" name="username"></p>
    	<p>
    		<label><input type="checkbox" name="favorite" value="读书"> 读书</label>
    		<label><input type="checkbox" name="favorite" value="写字"> 写字</label>
    		<label><input type="checkbox" name="favorite" value="看电影"> 看电影</label>
    		<label><input type="checkbox" name="favorite" value="音乐"> 音乐</label>
    		<label><input type="checkbox" name="favorite" value="跑步"> 跑步</label>
    		<label><input type="checkbox" name="favorite" value="旅游"> 旅游</label>
		</p>
    	<p><input type="submit" value="提 交"></p>
    </form>
    <hr>
    <a href="regdo.jsp?username=测试URL传参username">测试URL传参</a>
    
</body>
```

regdo.jsp

```
<body>
    <%
    	// post中文乱码处理，编码转换
    	request.setCharacterEncoding("utf-8");
    %>
    <p>用户名：<%=request.getParameter("username") %></p>
    <p>爱好：<%
    	// 空指针会抛出异常
    	if (request.getParameterValues("favorite") != null) {
	    	String[] favorites = request.getParameterValues("favorite");
	    	for (int i = 0; i < favorites.length; i++) {
	    		out.println(favorites[i] + "、");
	    	}
    	}
    %></p>
</body>
```

> [!WARNING|style:flat|label:注意]

> 通过URL传参中文乱码问题，可以在tomcat/conf/server.xml中设置编码。

```
<Connector port="8080" protocol="HTTP/1.1"
               connectionTimeout="20000"
               redirectPort="8443"
               URIEncoding="utf-8"/>
```

### 四种作用域范围

### session

### application

### 其它内置对象

### 项目案例