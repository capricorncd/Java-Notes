(window.webpackJsonp=window.webpackJsonp||[]).push([[29],{311:function(t,s,a){"use strict";a.r(s);var e=a(14),n=Object(e.a)({},(function(){var t=this,s=t._self._c;return s("ContentSlotsDistributor",{attrs:{"slot-key":t.$parent.slotKey}},[s("h1",{attrs:{id:"jsp基本语法"}},[s("a",{staticClass:"header-anchor",attrs:{href:"#jsp基本语法"}},[t._v("#")]),t._v(" Jsp基本语法")]),t._v(" "),s("div",{staticClass:"custom-block tip"},[s("p",{staticClass:"custom-block-title"},[t._v("JSP（Java Server Pages")]),t._v(" "),s("p",[t._v("其根本是一个简化的Servlet设计，他实现了在Java当中使用HTML标签。\nJSP是一种动态网页技术标准，也是JavaEE的标准。\nJSP与Servlet一样，是在服务器端执行的。")])]),t._v(" "),s("table",[s("thead",[s("tr",[s("th",{staticStyle:{"text-align":"left"}},[t._v("名称")]),t._v(" "),s("th",{staticStyle:{"text-align":"left"}},[t._v("说明")])])]),t._v(" "),s("tbody",[s("tr",[s("td",{staticStyle:{"text-align":"left"}},[t._v("Jsp")]),t._v(" "),s("td",{staticStyle:{"text-align":"left"}},[t._v("Java平台，安全性高，适合开发大型、企业级的Web应用程序。")])]),t._v(" "),s("tr",[s("td",{staticStyle:{"text-align":"left"}},[t._v("Asp.net")]),t._v(" "),s("td",{staticStyle:{"text-align":"left"}},[t._v(".Net平台，简单易学。但是安全性以及跨平台性差。")])]),t._v(" "),s("tr",[s("td",{staticStyle:{"text-align":"left"}},[t._v("PHP")]),t._v(" "),s("td",{staticStyle:{"text-align":"left"}},[t._v("简单、高效，成本低开发周期短，特别适合中小型企业的Web应用开发。")])])])]),t._v(" "),s("h3",{attrs:{id:"jsp页面元素构成"}},[s("a",{staticClass:"header-anchor",attrs:{href:"#jsp页面元素构成"}},[t._v("#")]),t._v(" JSP页面元素构成")]),t._v(" "),s("p",[s("img",{attrs:{src:"/img/jsp-page-struct.jpg",alt:"jsp-page-struct"}})]),t._v(" "),s("h3",{attrs:{id:"jsp指令"}},[s("a",{staticClass:"header-anchor",attrs:{href:"#jsp指令"}},[t._v("#")]),t._v(" JSP指令")]),t._v(" "),s("table",[s("thead",[s("tr",[s("th",{staticStyle:{"text-align":"left"}},[t._v("指令")]),t._v(" "),s("th",{staticStyle:{"text-align":"left"}},[t._v("说明")])])]),t._v(" "),s("tbody",[s("tr",[s("td",{staticStyle:{"text-align":"left"}},[t._v("page指令")]),t._v(" "),s("td",{staticStyle:{"text-align":"left"}},[t._v("通常位于JSP页面的顶端，同一个页面可以多个page指令。")])]),t._v(" "),s("tr",[s("td",{staticStyle:{"text-align":"left"}},[t._v("include指令")]),t._v(" "),s("td",{staticStyle:{"text-align":"left"}},[t._v("将一个外部文件嵌入到当前JSP文件中，同时解析这个页面中的JSP语句。")])]),t._v(" "),s("tr",[s("td",{staticStyle:{"text-align":"left"}},[t._v("taglib指令")]),t._v(" "),s("td",{staticStyle:{"text-align":"left"}},[t._v("使用标签库定义新的自定义标签，在JSP页面中启用定制行为。")])])])]),t._v(" "),s("h3",{attrs:{id:"page指令语法"}},[s("a",{staticClass:"header-anchor",attrs:{href:"#page指令语法"}},[t._v("#")]),t._v(" page指令语法")]),t._v(" "),s("div",{staticClass:"language-jsp line-numbers-mode"},[s("pre",{pre:!0,attrs:{class:"language-text"}},[s("code",[t._v('<%@ page 属性="value" 属性2="valueA,valueB" ... 属性n="valueN"%>\n')])]),t._v(" "),s("div",{staticClass:"line-numbers-wrapper"},[s("span",{staticClass:"line-number"},[t._v("1")]),s("br")])]),s("table",[s("thead",[s("tr",[s("th",{staticStyle:{"text-align":"left"}},[t._v("常用属性")]),t._v(" "),s("th",{staticStyle:{"text-align":"left"}},[t._v("描述")]),t._v(" "),s("th",{staticStyle:{"text-align":"left"}},[t._v("默认值")])])]),t._v(" "),s("tbody",[s("tr",[s("td",{staticStyle:{"text-align":"left"}},[t._v("language")]),t._v(" "),s("td",{staticStyle:{"text-align":"left"}},[t._v("指定JSP页面使用的脚本语言")]),t._v(" "),s("td",{staticStyle:{"text-align":"left"}},[t._v("java")])]),t._v(" "),s("tr",[s("td",{staticStyle:{"text-align":"left"}},[t._v("import")]),t._v(" "),s("td",{staticStyle:{"text-align":"left"}},[t._v("通过该属性来引用脚本语言中使用到的类文件")]),t._v(" "),s("td",{staticStyle:{"text-align":"left"}},[t._v("无")])]),t._v(" "),s("tr",[s("td",{staticStyle:{"text-align":"left"}},[t._v("contentType")]),t._v(" "),s("td",{staticStyle:{"text-align":"left"}},[t._v("原来指定JSP页面所采用的编码方式看，文件类型等")]),t._v(" "),s("td",{staticStyle:{"text-align":"left"}},[t._v("text/html,ISO-8856-1")])])])]),t._v(" "),s("div",{staticClass:"language-jsp line-numbers-mode"},[s("pre",{pre:!0,attrs:{class:"language-text"}},[s("code",[t._v('\x3c!--例子--\x3e\n<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>\n')])]),t._v(" "),s("div",{staticClass:"line-numbers-wrapper"},[s("span",{staticClass:"line-number"},[t._v("1")]),s("br"),s("span",{staticClass:"line-number"},[t._v("2")]),s("br")])]),s("h3",{attrs:{id:"jsp注释"}},[s("a",{staticClass:"header-anchor",attrs:{href:"#jsp注释"}},[t._v("#")]),t._v(" JSP注释")]),t._v(" "),s("p",[t._v("html的注释：")]),t._v(" "),s("div",{staticClass:"language-jsp line-numbers-mode"},[s("pre",{pre:!0,attrs:{class:"language-text"}},[s("code",[t._v("\x3c!-- html注释，浏览器客户端可见 --\x3e\n")])]),t._v(" "),s("div",{staticClass:"line-numbers-wrapper"},[s("span",{staticClass:"line-number"},[t._v("1")]),s("br")])]),s("p",[t._v("JSP的注释：")]),t._v(" "),s("div",{staticClass:"language-jsp line-numbers-mode"},[s("pre",{pre:!0,attrs:{class:"language-text"}},[s("code",[t._v("<%-- jsp注释，浏览器客户端不可见--%>\n")])]),t._v(" "),s("div",{staticClass:"line-numbers-wrapper"},[s("span",{staticClass:"line-number"},[t._v("1")]),s("br")])]),s("p",[t._v("JSP脚本注释：")]),t._v(" "),s("div",{staticClass:"language-jsp line-numbers-mode"},[s("pre",{pre:!0,attrs:{class:"language-text"}},[s("code",[t._v("<%\n  // 单行注释\n  /*\n  多行注释\n  */\n%>\n")])]),t._v(" "),s("div",{staticClass:"line-numbers-wrapper"},[s("span",{staticClass:"line-number"},[t._v("1")]),s("br"),s("span",{staticClass:"line-number"},[t._v("2")]),s("br"),s("span",{staticClass:"line-number"},[t._v("3")]),s("br"),s("span",{staticClass:"line-number"},[t._v("4")]),s("br"),s("span",{staticClass:"line-number"},[t._v("5")]),s("br"),s("span",{staticClass:"line-number"},[t._v("6")]),s("br")])]),s("h3",{attrs:{id:"jsp脚本"}},[s("a",{staticClass:"header-anchor",attrs:{href:"#jsp脚本"}},[t._v("#")]),t._v(" JSP脚本")]),t._v(" "),s("p",[t._v("在JSP页面中"),s("strong",[t._v("执行的java代码")]),t._v("。")]),t._v(" "),s("p",[t._v("语法：")]),t._v(" "),s("div",{staticClass:"language-jsp line-numbers-mode"},[s("pre",{pre:!0,attrs:{class:"language-text"}},[s("code",[t._v('<%\n  // Java代码\n  // do someThing\n  out.println("通过jsp脚本输出的内容：这是JavaEE开发。");\n%>\n')])]),t._v(" "),s("div",{staticClass:"line-numbers-wrapper"},[s("span",{staticClass:"line-number"},[t._v("1")]),s("br"),s("span",{staticClass:"line-number"},[t._v("2")]),s("br"),s("span",{staticClass:"line-number"},[t._v("3")]),s("br"),s("span",{staticClass:"line-number"},[t._v("4")]),s("br"),s("span",{staticClass:"line-number"},[t._v("5")]),s("br")])]),s("h3",{attrs:{id:"jsp声明"}},[s("a",{staticClass:"header-anchor",attrs:{href:"#jsp声明"}},[t._v("#")]),t._v(" JSP声明")]),t._v(" "),s("p",[t._v("在JSP页面中定义"),s("strong",[t._v("变量")]),t._v("或"),s("strong",[t._v("方法")]),t._v("。")]),t._v(" "),s("p",[t._v("语法：")]),t._v(" "),s("div",{staticClass:"language-jsp line-numbers-mode"},[s("pre",{pre:!0,attrs:{class:"language-text"}},[s("code",[t._v('<%!\n  // java代码\n  // 变量\n  String str = "测试文本内容";\n  // 方法\n  int add(int x, int y) {\n    return x + y;\n  }\n%>\n')])]),t._v(" "),s("div",{staticClass:"line-numbers-wrapper"},[s("span",{staticClass:"line-number"},[t._v("1")]),s("br"),s("span",{staticClass:"line-number"},[t._v("2")]),s("br"),s("span",{staticClass:"line-number"},[t._v("3")]),s("br"),s("span",{staticClass:"line-number"},[t._v("4")]),s("br"),s("span",{staticClass:"line-number"},[t._v("5")]),s("br"),s("span",{staticClass:"line-number"},[t._v("6")]),s("br"),s("span",{staticClass:"line-number"},[t._v("7")]),s("br"),s("span",{staticClass:"line-number"},[t._v("8")]),s("br"),s("span",{staticClass:"line-number"},[t._v("9")]),s("br")])]),s("h3",{attrs:{id:"jsp表达式"}},[s("a",{staticClass:"header-anchor",attrs:{href:"#jsp表达式"}},[t._v("#")]),t._v(" JSP表达式")]),t._v(" "),s("p",[t._v("在JSP页面中"),s("strong",[t._v("执行的表达式")]),t._v("。")]),t._v(" "),s("p",[t._v("语法：")]),t._v(" "),s("div",{staticClass:"language-jsp line-numbers-mode"},[s("pre",{pre:!0,attrs:{class:"language-text"}},[s("code",[t._v("<%=表达式 %>\n")])]),t._v(" "),s("div",{staticClass:"line-numbers-wrapper"},[s("span",{staticClass:"line-number"},[t._v("1")]),s("br")])]),s("p",[t._v("注意："),s("strong",[t._v("表达式不以分号结束")]),t._v("。")]),t._v(" "),s("div",{staticClass:"language-jsp line-numbers-mode"},[s("pre",{pre:!0,attrs:{class:"language-text"}},[s("code",[t._v("测试str变量输出：<%=str %><br>\nadd方法输出：10 + 20 = <%=add(10, 20)%>\n")])]),t._v(" "),s("div",{staticClass:"line-numbers-wrapper"},[s("span",{staticClass:"line-number"},[t._v("1")]),s("br"),s("span",{staticClass:"line-number"},[t._v("2")]),s("br")])]),s("h3",{attrs:{id:"jsp生命周期"}},[s("a",{staticClass:"header-anchor",attrs:{href:"#jsp生命周期"}},[t._v("#")]),t._v(" JSP生命周期")]),t._v(" "),s("p",[s("img",{attrs:{src:"/img/jsp-life-cycle.png",alt:"jsp-life-cycle"}})]),t._v(" "),s("p",[s("strong",[t._v("jspService()方法")]),t._v("被调用来处理客户端的请求。对每一个请求，JSP引擎创建一个新的线程来处理该请求。")]),t._v(" "),s("p",[t._v("如果有多个客户端同时请求该JSP文件，则JSP引擎会"),s("strong",[t._v("创建多个线程")]),t._v("，每个客户端请求对应一个线程。以多线程方式执行可以大大降低对系统的资源需求，提高系统的并发量及响应时间。但也要注意多线程的编程带来的同步问题，比如资源共享，线程安全等。由于该Servlet始终驻于内存，所以响应是非常快的。")]),t._v(" "),s("div",{staticClass:"language- line-numbers-mode"},[s("pre",{pre:!0,attrs:{class:"language-text"}},[s("code",[t._v("# 生成的字节码文件目录\n/tomcatx.x/work/Catalina/localhost/MyEclipseTest090301\n")])]),t._v(" "),s("div",{staticClass:"line-numbers-wrapper"},[s("span",{staticClass:"line-number"},[t._v("1")]),s("br"),s("span",{staticClass:"line-number"},[t._v("2")]),s("br")])]),s("div",{staticClass:"custom-block warning"},[s("p",{staticClass:"custom-block-title"},[t._v("练习")]),t._v(" "),s("p",[t._v("当用户第一次请求一个jsp页面时，首先被执行的方法是(A)\nA. "),s("strong",[t._v("构造方法")]),t._v("\nB. jspInit()\nC. jspService()\nD. jspDestroy()")])]),t._v(" "),s("div",{staticClass:"language- line-numbers-mode"},[s("pre",{pre:!0,attrs:{class:"language-text"}},[s("code",[t._v("codes/first-eclipse-web-project/\n")])]),t._v(" "),s("div",{staticClass:"line-numbers-wrapper"},[s("span",{staticClass:"line-number"},[t._v("1")]),s("br")])]),s("h3",{attrs:{id:"练习"}},[s("a",{staticClass:"header-anchor",attrs:{href:"#练习"}},[t._v("#")]),t._v(" 练习")]),t._v(" "),s("p",[t._v("输出99乘法表：")]),t._v(" "),s("div",{staticClass:"language-jsp line-numbers-mode"},[s("pre",{pre:!0,attrs:{class:"language-text"}},[s("code",[t._v('<%!\n  // 表达式输出\n  String printMultiTable() {\n     String str = "";\n     int max = 9;\n     for (int i = 1; i <= max; i++) {\n        for (int j = 1; j <= i; j++) {\n            str += i + " * " + j + " = " + (i * j) + "&nbsp;&nbsp;&nbsp;&nbsp;";\n        }\n        str += "<br>";\n     }\n     return str;\n  }\n  \n  // 脚本方式\n  void printMT(JspWriter out) throws Exception {\n    for (int i = 1; i <= 9; i++) {\n        for (int j = 1; j <= i; j++) {\n            out.print(i + " * " + j + " = " + (i * j) + "&nbsp;&nbsp;&nbsp;&nbsp;");\n        }\n        out.println("<br>");\n    }\n  }\n%>\n<h2>表达式方式：</h2>\n<%=printMultiTable() %>\n    <br>\n<h2>脚本方式：</h2>\n<% printMT(out); %>\n')])]),t._v(" "),s("div",{staticClass:"line-numbers-wrapper"},[s("span",{staticClass:"line-number"},[t._v("1")]),s("br"),s("span",{staticClass:"line-number"},[t._v("2")]),s("br"),s("span",{staticClass:"line-number"},[t._v("3")]),s("br"),s("span",{staticClass:"line-number"},[t._v("4")]),s("br"),s("span",{staticClass:"line-number"},[t._v("5")]),s("br"),s("span",{staticClass:"line-number"},[t._v("6")]),s("br"),s("span",{staticClass:"line-number"},[t._v("7")]),s("br"),s("span",{staticClass:"line-number"},[t._v("8")]),s("br"),s("span",{staticClass:"line-number"},[t._v("9")]),s("br"),s("span",{staticClass:"line-number"},[t._v("10")]),s("br"),s("span",{staticClass:"line-number"},[t._v("11")]),s("br"),s("span",{staticClass:"line-number"},[t._v("12")]),s("br"),s("span",{staticClass:"line-number"},[t._v("13")]),s("br"),s("span",{staticClass:"line-number"},[t._v("14")]),s("br"),s("span",{staticClass:"line-number"},[t._v("15")]),s("br"),s("span",{staticClass:"line-number"},[t._v("16")]),s("br"),s("span",{staticClass:"line-number"},[t._v("17")]),s("br"),s("span",{staticClass:"line-number"},[t._v("18")]),s("br"),s("span",{staticClass:"line-number"},[t._v("19")]),s("br"),s("span",{staticClass:"line-number"},[t._v("20")]),s("br"),s("span",{staticClass:"line-number"},[t._v("21")]),s("br"),s("span",{staticClass:"line-number"},[t._v("22")]),s("br"),s("span",{staticClass:"line-number"},[t._v("23")]),s("br"),s("span",{staticClass:"line-number"},[t._v("24")]),s("br"),s("span",{staticClass:"line-number"},[t._v("25")]),s("br"),s("span",{staticClass:"line-number"},[t._v("26")]),s("br"),s("span",{staticClass:"line-number"},[t._v("27")]),s("br"),s("span",{staticClass:"line-number"},[t._v("28")]),s("br"),s("span",{staticClass:"line-number"},[t._v("29")]),s("br")])])])}),[],!1,null,null,null);s.default=n.exports}}]);