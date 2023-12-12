# 消息摘要算法--MAC

MAC(Message Authentication Code)

HMAC(keyed-Hash Message Authentication Code),含有密钥的散列函数算法

### 融合MD、SHA

- MD系列：HmacMD2、HmacMD4、HmacMD5

- SHA系列：HmacSHA1、HmacSHA224、HmacSHA256、HmacSHA384、HmacSHA512

应用：SecureCRT

|算法|摘要长度|实现方法|
|:--|:--|:--|
|HmacMD2|128|Bouncy Castle|
|HmacMD4|128|Bouncy Castle|
|HmacMD5|128|JDK|
|HmacSHA1|160|JDK|
|HmacSHA224|224|Bouncy Castle/JDK1.8|
|HmacSHA256|256|JDK|
|HmacSHA384|384|JDK|
|HmacSHA512|512|JDK|

### 代码实现

<<< @/pages/message-digest/src/TestMAC.java

运行结果：

```
HmacMD2: Algorithm HmacMD2 not available by JDK
HmacMD4: Algorithm HmacMD4 not available by JDK
HmacMD5: 60abad09ecbc7f234c3066b76209d657 by JDK

HmacMD2: cc2e396c39d58f3d6415eebfbf928744 by Bouncy Castle.
HmacMD4: 199828516cc1f41baa9536e095e73483 by Bouncy Castle.
HmacMD5: 60abad09ecbc7f234c3066b76209d657 by Bouncy Castle.

HmacSHA1: ee77ed44862c69ff1b93d81a2cab40b714aeac39 by JDK
HmacSHA224: 261be450a5b2f6e9dad0df89e14710c4a412ef89d4c9b8db76173c19 by JDK
HmacSHA256: a6c974f0b1025844d8266e3ab8f0402c8467c5878dcd9982216c46b6fd90d067 by JDK
HmacSHA384: 43a6703c1fa097ec80a1aec85b6f38eef34059c3b90dddce27c7fde3d5e7d716050a86aa09275b52c9378eb819774a32 by JDK
HmacSHA512: da98cf562dfaa094624ee28464dd0c4e0ade2a07fc28bb5b5aadeb0cef59e43ec9a3eeef51cf33a6e30c1611e1dc912fac3f1108db15a72e390e47579e4dad23 by JDK

HmacSHA1: ee77ed44862c69ff1b93d81a2cab40b714aeac39 by Bouncy Castle.
HmacSHA224: 261be450a5b2f6e9dad0df89e14710c4a412ef89d4c9b8db76173c19 by Bouncy Castle.
HmacSHA256: a6c974f0b1025844d8266e3ab8f0402c8467c5878dcd9982216c46b6fd90d067 by Bouncy Castle.
HmacSHA384: 43a6703c1fa097ec80a1aec85b6f38eef34059c3b90dddce27c7fde3d5e7d716050a86aa09275b52c9378eb819774a32 by Bouncy Castle.
HmacSHA512: da98cf562dfaa094624ee28464dd0c4e0ade2a07fc28bb5b5aadeb0cef59e43ec9a3eeef51cf33a6e30c1611e1dc912fac3f1108db15a72e390e47579e4dad23 by Bouncy Castle.
```

### MAC-应用

![message-authentication-code](/img/message-authentication-code.png)

