# Oracle

甲骨文公司，全称甲骨文股份有限公司(甲骨文软件系统有限公司)，是全球最大的企业级软件公司，总部位于美国加利福尼亚州的红木滩。1989年正式进入中国市场。2013年，甲骨文已超越 IBM ，成为继 Microsoft 后全球第二大软件公司。

### 安装与卸载

* 安装

https://www.oracle.com/downloads/

* 卸载

```
# windows系统运行
deinstall/deinstall.bat
```

### 用户与表空间

> [!TIP|style:flat|label:系统用户]

> sys, system。密码为安装软件时设置的密码

> sysman。密码为安装软件时设置的密码

> scott。密码默认为tiger

权限依次从高到低

* 使用system用户登录

```
# 打开SQL Plus工具
[username/password] [@server] [as sysdba|sysoper]
# system/pw @orcl as sysdba
# orcl 就是自己设置的服务名
```

不区分大小写

![sql-plus-sys](img/sql-plus-sys.png)

* 查看登录用户

```
show user
# 结果 USER 为 "SYS"
```

数据字典

```
desc dba_users
```

![sql-plus-dba-users](img/sql-plus-dba-users.png)

查看有哪些用户，注意SQL语句要以 `;` 分号结束。

```
select username from dba_users;
```

* 启用scott用户

默认情况下，该用户为锁定状态。

```
# 启用用户的语句
alter user uesename account unlock
# alter user username account lock
```

**ORA-01918: 用户 'SCOTT' 不存在**

> [!TIP|style:flat|label:表空间]

> **数据库与表空间***

> 表空间实际上是数据库的逻辑存储空间，可以理解为在数据库中开辟的一个空间，用来存储数据库对象。一个数据库可以由多个表空间构成。

> 此特点也是与MySQL等数据库的主要区别。Oracle的很多优化也是通过表空间来实现的。

> **表空间与数据文件**

> 表空间实际上是由多个数据文件构成的，数据文件的大小和位置可以由用户自己定义。

> 表空间可分为：永久表空间、临时表空间、UNDO表空间

* 永久表空间

数据库中需要永久化存储的一些对象。比如表、视图、存储过程等

* 临时表空间

数据库操作过程中，中间执行的过程，执行结束后，存放的内容将被自动释放掉。不进行永久性的保存。

* UNDO表空间

用于保存事务所修改的旧址，即保存修改之前的数据。可以利用此功能实现回滚等操作。

### 查看用户的表空间

```
# 系统用户登录查看的数据字典
dba_tablespaces
# 普通用户登录查看的数据字典
user_tablespaces
```

* 系统用户

![sql-plus-dba-tablespaces](img/sql-plus-dba-tablespaces.png)

![sql-plus-dba-tablespaces](img/sql-plus-dba-tablespace-name.png)

SYSTEM: 系统表空间

SYSAUX: 辅助表空间，安装Oracle示例使用的表空间。

UNDOTBS1: 社交类型表空间

TEMP: 

USERS: 

* 普通用户

![sql-plus-users-tablespaces](img/sql-plus-users-tablespaces.png)

```
# 系统用户登录查看的数据字典
dba_users
# 普通用户登录查看的数据字典
user_users
```

![ select default_tablespace, temporary_tablespace from dba_users where username='SYSTEM'](img/sql-plus-select-default-from-dbasys.png)

* 设置用户的默认或临时表空间

```
ALTER USER username DEFAULT|TEMPORARY TABLESPACE tablespace_name
```








