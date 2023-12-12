# 消息摘要算法

MD(Message Digest)

SHA(Secure Hash Algorithm)

MAC(Message Authentication Code)

其他如：RipeMD, Tiger, Whirlpool, GOST3411等，均由Bouncy Castle实现。

### 消息摘要算法--MD(Message Digest)

作用：验证数据的完整性

是数字签名核心算法

MD5

MD家族（128位摘要信息）-MD2，MD4

|算法|摘要长度|实现方法|
|:--|:--|:--|
|MD2|128|JDK|
|MD4|128|Bouncy Castle|
|MD5|128|JDK|

### 代码实现

<<< @/pages/message-digest/src/TestMessageDigest.java

运行结果：

```
MD2: b749ef6943db8fa96fa688a1077224a3 by JDK
MD4: MD4 MessageDigest not available by JDK
MD5: 2947f614c460347649185e62ee914eac by JDK
MD2: b749ef6943db8fa96fa688a1077224a3 by Bouncycastle
MD4: 9df4c1b595403939d490ad7c66cf7710 by Bouncycastle
MD5: 2947f614c460347649185e62ee914eac by Bouncycastle
MD2: b749ef6943db8fa96fa688a1077224a3 by BouncyCastleProvider
MD4: 9df4c1b595403939d490ad7c66cf7710 by BouncyCastleProvider
MD5: 2947f614c460347649185e62ee914eac by BouncyCastleProvider
MD2: b749ef6943db8fa96fa688a1077224a3 by org.apache.commons.codec.digest.DigestUtils
MD4: The MD4 method is not implemented. by org.apache.commons.codec.digest.DigestUtils
MD5: 2947f614c460347649185e62ee914eac by org.apache.commons.codec.digest.DigestUtils
```

### 消息摘要算法--应用

注册、登录密码处理

![message-digest-application](/img/message-digest-application.png)
