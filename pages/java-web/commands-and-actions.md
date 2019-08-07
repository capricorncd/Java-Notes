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

### jsp:forward动作

```jsp
<jsp:forward page="URL" />
```

等同于：

```jsp
<!-- 转发 -->
request.getRequestDispatcher("/url").forward(request, response);
```


### jsp:param动作

### jsp:plugin动作