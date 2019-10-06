# 文件处理

文件编码

File类的使用

RandomAccessFile的使用

字节流的使用

字符流的使用

对象的序列化与反序列化

### 文件编码

```java
String s = "您好世界ABC";
	
/**
 * 字符串转byte[]
 */
// 转换成字节码序列用的是项目默认的编码GBK，中文占两个字节
byte[] bytes1 = s.getBytes();
for (byte b : bytes1) {
    // 把字节（转换错了int）以16进制的方式显示
    System.out.print(Integer.toHexString(b & 0xff) + " ");
}
// 结果：c4 fa ba c3 ca c0 bd e7 41 42 43 
System.out.println("");

byte[] bytes2 = s.getBytes("GBK");
for (byte b : bytes2) {
    System.out.print(Integer.toHexString(b & 0xff) + " ");
}
// 结果：c4 fa ba c3 ca c0 bd e7 41 42 43 
// GBK编码中文占2个字节，英文占1个字节
System.out.println("");

// utf-8
byte[] bytes3 = s.getBytes("utf-8");
for (byte b : bytes3) {
    System.out.print(Integer.toHexString(b & 0xff) + " ");
}
// 结果：e6 82 a8 e5 a5 bd e4 b8 96 e7 95 8c 41 42 43 
// utf-8编码中文占3个字节，英文占1个字节
System.out.println("");

// Java是双字节编码utf-16be
byte[] bytes4 = s.getBytes("utf-16be");
for (byte b : bytes4) {
    System.out.print(Integer.toHexString(b & 0xff) + " ");
}
// 结果：60 a8 59 7d 4e 16 75 4c 0 41 0 42 0 43 
// utf-16be中文占2个字节，英文占用2个字节
System.out.println("");

/**
 * byte[]转字符串
 * 当字节序列为某种编码时，这个时候想把字节序列变成字符串，
 * 也需要用这种编码方式，否则会出现乱码
 */
// 用项目默认的编码
String str1 = new String(bytes1);
System.out.println(str1);
String str2 = new String(bytes2, "GBK");
System.out.println(str2);
String str3 = new String(bytes3, "utf-8");
System.out.println(str3);
String str4 = new String(bytes4, "utf-16be");
System.out.println(str4);

/**
 * 文本文件 就是字节序列，
 * 其可以使任意编码的字节序列
 * *在中文机器上直接创建文本文件，该文件只认识ansi编码
 */
 ```
 
### File类常用API
 
java.io.File类用于表示文件（或目录）

File类只用于表示文件（或目录）的信息（名称、大小等），不能用于文件内容的访问。

```java
File file = new File("D:\\java\\test");
System.out.println("文件是否存在：" + (file.exists() ? "是" : "否"));
// 不存在文件（目录）创建
if (!file.exists()) {
    file.mkdir();
    // 多级目录创建
    //file.mkdirs();
} else {
    file.delete();
}
// 是目录或目录存在返回true，否则返回false
System.out.println("是否为目录：" + file.isDirectory());
System.out.println("是否为文件：" + file.isFile());
System.out.println();

//File file2 = new File("D:\\java\\test.txt");
File file2 = new File("D:\\java", "test.txt");
if (!file2.exists()) {
    try {
        file2.createNewFile();
    } catch (IOException e) {
        e.printStackTrace();
    }
} else {
    file2.delete();
}

System.out.println(file);//D:\java\test
System.out.println(file.getAbsolutePath());//D:\java\test
System.out.println(file.getParent());//D:\java
System.out.println(file.getName());//test
System.out.println();

System.out.println(file2.getParent());//D:\java
System.out.println(file2.getName());//test.txt
```

list() 与 listFiles()

```java
/**
 * 列出指定目录下的所有文件及子文件夹（包含其子目录）
 * @param dir
 * @param deep
 */
public static void printListDirectory(File dir, boolean deep) throws IOException {
    if (!dir.exists()) {
        throw new IllegalArgumentException("目录不存在，" + dir);
    }
    if (!dir.isDirectory()) {
        throw new IllegalArgumentException(dir + ", 不是目录");
    }
    //返回目录下的所有文件或子目录，及子目录的所有文件及目录
    if (deep) {
        File[] files = dir.listFiles();
        if (files != null && files.length > 0) {
            for (File f : files) {
                if (f.isDirectory()) {
                    printListDirectory(f, true);
                } else {
                    System.out.println(f);
                }
            }
        }
    }
    //返回目录下的文件或子目录名称，不包含子目录下的内容
    else {
        String[] fileNames = dir.list();
        for (String str : fileNames) {
            System.out.println(dir + "\\" + str);
        }
    }
}
```

### RandomAccessFile

java提供的对文件内容的访问，既可以读文件，也可以写文件。

支持随机访问文件，可以访问文件的任意位置。

(1)**java文件模型**：在硬盘上的文件是byte byte byte存储的，是数据的集合

(2)**打开文件**：有两种模式**rw**（读写），**r**（只读）。

```java
RandomAccessFile raf = new RandomAccessFile(file, "rw");
```

文件指针，打开文件时指针在开头 pointer = 0;

(3)写方法

```java
raf.write(int);
```

只写一个字节（后8位），同时指针指向下一个位置，准备再次写入。

(4)读方法

```java
raf.read();
```

从指针位置读一个字节。

(5)文件读写完成以后，一定要关闭，否则可能会抛出意想不到的异常（Oracle官方说明）

```java
File demo = new File("D:\\java\\demo");
if (!demo.exists()) {
    demo.mkdir();
}
File file = new File(demo, "raf.dat");
if (!file.exists()) {
    file.createNewFile();
}
RandomAccessFile raf = new RandomAccessFile(file, "rw");
// 指针的位置
System.out.println(raf.getFilePointer());
// write方法每次只能写一个字节
raf.write('A');
System.out.println(raf.getFilePointer());
raf.write('B');

int num = 0x7fffffff;
// write方法每次只能写一个字节，如果把num写进去就的写4次
raf.write(num >>> 24);
raf.write(num >>> 16);
raf.write(num >>> 8);
raf.write(num);

//可以直接写入一个int
raf.writeInt(num);

String s = "中";
byte[] gbk = s.getBytes("GBK");
raf.write(gbk);
System.out.println(raf.length());

// 读文件，把指针移到头部
raf.seek(0);
//一次性读取，把文件中的内容，读取到字节数组中
byte[] buf = new byte[(int)raf.length()];
raf.read(buf);

System.out.println(Arrays.toString(buf));
for (byte b : buf) {
    System.out.print(Integer.toHexString(b & 0xff) + " ");
}
raf.close();
```

