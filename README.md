# Java 教程笔记

Java是一门面向对象编程语言，不仅吸收了C++语言的各种优点，还摒弃了C++里难以理解的多继承、指针等概念，因此Java语言具有功能强大和简单易用两个特征。

文档：https://capricorncd.github.io/Java-Notes/

> 注意
> 文档中类或接口类方法截图为 `JavaSE-1.8` 版本

### 构建文档

```
# 开发模式
npm run dev

# 生成文档
npm run build
```

## VuePress Build Error

https://vuepress.vuejs.org/

```
# node v20.10.0
(undefined) assets/js/77.07f9fd56.js from Terser
Error: error:0308010C:digital envelope routines::unsupported
```

fix

```
# Mac
export NODE_OPTIONS=--openssl-legacy-provider
```
