# 字符串

在 Java 中，字符串被作为 String 类型的对象处理。 String 类位于 java.lang 包中。默认情况下，该包被自动导入`所有的程序`。

### 创建String对象的方法

创建一个字符串对象"Hello World"，变量名为str

```java
String str = "Hello World";
```

创建一个空字符串对象

```java
String str = new String();
```

创建一个字符串对象

```java
String str = new String("Hello World");
```

### 字符串的不变性

String 对象创建后则 `不能被修改`，是`不可变的`。所谓的修改其实是创建了新的对象，所指向的内存空间不同。

```java
String str1 = "Hello World";
String str2 = "Hello World";
String Str3 = new String("Hello World");
String Str4 = new String("Hello World");

// 多次出现的字符串常量，Java编译程序只创建一个，所以返回true
System.out.println(str1 == str2);

// str1和str3是不同的对象，所以返回false
System.out.println(str1 == str3);

// str3和str4是不同的对象，所以返回false
System.out.println(str3 == str4);

str1 = "Wolcome to " + str1;
// 字符串str1被修改，指向新的内存空间
System.out.println(str1);
```

> [!TIP|style:flat|label:总结]

> 在第一次使用字符串引用的使用，也是通过new来创建字符串的，只是隐式的new一个字符串对象

> 在你第二次使用同一个字符串的时候，会查找堆内存中有没有和该字符串一样的，如果有就直接引用这个堆中已经有的字符串对象，如果没有，还是会new一个；

> 而直接使用new的方法，创建字符串，是不管堆中有没有，直接创建一个新的对象，所以在比较的时候，都是false

##### 关系图说明：

1、通过 String str1 = "Hello World"; 声明了一个字符串对象， str1 存放了到字符串对象的引用。

![](img/str-heap-1.png)

然后通过 str1 = "Wolcome to " + str1; 改变了字符串 str1 ，其实质是创建了新的字符串对象，变量 str1 指向了新创建的字符串对象。

![](img/str-heap-2.png)

2、一旦一个字符串在内存中创建，则这个字符串将不可改变。如果需要一个可以改变的字符串，我们可以使用StringBuffer或者StringBuilder。

3、每次 new 一个字符串就是产生一个新的对象，即便两个字符串的内容相同，使用 `==` 比较时也为 `false` ,如果只需比较内容是否相同，应使用 `equals()` 方法。

### String 类的常用方法

![](img/str-methods.png)

```java
package com.string;
import java.util.Arrays;

public class StrTest {

	public static void main(String[] args) {
		String str = "Hello World";
		System.out.println("length(): " + str.length());
		// find char W
		char w = 'W';
		System.out.println("indexOf('W'): " + str.indexOf(w));
		// split array
		String[] arr = str.split(" ");
		System.out.print("Arrays.toString(): " + Arrays.toString(arr));
		System.out.println();
		// get children string by index[3, 7)
		System.out.println("get the substring of index[3, 7), with substring(): " + str.substring(3, 7));
		//
		System.out.println("toLowerCase(): " + str.toLowerCase());
		System.out.println("toUpperCase(): " + str.toUpperCase());
		System.out.println("charAt(1): " + str.charAt(1));
		// to byte[]
		byte[] b = str.getBytes();
		System.out.print("to bytes: ");
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
		System.out.println();
		// == equals
		String str2 = new String("Hello World");
		System.out.println("Are str and str2 memory addresses the same? " + (str == str2));
		System.out.println("Is Str the same as str2? " + (str.equals(str2)));
	}

}
```

运行结果：

```
length(): 11
indexOf('W'): 6
Arrays.toString(): [Hello, World]
get the substring of index[3, 7), with substring(): lo W
toLowerCase(): hello world
toUpperCase(): HELLO WORLD
charAt(1): e
to bytes: 72 101 108 108 111 32 87 111 114 108 100
Are str and str2 memory addresses the same? false
Is Str the same as str2? true
```

> [!TIP|style:flat|label:总结]

> 1、字符串 str 中字符的索引从0开始，范围为 0 到 str.length()-1

> 2、使用 indexOf 进行字符或字符串查找时，如果匹配返回位置索引；如果没有匹配结果，返回 -1

> 3、使用 substring(beginIndex , endIndex) 进行字符串截取时，包括 beginIndex 位置的字符，不包括 endIndex 位置的字符

##### “==” 和 equals() 有什么区别呢？

`==` : 判断两个字符串在内存中首地址是否相同，即判断是否是同一个字符串对象

`equals()` : 比较存储在两个字符串对象中的内容是否一致

```java
package com.string;

public class CNStrTest {

	public static void main(String[] args) {
        String str = "String类常用方法。";
        try {
            byte[] b = str.getBytes("GBK");
            for (int i = 0; i < b.length; i++) {
                System.out.print(b[i] + " ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
```

运行结果：

```
83 116 114 105 110 103 -64 -32 -77 -93 -45 -61 -73 -67 -73 -88 -95 -93
```

> [!TIP|style:flat|label:PS]

> 字节是计算机存储信息的基本单位，1 个字节等于 8 位， gbk 编码中 1 个汉字字符存储需要 2 个字节，1 个英文字符存储需要 1 个字节。

> 所以我们看到上面的程序运行结果中，每个汉字对应两个字节值，如“类”对应 “-64 -32 ” ，而英文字母 “S” 对应 “83” 。

> 同时，我们还发现汉字对应的字节值为负数，原因在于每个字节是 8 位，最大值不能超过 127，而汉字转换为字节后超过 127，如果超过就会溢出，以负数的形式显示。

##### 在java中，一个英文字符占多少字节，一个中文字符占多少字节？

by 慕课网友：Yesabella

> [!WARNING|style:flat|label:字节补充]

> Java采用unicode来表示字符，java中的一个char是2个字节，一个中文或英文字符的unicode编码都占2个字节，但如果采用其他编码方式，一个字符占用的字节数则各不相同。

> 在 GB 2312 编码或 GBK 编码中，一个英文字母字符存储需要1个字节，一个汉子字符存储需要2个字节。

> 在UTF-8编码中，一个英文字母字符存储需要1个字节，一个汉字字符储存需要3到4个字节。

> 在UTF-16编码中，一个英文字母字符存储需要2个字节，一个汉字字符储存需要3到4个字节（Unicode扩展区的一些汉字存储需要4个字节）。

> 在UTF-32编码中，世界上任何字符的存储都需要4个字节。

> 如果编码方式为GBK，对于字符串“测试test”，字符长度为6，字节长度为8。

> 如果编码方式为UTF_8，对于字符串“测试test”，字符长度为6，字节长度为10。

```java
String aa = "学";
System.out.println("UTF-8编码长度:"+aa.getBytes("UTF-8").length);
System.out.println("GBK编码长度:"+aa.getBytes("GBK").length);
System.out.println("GB2312编码长度:"+aa.getBytes("GB2312").length);
// 运行结果
// UTF-8编码长度:3
// GBK编码长度:2
// GB2312编码长度:2
```

练习

```java
public class HelloWorld {
    public static void main(String[] args) {
		// 定义一个字符串
		String s = "aljlkdsflkjsadjfklhasdkjlflkajdflwoiudsafhaasdasd";

        // 出现次数
		int num = 0;

         // 循环遍历每个字符，判断是否是字符 a ，如果是，累加次数
		for ( int i = 0; i < s.length(); i++ ) {
            // 获取每个字符，判断是否是字符a
			if ( s.charAt(i) == 'a' ) {
                // 累加统计次数
				num++;
			}
		}
		System.out.println("字符a出现的次数：" + num);
	}
}
```

### StringBuilder 类

在Java中，除了可以使用 String 类来存储字符串，还可以使用 StringBuilder 类或 StringBuffer 类存储字符串，那么它们之间有什么区别呢？

```java
String str = "Hello";
System.out.println(str + " World");
System.out.println(str);
```

结果

```
Hello World
Hello
```

从运行结果中我们可以看到，程序运行时会额外创建一个对象，保存 "Hello World"。当频繁操作字符串时，就会额外产生很多临时变量。

使用 StringBuilder 或 StringBuffer 就可以避免这个问题。

> [!TIP|style:flat|label:StringBuilder和StringBuffer]

> 它们基本相似，不同之处，StringBuffer 是 `线程安全的`，而 StringBuilder 则没有实现线程安全功能，所以性能略高。

> 因此一般情况下，如果需要创建一个内容可变的字符串对象，应优先考虑使用 StringBuilder 类。

##### 定义

```java
// 创建一个StringBuilder对象
StringBuilder str1 = new StringBuilder();
// 创建一个字符串"Hello World"
StringBuilder str2 = new StringBuilder("Hello World");
System.out.println(str2);
```

##### 常用方法

|方法|说明|
|:--|:--|
|StringBuilder append(参数)|追加内容到当前StringBuilder对象的末尾|
|StringBuilder insert(位置, 参数)|将内容插入到StringBuilder对象的指定位置|
|String toString()|将StringBuilder对象转换为String对象|
|int length()|获取字符串的长度|

练习：将一个由英文字母组成的字符串转换成指定格式---从右边开始每三个字母用逗号分隔的形式。

```java
package com.string;

public class StringBuilderTest {

	public static void main(String[] args) {
		// 创建一个空的StringBuilder对象
		StringBuilder str = new StringBuilder();
		// 追加字符串
		str.append("jaewkjldfxmopzdm");

        // 从后往前每隔三位插入逗号
		for (int i = str.length() - 1, j = 0; i >= 0; i--, j++) {
			if (j > 0 && j % 3 == 2) {
				str.insert(i, ",");
			}
		}

        // 将StringBuilder对象转换为String对象并输出
		System.out.print(str.toString());
	}

}
```
