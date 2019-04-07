# Java 中必须了解的常用类

### Java 中的包装类

基本数据类型(int、float、double、boolean、char等)是不具备对象的特性的。比如不能调用方法、功能简单。

为了使基本数据类型也 `具备对象的特性`， Java 为每个基本数据类型都提供了一个 `包装类`，这样我们就可以像操作对象那样来操作基本数据类型。

##### 基本类型和包装类之间的对应关系：

|基本类型|对应的包装类|
|:--|:--|
|byte|Byte|
|short|Short|
|int|Integer|
|long|Long|
|float|Float|
|double|Double|
|char|Character|
|boolean|Boolean|

##### 包装类主要提供了两大类方法：

1、将本类型和其他基本类型进行转换的方法。

2、将字符串和本类型及包装类互相转换的方法。
