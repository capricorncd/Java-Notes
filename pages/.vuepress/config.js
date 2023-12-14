/**
 * Created by Capricorncd.
 * https://github.com/capricorncd
 * Date: 2023/12/12 20:42:46 (GMT+0900)
 * 
 * https://vuepress.vuejs.org/
 */
module.exports = {
  title: 'Java Memo - Capricorncd',
  description: 'Java Note',
  base: '/Java-Notes/',
  dest: './docs',
  plugins: ['@vuepress/back-to-top'],
  themeConfig: {
    displayAllHeaders: true, // Default: false
    nav: [
      { text: 'Home', link: '/' },
      { text: 'Github', link: 'https://github.com/capricorncd/Java-Notes' }
    ],
    sidebar: [
      {
        title: 'Java',
        path: '/',
      },
      {
        title: 'JAVA基础',
        path: '/java/variable-and-constant',
        children: [
          {
            title: '变量与常量',
            path: '/java/variable-and-constant',
          },
          {
            title: '运算符',
            path: '/java/operator',
          },
          {
            title: '流程控制语句',
            path: '/java/flow-control-statement',
          },
          {
            title: '数组',
            path: '/java/array',
          },
          {
            title: '方法',
            path: '/java/function',
          },
          {
            title: '类与对象', 
            path: '/second-season/class-and-object',
          },
          {
            title: '面向对象特性：封装',
            path: '/second-season/encapsulation',
          },
          {
            title: '面向对象特性：继承',
            path: '/second-season/inheritance',
          },
          {
            title: '面向对象特性：多态',
            path: '/second-season/polymorphic',
          },
          {
            title: '抽象类',
            path: '/second-season/abstract',
          },
          {
            title: '接口Interface',
            path: '/second-season/interface',
          },
          {
            title: 'UML(Unified Modeling Language)',
            path: '/second-season/UML',
          },
          {
            title: '异常与异常处理',
            path: '/third-season/exception',
          },
          {
            title: '异常抛出及自定义异常',
            path: '/third-season/throw',
          },
          {
            title: '字符串',
            path: '/third-season/string',
          },
          {
            title: 'thread-safe 线程安全',
            path: '/third-season/thread-safe',
          },
          {
            title: '包装类',
            path: '/third-season/wrapper-class',
          },
          {
            title: 'Date和SimpleDateFormat类',
            path: '/third-season/date',
          },
          {
            title: 'Calendar类的应用',
            path: '/third-season/calendar',
          },
          {
            title: 'Math类',
            path: '/third-season/math',
          },
          {
            title: '集合框架Collection、Map',
            path: '/third-season/collection-map',
          },
          {
            title: '泛型',
            path: '/third-season/generic',
          },
          {
            title: 'Set接口，及其实现类HashSet',
            path: '/third-season/set',
          },
          {
            title: 'Map & HashMap',
            path: '/third-season/map',
          },
          {
            title: '- 问题思考',
            path: '/third-season/questions',
          },
          {
            title: 'Collections工具类',
            path: '/third-season/collections',
          },
          {
            title: '综合练习——洗牌发牌Easy版',
            path: '/third-season/game-test',
          },
          {
            title: 'Java反射机制',
            path: '/third-season/reflect',
          },
        ],
      },
      {
        title: '正则表达式',
        path: '/regular-expression',
        children: [
          {
            title: '正则表达式',
            path: '/regular-expression/',
          },
          {
            title: '用例',
            path: '/regular-expression/usage',
          },
        ],
      },
      {
        title: 'Spring框架',
        path: '/spring',
        children: [
          {
            title: 'Spring框架简介',
            path: '/spring/',
          },
          {
            title: 'JUnit4',
            path: '/spring/j-unit',
          },
          {
            title: 'IoC及bean容器',
            path: '/spring/ioc',
          },
          {
            title: 'Bean装配',
            path: '/spring/bean',
          },
          {
            title: 'AOP基本概念',
            path: '/spring/aspect-oriented-programming',
          },
          {
            title: 'AOP的API介绍',
            path: '/spring/aop-api',
          },
          {
            title: 'Spring对AspectJ的支持',
            path: '/spring/aspect-j',
          },
          {
            title: 'Spring Security',
            path: '/spring/spring-security'
          },
        ],
      },
      {
        title: 'Spring MVC',
        path: '/spring-mvc',
        children: [
          {
            title: 'Spring MVC起步',
            path: '/spring-mvc/',
          },
          {
            title: 'Spring MVC实操',
            path: '/spring-mvc/hands-on',
          },
          {
            title: 'Spring MVC拦截器',
            path: '/spring-mvc/interceptor',
          },
        ],
      },
      {
        title: 'Java Web应用程序',
        path: '/java-web/',
        children: [
          {
            title: 'JavaWeb应用程序',
            path: '/java-web/',
          },
          {
            title: 'JSP基本语法',
            path: '/java-web/jsp',
          },
          {
            title: 'JSP内置对象',
            path: '/java-web/built-in-object',
          },
          {
            title: 'JavaBean',
            path: '/java-web/java-bean',
          },
          {
            title: 'Jsp状态管理Cookie',
            path: '/java-web/state-management',
          },
          {
            title: '指令与动作include/forward',
            path: '/java-web/commands-and-actions',
          },
          {
            title: '过滤器Filter',
            path: '/java-web/filter',
          },
        ],
      },
      {
        title: 'Oracle',
        path: '/oracle',
        children: [
          {
            title: '介绍与安装',
            path: '/oracle/',
          },
          {
            title: '用户',
            path: '/oracle/users',
          },
          {
            title: '表空间',
            path: '/oracle/tablespaces',
          },
          {
            title: '管理表，数据增删改',
            path: '/oracle/management-table',
          },
          {
            title: '约束constraint',
            path: '/oracle/constraint',
          },
          {
            title: '查询语句sql',
            path: '/oracle/sql',
          },
          {
            title: 'Oracle高级查询',
            path: '/oracle/3-Oracle高级查询',
          },
          {
            title: 'PL/SQL程序设计',
            path: '/oracle/pl-sql',
          },
        ],
      },
      {
        title: '文件处理',
        path: '/file',
        children: [
          {
            title: 'Java I/O文件处理',
            path: '/file/',
          },
        ],
      },
      {
        title: '消息摘要算法及应用',
        path: '/message-digest',
        children: [
          {
            title: 'MD2/MD4/MD5',
            path: '/message-digest/',
          },
          {
            title: 'SHA-1/SHA-2',
            path: '/message-digest/SHA',
          },
          {
            title: 'MAC/HMAC',
            path: '/message-digest/MAC',
          },
        ],
      },
    ]
  },
  markdown: {
    lineNumbers: true
  }
}