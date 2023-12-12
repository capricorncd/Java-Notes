# 正则表达式用例

### 1. 格式化HTTP消息

```java
/**
 * 格式化HTTP消息
 * 404 NOT FOUND -> { statusCode: 404, message: "NOT FOUND" }
 * @param message
 * @return HttpMessageFormatter
 */
public HttpMessageFormatter formatHttpMessage(String message) {
  HttpMessageFormatter fmt = new HttpMessageFormatter(0, message);
  if (!isBlank(message)) {
    Pattern r = Pattern.compile("^(\\d+)\\s+(.+)");
    Matcher m = r.matcher(message);
    if (m.find()) {
      // fmt.setStatusCode(Integer.valueOf(m.group(1)));
      fmt.setStatusCode(Integer.parseInt(m.group(1)));
      fmt.setMessage(m.group(2));
    }
  }
  return fmt;
}

public static boolean isBlank(String input) {
  return input == null || input.trim().isEmpty();
}
```

::: details HttpMessageFormatter
```java
class HttpMessageFormatter {
  private int statusCode;
  private String message;

  public HttpMessageFormatter() {}

  public HttpMessageFormatter(int statusCode, String message) {
    this.statusCode = statusCode;
    this.message = message;
  }

  public int getStatusCode() {
    return statusCode;
  }

  public String getMessage() {
    return message;
  }

  public void setStatusCode(int statusCode) {
    this.statusCode = statusCode;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
```
:::

### 2. 匹配字符串中所有数字

```java
public class RegexTest {
    public static void main(String[] args) {
        String str = "1234567890";
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
```

### 3.判断输入是否满足某种格式

```java
public boolean isEmail(String input) {
  if (isBlank(input)) return false;
  Pattern r = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+");
  return r.matcher(input).matches();
}
```