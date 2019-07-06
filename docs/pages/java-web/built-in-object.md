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

常用方法：

**void println()** 向客户端打印字符串。

**void clear()** 清除缓冲区的内容。注意，如果在flush之后调用会抛出异常。

**void clearBuffer()** 清除缓冲区的内容，不会向客户端输出任何内容。在flush之后调用不会抛出异常。

**void flush()** 将缓冲区内容输出到客户端。

**int getBufferSize()** 获取缓冲区字节数的大小，如不设置缓冲区则为0。

**int getRemaining()** 获取缓冲区剩余可用字节大小（可用空间）。

**boolean isAutoFlush()** 返回缓冲区满时，是自动清空还是抛出异常。

**void close()** 关闭输出流。

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

### request对象

> [!TIP|style:flat|label:request对象]

> 客户端的请求信息被封装在request对象中，通过它才能了解到客户端的需求，然后做出响应。

> 它是HttpServletRequest类的实例。

> 具有请求域，即完成客户端的请求之前，该对象一直有效。

常用方法如下：

**String getParameter(String name)** 返回name指定参数的值

**String[] getParameterValues(String name)** 返回包含参数name的所有值得数组

**void setAttribute(String name, Object obj);** 存储此请求中的属性。

**Object getAttribute(String name)** 返回指定属性的属性值

**String getContentType()** 得到请求体的MIME类型

**String getProtocol()** 获取请求用的协议类型及版本号

**String getServerName()** 返回接受请求的服务器主机名

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

```
<%
    // void setAttribute(String name, Object obj);
    request.setAttribute("password", "123456789");
%>
<%
    // Object getAttribute(String name)
%>
<%=request.getAttribute("password") %>
```

其他方法及结果

```
# 方法 结果
getContentType null

getProtocol HTTP/1.1

getServerName localhost

getServerPort 8080

getContentLength -1

getRemoteAddr 0:0:0:0:0:0:0:1

getRealPath D:\Java\tomcat9\webapps\www\index.jsp

getContextPath /www

getScheme http
```

### response对象

> [!TIP|style:flat|label:response对象]

> response对象包含了响应客户端请求的相关信息，但在JSP中很少直接用到它。它是HttpServletResponse类的实例。

> response对象具有页面作用域，即访问一个页面时，该页面内的response对象只能对这次访问有效。其他页面的response对象对当前页面无效。

常用方法：

**String getCharacterEncoding()** 返回响应应用的是何种字符编码

**void setContentType(String type)** 设置响应的MIME类型

**PrintWriter getWriter()** 返回可以向客户端输出字符的一个对象（注意比较PrintWriter与内置out对象的区别）

> [!WARNING|style:flat|label:区别]

> PrintWriter outer = response.getWriter();

> 默认情况下，outer.println()该对象输出的内容，总是在内置对象out.println()之前。

> 可以通过 `out.flush()` 方法，实现按文档流输出。（见代码部分）

**sendRedirect(java.lang.String location)** 重新定向客户端的请求

response.jsp

```
<%@ page language="java" import="java.util.*,java.io.*" pageEncoding="UTF-8"%>
<%
	response.setContentType("text/html; charset=utf-8");
	
	out.println("<h2>response内置对象</h2>");
	out.println("<hr>");
	
	PrintWriter outer = response.getWriter();
	outer.println("这是response.getWriter()对象输出流");
%>
```

结果：

```
这是response.getWriter()对象输出流

<h2>response内置对象</h2>
<hr>
```

通过 `out.flush()` 方法，实现按文档流输出

```
<%@ page language="java" import="java.util.*,java.io.*" pageEncoding="UTF-8"%>
<%
	response.setContentType("text/html; charset=utf-8");
	
	out.println("<h2>response内置对象</h2>");
	out.println("<hr>");
	out.flush();
	
	PrintWriter outer = response.getWriter();
	outer.println("这是response.getWriter()对象输出流");
%>
```

结果：

```
<h2>response内置对象</h2>
<hr>
这是response.getWriter()对象输出流
```

### 请求重定向和请求转发

|名称|区别|
|:--|:--|
|请求重定向|客户端行为，response.sendRedirect()，从本质将等同于两次请求。前一次的请求对象不会保存，地址栏的URL会改变为定向地址。|
|请求转发|服务器行为，request.getRequestDispatcher().forward(req, res)。是一次请求，转发后请求对象会保存，URL地址不会改变。|

### session

> [!TIP|style:flat|label:session]

> session表示客户端与服务端的一次会话。

> Web中的session指的是用户在浏览某个网站时，从进入网站到浏览器关闭所经过的这段时间，也就是用户浏览这个网站所花费的时间。

> 从上述定义中可以看到，session实际上是一个特定的时间概念。

> 在服务器内存中，保存着不同用户(客户端)的session

![session-shopping](img/session-shopping.jpg)

在服务器内存中，保存着不同用户的session。

![session-server](img/session-server.jpg)

> [!COMMENT|style:flat|label:session对象]

> 是一个JSP内置对象

> 在第一个JSP页面被装载时自动创建，完成会话期管理。

> 从一个客户打开浏览器并连接到服务器开始，到客户关闭浏览器离开这个服务器结束，被称为**一个会话**。

> 当一个客户访问一个服务器时，可能会在服务器的几个页面之间切换，服务器应当通过某种办法知道这是一个客户，就需要session对象。

> session对象时HttpSession类的实例

session对象常用方法：

**long getCreationTime()** 返回SESSION创建时间（单位毫秒）

**public String getId()** 返回SESSION创建时JSP引擎为它设的唯一ID值

**public Object setAttribute(String name, Object value)** 使用指定名称将对象绑定到此会话

**public Object getAttribute(String name)** 返回与此会话中的指定名称绑定在一起的对象，如果没有则返回null

**String[] getValueNames()** 返回一个包含此SESSION中所有可能属性的数组

**void setMaxInactiveInterval(int second)** 设置SESSION过期时间(单位秒)

**int getMaxInactiveInterval()** 返回两次请求间隔多长时间此SESSION被取消(单位秒)，即SESSION过期时间

```
<body>
    <dl>
    	<dt>session内置对象</dt>
    	<%
    		long sessionCreatedMsec = session.getCreationTime();
    		// 转换为包装类，方法使用其方法获取字符串长度
    		Long scm = new Long(sessionCreatedMsec);
    		// 日期格式化
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		// 创建日期对象，接收长整型参数
    		Date d = new Date(sessionCreatedMsec);
    		// session中设置自定义属性
    		session.setAttribute("username", "master");
    	%>
    	<dd>getId: <%=session.getId() %></dd>
    	<dd>Session创建时间：<%=sessionCreatedMsec %>毫秒</dd>
    	<dd>时间长度：<%=scm.toString().length() %>位</dd>
    	<dd>格式化后的时间：<%=sdf.format(d) %></dd>
    	<dd>获取自定义属性：<%=session.getAttribute("username") %></dd>
    </dl>
</body>
```

结果：

```
session内置对象
getId: FBBE1BF8A1502240D4DC31EED0BD5EBA
Session创建时间：1562411220284毫秒
时间长度：13位
格式化后的时间：2019-07-06 20:07:00
获取自定义属性：master
```

**session的生命周期**

* 创建：

客户端第一次访问当前网站某个jsp或Servlet的时候，服务器会为当前会话创建一个SessionId。客户端每次向服务器发送请求时，都会带上此SessionId，服务器端会对该SessionId进行校验。

* 活动：

某次会话当中，通过超链接打开的同域新页面，则属于同一次会话。

只要当前会话页面没有全部关闭，重新打开新的浏览器窗口访问同一个项目资源时属于同一次会话。

除非本次会话的所有页面都关闭后，再重新访问某个Jsp或者Servlet将会创建新的会话。

注意：旧的Session仍然存在于服务器内存当中

* 销毁

Session的销毁有3种方式：

1. 调用session.invalidate()方法

2. Session过期

3. 服务器重启（？相当于清空内存）

Tomcat web.xml中配置过期时间：(默认为30分钟)

```
<session-config>
    <session-timeout>30</session-timeout>
</session-config>
```

### application

* application 对象实现了用户间数据的共享，可以存放全局变量

* application开始于服务器的启动，终止于服务器的关闭

* 在用户的前后连接或不同用户之间的连接中，可以对application对象的同一属性进行操作。

* 在任何地方对application对象属性的操作，都将影响到其他用户对此的访问。

* 服务器的启动和关闭决定了application对象的生命周期

* application对象是ServletContext类的实例

**常用方法**

**public void setAttribute(String name, Object value)** 设置属性及值

**public Object getAttribute(String name)** 获取属性值，无则返回null

**Enumeration getAttributeNames()** 返回所有可用属性名的枚举

**String getServerInfo()** 返回JSP（Servlet）引擎及版本号

```
<body>
    <h1>APPLICATION</h1>
   	<%
   		application.setAttribute("PROJECT_NAME", "TEST_SERVER");
   		application.setAttribute("systemName", "JSP_SERVER");
   		application.setAttribute("systemEmail", "admin@xxx.com");
   	%>
   	<p>gePROJECT_NAME: <%=application.getAttribute("PROJECT_NAME") %></p>
   	<h2>所有属性：</h2>
   	<p><%
   	Enumeration attrs = application.getAttributeNames();
   	while(attrs.hasMoreElements()) {
   		out.println(attrs.nextElement() + "&nbsp;&nbsp;&nbsp;&nbsp;");
   	}
   	%></p>
   	<p>getServerInfo：<%=application.getServerInfo() %></p>
</body>
```

结果：

```
APPLICATION
gePROJECT_NAME: TEST_SERVER

所有属性：
javax.servlet.context.tempdir     systemEmail     org.apache.catalina.resources     com.sun.faces.config.WebConfiguration     org.apache.tomcat.InstanceManager     org.apache.catalina.jsp_classpath     org.apache.jasper.compiler.ELInterpreter     org.apache.jasper.compiler.TldCache     PROJECT_NAME     org.apache.tomcat.JarScanner     systemName     javax.websocket.server.ServerContainer     org.apache.jasper.runtime.JspApplicationContextImpl    

getServerInfo：Apache Tomcat/9.0.20
```

### page对象

### 四种作用域范围



### 其它内置对象

### 项目案例