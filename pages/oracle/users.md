# 用户

::: tip 系统用户
sys, system。密码为安装软件时设置的密码

sysman。密码为安装软件时设置的密码

scott。密码默认为tiger
:::

权限依次从高到低

### 使用system用户登录

```
# 打开SQL Plus工具
[username/password] [@server] [as sysdba|sysoper]
# system/pw @orcl as sysdba
# orcl 就是自己设置的服务名
```

不区分大小写

![sql-plus-sys](/img/oracle/sql-plus-sys.png)

### 查看登录用户

```
show user
# 结果 USER 为 "SYS"
```

### 数据字典

```
desc dba_users
```

![sql-plus-dba-users](/img/oracle/sql-plus-dba-users.png)

查看有哪些用户，注意SQL语句要以 `;` 分号结束。

```
select username from dba_users;
```

### 启用scott用户

默认情况下，该用户为锁定状态。

```
# 启用用户的语句
alter user username account unlock
# alter user scott account lock
```

**ORA-01918: 用户 'SCOTT' 不存在**