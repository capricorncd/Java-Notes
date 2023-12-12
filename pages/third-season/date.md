# Date 和 SimpleDateFormat 类

### Date类

java.util 包中的 Date 类，这个类最主要的作用就是获取当前时间。

```java
// 使用默认的构造方法创建Date对象
Date d = new Date();
// 输出Date对象
System.out.println(d);
```

使用 Date 类的默认无参构造方法创建出的对象就代表当前时间。

```
Mon Apr 08 22:34:51 CST 2019
```

其中， Mon 代表 Monday (星期一)， Apr 代表 April (四月)， 08 代表 08 号， CST 代表 China Standard Time (中国标准时间，也就是北京时间，东八区)。

### SimpleDateFormat类

java.text 包中的 SimpleDateFormat类

1、使用 format() 方法将日期转换为指定格式的文本


```java
import java.util.*;
import java.text.*;

public class DateTest {

	public static void main(String[] args) {
		// 创建Date对象，表示当前时间
		Date d = new Date();
		// 创建SimpleDateFormat对象，指定目标格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 调用format()方法，格式化时间，转化为指定格式字符串
		String today = sdf.format(d);
		// 输出转换后的字符串
		System.out.print(today);
	}

}
```

代码中的 “yyyy-MM-dd HH:mm:ss” 为预定义字符串， yyyy 表示四位年， MM 表示两位月份， dd 表示两位日期， HH 表示小时(使用24小时制)， mm 表示分钟， ss 表示秒，这样就指定了转换的目标格式，最后调用 format() 方法将时间转换为指定的格式的字符串。

运行结果：

```
2019-04-08 22:41:48
```

2、使用 parse() 方法将文本转换为日期

```java
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateParseTest {

	public static void main(String[] args) {
		// 创建日期格式的字符串
		String day = "2019年04月08日 22:44:23";
		// 创建SimpleDateFormat对象，指定字符串的日期格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		// 调用parse()方法，将字符串转化为日期
		try {
			Date date = sdf.parse(day);
			// 输出转换后的时间
			System.out.println("parse后的时间："  + date);
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("parse(" + day + ")失败");
		}
	}

}
```

代码中的 “yyyy年MM月dd日 HH:mm:ss” 指定了字符串的日期格式，调用 parse() 方法将文本转换为日期。

运行结果：

```
parse后的时间：Mon Apr 08 22:44:23 CST 2019

```

::: warning 注意

调用 SimpleDateFormat 对象的 parse() 方法时可能会出现转换异常，即 ParseException ，因此需要进行异常处理
:::

使用 Date 类时需要导入 java.util 包，使用 SimpleDateFormat 时需要导入 java.text 包
:::
