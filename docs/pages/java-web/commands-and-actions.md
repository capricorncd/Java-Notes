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



