# 拦截器

```
interceptor
英 [ˌɪntəˈseptə(r)]   美 [ˌɪntərˈseptər]  
n.截击机，拦截器
```

> [!TIP|style:flat|label:Interceptor]

> 拦截器是指通过统一拦截从浏览器发往服务器的请求来完成功能的增强。(相当于Node.js KOA2的中间件)

> 使用场景：解决请求的共性问题（如：乱码问题、权限验证问题等）

![interceptor-instruction](img/interceptor-instruction.png)

### 拦截器的基本工作原理

SpringMVC可以通过配置过滤器来解决乱码问题

