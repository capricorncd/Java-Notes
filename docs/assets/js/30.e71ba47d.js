(window.webpackJsonp=window.webpackJsonp||[]).push([[30],{313:function(s,t,e){"use strict";e.r(t);var a=e(10),n=Object(a.a)({},(function(){var s=this,t=s._self._c;return t("ContentSlotsDistributor",{attrs:{"slot-key":s.$parent.slotKey}},[t("h1",{attrs:{id:"jsp状态管理"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#jsp状态管理"}},[s._v("#")]),s._v(" Jsp状态管理")]),s._v(" "),t("ul",[t("li",[t("p",[s._v("http协议无状态性")])]),s._v(" "),t("li",[t("p",[s._v("保存用户状态的两大机制")])]),s._v(" "),t("li",[t("p",[s._v("Cookie简介")])]),s._v(" "),t("li",[t("p",[s._v("Cookie的创建与使用")])]),s._v(" "),t("li",[t("p",[s._v("Session与Cookie的对比")])])]),s._v(" "),t("h3",{attrs:{id:"http协议无状态性"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#http协议无状态性"}},[s._v("#")]),s._v(" http协议无状态性")]),s._v(" "),t("p",[s._v("无状态是指，当浏览器发送请求给服务器，服务器响应浏览器请求；但当同一个浏览器再次发送请求给该服务器时，服务器并不知道它就是之前那个浏览器；简单讲就是服务器不会去记得你，所以就是无状态协议。")]),s._v(" "),t("p",[t("img",{attrs:{src:"/img/http-no-state-example.jpg",alt:"http-no-state-example"}})]),s._v(" "),t("h3",{attrs:{id:"保存用户状态的两大机制"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#保存用户状态的两大机制"}},[s._v("#")]),s._v(" 保存用户状态的两大机制")]),s._v(" "),t("ul",[t("li",[t("p",[s._v("Session")])]),s._v(" "),t("li",[t("p",[s._v("Cookie")])])]),s._v(" "),t("h3",{attrs:{id:"cookie简介"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#cookie简介"}},[s._v("#")]),s._v(" Cookie简介")]),s._v(" "),t("div",{staticClass:"custom-block tip"},[t("p",{staticClass:"custom-block-title"},[s._v("Cookie")]),s._v(" "),t("p",[s._v("Cookie（译：小甜饼），是Web服务器保存在客户端的一系列文本信息。\n典型应用：判断注册用户是否已经登录网站；购物车的处理等。")])]),s._v(" "),t("p",[t("strong",[s._v("作用")]),s._v("：")]),s._v(" "),t("p",[s._v("对特定对象的追踪；保存用户网页浏览记录与习惯；简化登录...")]),s._v(" "),t("p",[t("strong",[s._v("安全风险")]),s._v("：容易泄露用户信息")]),s._v(" "),t("h3",{attrs:{id:"cookie的创建与使用"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#cookie的创建与使用"}},[s._v("#")]),s._v(" Cookie的创建与使用")]),s._v(" "),t("p",[s._v("创建Cookie对象：")]),s._v(" "),t("div",{staticClass:"language-java line-numbers-mode"},[t("pre",{pre:!0,attrs:{class:"language-java"}},[t("code",[t("span",{pre:!0,attrs:{class:"token class-name"}},[s._v("Cookie")]),s._v(" cookie "),t("span",{pre:!0,attrs:{class:"token operator"}},[s._v("=")]),s._v(" "),t("span",{pre:!0,attrs:{class:"token keyword"}},[s._v("new")]),s._v(" "),t("span",{pre:!0,attrs:{class:"token class-name"}},[s._v("Cookie")]),t("span",{pre:!0,attrs:{class:"token punctuation"}},[s._v("(")]),t("span",{pre:!0,attrs:{class:"token class-name"}},[s._v("String")]),s._v(" key"),t("span",{pre:!0,attrs:{class:"token punctuation"}},[s._v(",")]),s._v(" "),t("span",{pre:!0,attrs:{class:"token class-name"}},[s._v("Object")]),s._v(" value"),t("span",{pre:!0,attrs:{class:"token punctuation"}},[s._v(")")]),t("span",{pre:!0,attrs:{class:"token punctuation"}},[s._v(";")]),s._v("\n")])]),s._v(" "),t("div",{staticClass:"line-numbers-wrapper"},[t("span",{staticClass:"line-number"},[s._v("1")]),t("br")])]),t("p",[s._v("写入Cookie对象：")]),s._v(" "),t("div",{staticClass:"language-java line-numbers-mode"},[t("pre",{pre:!0,attrs:{class:"language-java"}},[t("code",[s._v("response"),t("span",{pre:!0,attrs:{class:"token punctuation"}},[s._v(".")]),t("span",{pre:!0,attrs:{class:"token function"}},[s._v("addCookie")]),t("span",{pre:!0,attrs:{class:"token punctuation"}},[s._v("(")]),s._v("cookie"),t("span",{pre:!0,attrs:{class:"token punctuation"}},[s._v(")")]),t("span",{pre:!0,attrs:{class:"token punctuation"}},[s._v(";")]),s._v("\n")])]),s._v(" "),t("div",{staticClass:"line-numbers-wrapper"},[t("span",{staticClass:"line-number"},[s._v("1")]),t("br")])]),t("p",[s._v("读取Cookie对象：")]),s._v(" "),t("div",{staticClass:"language-java line-numbers-mode"},[t("pre",{pre:!0,attrs:{class:"language-java"}},[t("code",[t("span",{pre:!0,attrs:{class:"token class-name"}},[s._v("Cookie")]),t("span",{pre:!0,attrs:{class:"token punctuation"}},[s._v("[")]),t("span",{pre:!0,attrs:{class:"token punctuation"}},[s._v("]")]),s._v(" cookie "),t("span",{pre:!0,attrs:{class:"token operator"}},[s._v("=")]),s._v(" request"),t("span",{pre:!0,attrs:{class:"token punctuation"}},[s._v(".")]),t("span",{pre:!0,attrs:{class:"token function"}},[s._v("getCookies")]),t("span",{pre:!0,attrs:{class:"token punctuation"}},[s._v("(")]),t("span",{pre:!0,attrs:{class:"token punctuation"}},[s._v(")")]),t("span",{pre:!0,attrs:{class:"token punctuation"}},[s._v(";")]),s._v("\n")])]),s._v(" "),t("div",{staticClass:"line-numbers-wrapper"},[t("span",{staticClass:"line-number"},[s._v("1")]),t("br")])]),t("table",[t("thead",[t("tr",[t("th",{staticStyle:{"text-align":"left"}},[s._v("常用方法")]),s._v(" "),t("th",{staticStyle:{"text-align":"left"}},[s._v("说明")])])]),s._v(" "),t("tbody",[t("tr",[t("td",{staticStyle:{"text-align":"left"}},[s._v("void setMaxAge(int expiry)")]),s._v(" "),t("td",{staticStyle:{"text-align":"left"}},[s._v("设置cookie的有效期，以秒为单位")])]),s._v(" "),t("tr",[t("td",{staticStyle:{"text-align":"left"}},[s._v("void setValue(String value)")]),s._v(" "),t("td",{staticStyle:{"text-align":"left"}},[s._v("在cookie创建后，对cookie进行赋值")])]),s._v(" "),t("tr",[t("td",{staticStyle:{"text-align":"left"}},[s._v("String getName()")]),s._v(" "),t("td",{staticStyle:{"text-align":"left"}},[s._v("获取cookie的名称")])]),s._v(" "),t("tr",[t("td",{staticStyle:{"text-align":"left"}},[s._v("String getValue()")]),s._v(" "),t("td",{staticStyle:{"text-align":"left"}},[s._v("获取cookie的值")])]),s._v(" "),t("tr",[t("td",{staticStyle:{"text-align":"left"}},[s._v("int getMaxAge()")]),s._v(" "),t("td",{staticStyle:{"text-align":"left"}},[s._v("获取cookie的有效时间，单位秒")])])])]),s._v(" "),t("p",[s._v("实例：实现记忆用户名和密码功能")]),s._v(" "),t("p",[s._v("cookie-login.jsp")]),s._v(" "),t("div",{staticClass:"language-jsp line-numbers-mode"},[t("pre",{pre:!0,attrs:{class:"language-text"}},[t("code",[s._v('<%@ page language="java" import="java.util.*,java.net.*" contentType="text/html; charset=utf-8"%>\n<!DOCTYPE>\n<html>\n  <head>    \n    <title>Cookie Login</title>\n  </head>\n  \n  <body>\n    <h1>登录</h1>\n    <%\n    request.setCharacterEncoding("utf-8");\n    String username = "";\n    String password = "";\n    \n    Cookie[] cookies = request.getCookies();\n\tif (cookies != null && cookies.length > 0) {\n\t\tfor (Cookie c:cookies) {\n\t\t\tif (c.getName().equals("username")) {\n\t\t\t\tusername = URLDecoder.decode(c.getValue(), "utf-8");\n\t\t\t}\n\t\t\tif (c.getName().equals("password")) {\n\t\t\t\tpassword = URLDecoder.decode(c.getValue(), "utf-8");\n\t\t\t}\n\t\t}\n\t}\n    %>\n    <form action="cookie-do-login.jsp" method="post">\n\t    <p>用户名：<input type="text" name="username" value="<%=username %>"></p>\n\t    <p>密 码：<input type="password" name="password" value="<%=password %>"></p>\n\t    <p>\n\t    \t<label>\n\t    \t\t<input type="checkbox" name="isUseCookie" checked value="1"> 十天内保存登录状态\n\t    \t</label>\n\t    </p>\n\t    <p><input type="submit" value="登录"></p>\n    </form>\n  </body>\n</html>\n')])]),s._v(" "),t("div",{staticClass:"line-numbers-wrapper"},[t("span",{staticClass:"line-number"},[s._v("1")]),t("br"),t("span",{staticClass:"line-number"},[s._v("2")]),t("br"),t("span",{staticClass:"line-number"},[s._v("3")]),t("br"),t("span",{staticClass:"line-number"},[s._v("4")]),t("br"),t("span",{staticClass:"line-number"},[s._v("5")]),t("br"),t("span",{staticClass:"line-number"},[s._v("6")]),t("br"),t("span",{staticClass:"line-number"},[s._v("7")]),t("br"),t("span",{staticClass:"line-number"},[s._v("8")]),t("br"),t("span",{staticClass:"line-number"},[s._v("9")]),t("br"),t("span",{staticClass:"line-number"},[s._v("10")]),t("br"),t("span",{staticClass:"line-number"},[s._v("11")]),t("br"),t("span",{staticClass:"line-number"},[s._v("12")]),t("br"),t("span",{staticClass:"line-number"},[s._v("13")]),t("br"),t("span",{staticClass:"line-number"},[s._v("14")]),t("br"),t("span",{staticClass:"line-number"},[s._v("15")]),t("br"),t("span",{staticClass:"line-number"},[s._v("16")]),t("br"),t("span",{staticClass:"line-number"},[s._v("17")]),t("br"),t("span",{staticClass:"line-number"},[s._v("18")]),t("br"),t("span",{staticClass:"line-number"},[s._v("19")]),t("br"),t("span",{staticClass:"line-number"},[s._v("20")]),t("br"),t("span",{staticClass:"line-number"},[s._v("21")]),t("br"),t("span",{staticClass:"line-number"},[s._v("22")]),t("br"),t("span",{staticClass:"line-number"},[s._v("23")]),t("br"),t("span",{staticClass:"line-number"},[s._v("24")]),t("br"),t("span",{staticClass:"line-number"},[s._v("25")]),t("br"),t("span",{staticClass:"line-number"},[s._v("26")]),t("br"),t("span",{staticClass:"line-number"},[s._v("27")]),t("br"),t("span",{staticClass:"line-number"},[s._v("28")]),t("br"),t("span",{staticClass:"line-number"},[s._v("29")]),t("br"),t("span",{staticClass:"line-number"},[s._v("30")]),t("br"),t("span",{staticClass:"line-number"},[s._v("31")]),t("br"),t("span",{staticClass:"line-number"},[s._v("32")]),t("br"),t("span",{staticClass:"line-number"},[s._v("33")]),t("br"),t("span",{staticClass:"line-number"},[s._v("34")]),t("br"),t("span",{staticClass:"line-number"},[s._v("35")]),t("br"),t("span",{staticClass:"line-number"},[s._v("36")]),t("br"),t("span",{staticClass:"line-number"},[s._v("37")]),t("br"),t("span",{staticClass:"line-number"},[s._v("38")]),t("br")])]),t("p",[s._v("cookie-do-login.jsp")]),s._v(" "),t("div",{staticClass:"language-jsp line-numbers-mode"},[t("pre",{pre:!0,attrs:{class:"language-text"}},[t("code",[s._v('<%@ page language="java" import="java.util.*,java.net.*" contentType="text/html; charset=utf-8"%>\n<!DOCTYPE>\n<html>\n  <head>    \n    <title>Cookie Logged</title>\n  </head>\n  \n  <body>\n    <h1>登录成功</h1>\n    <%\n\t\trequest.setCharacterEncoding("utf-8");  \t\n    \tString[] isUseCookie = request.getParameterValues("isUseCookie");\n    \tif (isUseCookie != null && isUseCookie.length > 0) {\n    \t\tString username = URLEncoder.encode(request.getParameter("username"), "utf-8");\n    \t\tString password = URLEncoder.encode(request.getParameter("password"), "utf-8");\n    \t\t\n    \t\t// 保存用户信息\n    \t\tCookie usernameCookie = new Cookie("username", username);\n    \t\tCookie passwordCookie = new Cookie("password", password);\n    \t\t// 保存时间10天\n    \t\tusernameCookie.setMaxAge(864000);\n    \t\tpasswordCookie.setMaxAge(864000);\n    \t\tresponse.addCookie(usernameCookie);\n    \t\tresponse.addCookie(passwordCookie);\n    \t} else {\n    \t\tCookie[] cookies = request.getCookies();\n    \t\tif (cookies != null && cookies.length > 0) {\n    \t\t\tfor (Cookie c:cookies) {\n    \t\t\t\tif (c.getName().equals("username") || c.getName().equals("password")) {\n    \t\t\t\t\t// 设置cookie失效\n    \t\t\t\t\tc.setMaxAge(0);\n    \t\t\t\t\t// 重新保存\n    \t\t\t\t\tresponse.addCookie(c);\n    \t\t\t\t}\n    \t\t\t}\n    \t\t}\n    \t}\n    %>\n    <a href="cookie-user-info.jsp">查看用户信息</a>\n  </body>\n</html>\n')])]),s._v(" "),t("div",{staticClass:"line-numbers-wrapper"},[t("span",{staticClass:"line-number"},[s._v("1")]),t("br"),t("span",{staticClass:"line-number"},[s._v("2")]),t("br"),t("span",{staticClass:"line-number"},[s._v("3")]),t("br"),t("span",{staticClass:"line-number"},[s._v("4")]),t("br"),t("span",{staticClass:"line-number"},[s._v("5")]),t("br"),t("span",{staticClass:"line-number"},[s._v("6")]),t("br"),t("span",{staticClass:"line-number"},[s._v("7")]),t("br"),t("span",{staticClass:"line-number"},[s._v("8")]),t("br"),t("span",{staticClass:"line-number"},[s._v("9")]),t("br"),t("span",{staticClass:"line-number"},[s._v("10")]),t("br"),t("span",{staticClass:"line-number"},[s._v("11")]),t("br"),t("span",{staticClass:"line-number"},[s._v("12")]),t("br"),t("span",{staticClass:"line-number"},[s._v("13")]),t("br"),t("span",{staticClass:"line-number"},[s._v("14")]),t("br"),t("span",{staticClass:"line-number"},[s._v("15")]),t("br"),t("span",{staticClass:"line-number"},[s._v("16")]),t("br"),t("span",{staticClass:"line-number"},[s._v("17")]),t("br"),t("span",{staticClass:"line-number"},[s._v("18")]),t("br"),t("span",{staticClass:"line-number"},[s._v("19")]),t("br"),t("span",{staticClass:"line-number"},[s._v("20")]),t("br"),t("span",{staticClass:"line-number"},[s._v("21")]),t("br"),t("span",{staticClass:"line-number"},[s._v("22")]),t("br"),t("span",{staticClass:"line-number"},[s._v("23")]),t("br"),t("span",{staticClass:"line-number"},[s._v("24")]),t("br"),t("span",{staticClass:"line-number"},[s._v("25")]),t("br"),t("span",{staticClass:"line-number"},[s._v("26")]),t("br"),t("span",{staticClass:"line-number"},[s._v("27")]),t("br"),t("span",{staticClass:"line-number"},[s._v("28")]),t("br"),t("span",{staticClass:"line-number"},[s._v("29")]),t("br"),t("span",{staticClass:"line-number"},[s._v("30")]),t("br"),t("span",{staticClass:"line-number"},[s._v("31")]),t("br"),t("span",{staticClass:"line-number"},[s._v("32")]),t("br"),t("span",{staticClass:"line-number"},[s._v("33")]),t("br"),t("span",{staticClass:"line-number"},[s._v("34")]),t("br"),t("span",{staticClass:"line-number"},[s._v("35")]),t("br"),t("span",{staticClass:"line-number"},[s._v("36")]),t("br"),t("span",{staticClass:"line-number"},[s._v("37")]),t("br"),t("span",{staticClass:"line-number"},[s._v("38")]),t("br"),t("span",{staticClass:"line-number"},[s._v("39")]),t("br"),t("span",{staticClass:"line-number"},[s._v("40")]),t("br"),t("span",{staticClass:"line-number"},[s._v("41")]),t("br")])]),t("p",[s._v("cookie-user-info.jsp")]),s._v(" "),t("div",{staticClass:"language-jsp line-numbers-mode"},[t("pre",{pre:!0,attrs:{class:"language-text"}},[t("code",[s._v('<%@ page language="java" import="java.util.*,java.net.*" contentType="text/html; charset=utf-8"%>\n<!DOCTYPE>\n<html>\n  <head>    \n    <title>Cookie Login</title>\n  </head>\n  \n  <body>\n    <h1>登录</h1>\n    <%\n    request.setCharacterEncoding("utf-8");\n    String username = "";\n    String password = "";\n    \n    Cookie[] cookies = request.getCookies();\n\tif (cookies != null && cookies.length > 0) {\n\t\tfor (Cookie c:cookies) {\n\t\t\tif (c.getName().equals("username")) {\n\t\t\t\tusername = URLDecoder.decode(c.getValue(), "utf-8");\n\t\t\t}\n\t\t\tif (c.getName().equals("password")) {\n\t\t\t\tpassword = URLDecoder.decode(c.getValue(), "utf-8");\n\t\t\t}\n\t\t}\n\t}\n    %>\n    <p>用户名：<%=username %></p>\n    <p>密 码：<%=password %></p>\n  </body>\n</html>\n')])]),s._v(" "),t("div",{staticClass:"line-numbers-wrapper"},[t("span",{staticClass:"line-number"},[s._v("1")]),t("br"),t("span",{staticClass:"line-number"},[s._v("2")]),t("br"),t("span",{staticClass:"line-number"},[s._v("3")]),t("br"),t("span",{staticClass:"line-number"},[s._v("4")]),t("br"),t("span",{staticClass:"line-number"},[s._v("5")]),t("br"),t("span",{staticClass:"line-number"},[s._v("6")]),t("br"),t("span",{staticClass:"line-number"},[s._v("7")]),t("br"),t("span",{staticClass:"line-number"},[s._v("8")]),t("br"),t("span",{staticClass:"line-number"},[s._v("9")]),t("br"),t("span",{staticClass:"line-number"},[s._v("10")]),t("br"),t("span",{staticClass:"line-number"},[s._v("11")]),t("br"),t("span",{staticClass:"line-number"},[s._v("12")]),t("br"),t("span",{staticClass:"line-number"},[s._v("13")]),t("br"),t("span",{staticClass:"line-number"},[s._v("14")]),t("br"),t("span",{staticClass:"line-number"},[s._v("15")]),t("br"),t("span",{staticClass:"line-number"},[s._v("16")]),t("br"),t("span",{staticClass:"line-number"},[s._v("17")]),t("br"),t("span",{staticClass:"line-number"},[s._v("18")]),t("br"),t("span",{staticClass:"line-number"},[s._v("19")]),t("br"),t("span",{staticClass:"line-number"},[s._v("20")]),t("br"),t("span",{staticClass:"line-number"},[s._v("21")]),t("br"),t("span",{staticClass:"line-number"},[s._v("22")]),t("br"),t("span",{staticClass:"line-number"},[s._v("23")]),t("br"),t("span",{staticClass:"line-number"},[s._v("24")]),t("br"),t("span",{staticClass:"line-number"},[s._v("25")]),t("br"),t("span",{staticClass:"line-number"},[s._v("26")]),t("br"),t("span",{staticClass:"line-number"},[s._v("27")]),t("br"),t("span",{staticClass:"line-number"},[s._v("28")]),t("br"),t("span",{staticClass:"line-number"},[s._v("29")]),t("br"),t("span",{staticClass:"line-number"},[s._v("30")]),t("br")])]),t("h3",{attrs:{id:"session与cookie的对比"}},[t("a",{staticClass:"header-anchor",attrs:{href:"#session与cookie的对比"}},[s._v("#")]),s._v(" Session与Cookie的对比")]),s._v(" "),t("p",[t("img",{attrs:{src:"/img/session-vs-cookie.jpg",alt:"session-vs-cookie"}})])])}),[],!1,null,null,null);t.default=n.exports}}]);