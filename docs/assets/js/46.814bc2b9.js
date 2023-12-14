(window.webpackJsonp=window.webpackJsonp||[]).push([[46],{335:function(s,a,e){"use strict";e.r(a);var t=e(10),l=Object(t.a)({},(function(){var s=this,a=s._self._c;return a("ContentSlotsDistributor",{attrs:{"slot-key":s.$parent.slotKey}},[a("h1",{attrs:{id:"表空间"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#表空间"}},[s._v("#")]),s._v(" 表空间")]),s._v(" "),a("div",{staticClass:"custom-block tip"},[a("p",{staticClass:"custom-block-title"},[s._v("数据库与表空间")]),s._v(" "),a("p",[a("strong",[s._v("表空间")]),s._v("实际上是"),a("strong",[s._v("数据库的逻辑存储空间")]),s._v("，可以理解为在数据库中开辟的一个空间，用来"),a("strong",[s._v("存储数据库对象")]),s._v("。一个数据库可以由多个表空间构成。")]),s._v(" "),a("p",[s._v("此特点也是与MySQL等数据库的主要区别。Oracle的很多优化也是通过表空间来实现的。")])]),s._v(" "),a("div",{staticClass:"custom-block tip"},[a("p",{staticClass:"custom-block-title"},[s._v("表空间与数据文件")]),s._v(" "),a("p",[a("strong",[s._v("表空间")]),s._v("实际上是由"),a("strong",[s._v("多个数据文件")]),s._v("构成的，数据文件的大小和位置可以由用户自己定义。")]),s._v(" "),a("p",[s._v("表空间可分为：永久表空间、临时表空间、UNDO表空间")])]),s._v(" "),a("p",[a("strong",[s._v("永久表空间")])]),s._v(" "),a("p",[s._v("数据库中需要永久化存储的一些对象。比如表、视图、存储过程等")]),s._v(" "),a("p",[a("strong",[s._v("临时表空间")])]),s._v(" "),a("p",[s._v("数据库操作过程中，中间执行的过程，执行结束后，存放的内容将被自动释放掉。不进行永久性的保存。")]),s._v(" "),a("p",[a("strong",[s._v("UNDO表空间")])]),s._v(" "),a("p",[s._v("用于保存事务所修改的旧址，即保存修改之前的数据。可以利用此功能实现回滚等操作。")]),s._v(" "),a("h3",{attrs:{id:"查看用户的表空间"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#查看用户的表空间"}},[s._v("#")]),s._v(" 查看用户的表空间")]),s._v(" "),a("div",{staticClass:"language- line-numbers-mode"},[a("pre",{pre:!0,attrs:{class:"language-text"}},[a("code",[s._v("# 系统用户登录查看的数据字典\ndba_tablespaces\n# 普通用户登录查看的数据字典\nuser_tablespaces\n")])]),s._v(" "),a("div",{staticClass:"line-numbers-wrapper"},[a("span",{staticClass:"line-number"},[s._v("1")]),a("br"),a("span",{staticClass:"line-number"},[s._v("2")]),a("br"),a("span",{staticClass:"line-number"},[s._v("3")]),a("br"),a("span",{staticClass:"line-number"},[s._v("4")]),a("br")])]),a("p",[a("strong",[s._v("系统用户")])]),s._v(" "),a("p",[a("img",{attrs:{src:"/img/oracle/sql-plus-dba-tablespaces.png",alt:"sql-plus-dba-tablespaces"}})]),s._v(" "),a("p",[a("img",{attrs:{src:"/img/oracle/sql-plus-dba-tablespace-name.png",alt:"sql-plus-dba-tablespaces"}})]),s._v(" "),a("p",[s._v("SYSTEM: 系统表空间")]),s._v(" "),a("p",[s._v("SYSAUX: 辅助表空间，安装Oracle示例使用的表空间。")]),s._v(" "),a("p",[s._v("UNDOTBS1: 社交类型表空间")]),s._v(" "),a("p",[s._v("TEMP:")]),s._v(" "),a("p",[s._v("USERS:")]),s._v(" "),a("p",[a("strong",[s._v("普通用户")])]),s._v(" "),a("p",[a("img",{attrs:{src:"/img/oracle/sql-plus-users-tablespaces.png",alt:"sql-plus-users-tablespaces"}})]),s._v(" "),a("div",{staticClass:"language- line-numbers-mode"},[a("pre",{pre:!0,attrs:{class:"language-text"}},[a("code",[s._v("# 系统用户登录查看的数据字典\ndba_users\n# 普通用户登录查看的数据字典\nuser_users\n")])]),s._v(" "),a("div",{staticClass:"line-numbers-wrapper"},[a("span",{staticClass:"line-number"},[s._v("1")]),a("br"),a("span",{staticClass:"line-number"},[s._v("2")]),a("br"),a("span",{staticClass:"line-number"},[s._v("3")]),a("br"),a("span",{staticClass:"line-number"},[s._v("4")]),a("br")])]),a("p",[a("img",{attrs:{src:"/img/oracle/sql-plus-select-default-from-dbasys.png",alt:"select default_tablespace, temporary_tablespace from dba_users where username='SYSTEM'"}})]),s._v(" "),a("h3",{attrs:{id:"设置用户的默认或临时表空间"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#设置用户的默认或临时表空间"}},[s._v("#")]),s._v(" 设置用户的默认或临时表空间")]),s._v(" "),a("div",{staticClass:"language- line-numbers-mode"},[a("pre",{pre:!0,attrs:{class:"language-text"}},[a("code",[s._v("ALTER USER username DEFAULT|TEMPORARY TABLESPACE tablespace_name\n# alter user system default tablespace xxx\n")])]),s._v(" "),a("div",{staticClass:"line-numbers-wrapper"},[a("span",{staticClass:"line-number"},[s._v("1")]),a("br"),a("span",{staticClass:"line-number"},[s._v("2")]),a("br")])]),a("div",{staticClass:"custom-block tip"},[a("p",{staticClass:"custom-block-title"},[s._v("单选")]),s._v(" "),a("p",[s._v("在Oracle数据库安装完成后，system用户的默认表空间和临时表空间分别是："),a("code",[s._v("system, temp")])])]),s._v(" "),a("h3",{attrs:{id:"创建表空间"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#创建表空间"}},[s._v("#")]),s._v(" 创建表空间")]),s._v(" "),a("div",{staticClass:"language- line-numbers-mode"},[a("pre",{pre:!0,attrs:{class:"language-text"}},[a("code",[s._v("CREATE [TEMPORARY] TABLESPACE\ntablespace_name\nTEMPFILE|DATAFILE `xx.dbf` SIZE xx\n")])]),s._v(" "),a("div",{staticClass:"line-numbers-wrapper"},[a("span",{staticClass:"line-number"},[s._v("1")]),a("br"),a("span",{staticClass:"line-number"},[s._v("2")]),a("br"),a("span",{staticClass:"line-number"},[s._v("3")]),a("br")])]),a("p",[a("code",[s._v("xx.dbf")]),s._v("如未指定路径，将被直接存储在Oracle的安装默认目录中。")]),s._v(" "),a("div",{staticClass:"language- line-numbers-mode"},[a("pre",{pre:!0,attrs:{class:"language-text"}},[a("code",[s._v("# 创建一个大小为10M的永久表空间\ncreate tablespace test1_tablespace\ndatafile `test1file.dbf` size 10m;\n")])]),s._v(" "),a("div",{staticClass:"line-numbers-wrapper"},[a("span",{staticClass:"line-number"},[s._v("1")]),a("br"),a("span",{staticClass:"line-number"},[s._v("2")]),a("br"),a("span",{staticClass:"line-number"},[s._v("3")]),a("br")])]),a("div",{staticClass:"language- line-numbers-mode"},[a("pre",{pre:!0,attrs:{class:"language-text"}},[a("code",[s._v("# 创建一个大小为10M的临时表空间\ncreate temporary tablespace temp_test_tablespace\ntempfile `tempfile1.dbf` size 10m;\n")])]),s._v(" "),a("div",{staticClass:"line-numbers-wrapper"},[a("span",{staticClass:"line-number"},[s._v("1")]),a("br"),a("span",{staticClass:"line-number"},[s._v("2")]),a("br"),a("span",{staticClass:"line-number"},[s._v("3")]),a("br")])]),a("p",[s._v("查看表空间路径等操作")]),s._v(" "),a("p",[a("img",{attrs:{src:"/img/oracle/create-data-file.png",alt:""}})]),s._v(" "),a("p",[a("img",{attrs:{src:"/img/oracle/select-dba-temp-files.png",alt:"select-dba-temp-files"}})]),s._v(" "),a("h3",{attrs:{id:"修改表空间"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#修改表空间"}},[s._v("#")]),s._v(" 修改表空间")]),s._v(" "),a("div",{staticClass:"custom-block tip"},[a("p",{staticClass:"custom-block-title"},[s._v("修改表空间的状态")]),s._v(" "),a("p",[s._v("脱机状态")]),s._v(" "),a("p",[s._v("读写状态")])]),s._v(" "),a("p",[a("strong",[s._v("设置联机或脱机状态")])]),s._v(" "),a("div",{staticClass:"language- line-numbers-mode"},[a("pre",{pre:!0,attrs:{class:"language-text"}},[a("code",[s._v("# 修改表空间的在线状态\nALTER TABLESPACE tablespace_name\nONLINE|OFFLINE;\n")])]),s._v(" "),a("div",{staticClass:"line-numbers-wrapper"},[a("span",{staticClass:"line-number"},[s._v("1")]),a("br"),a("span",{staticClass:"line-number"},[s._v("2")]),a("br"),a("span",{staticClass:"line-number"},[s._v("3")]),a("br")])]),a("p",[s._v("脱机状态的表空间无法使用。")]),s._v(" "),a("p",[a("img",{attrs:{src:"/img/oracle/alter-tablespace-offline.png",alt:""}})]),s._v(" "),a("p",[s._v("查看online_status")]),s._v(" "),a("p",[a("img",{attrs:{src:"/img/oracle/online-status.png",alt:"online-status"}})]),s._v(" "),a("div",{staticClass:"language- line-numbers-mode"},[a("pre",{pre:!0,attrs:{class:"language-text"}},[a("code",[s._v("# 修改表空间的读写状态\nALTER TABLESPACE tablespace_name\nREAD ONLY|READ WRITE\n")])]),s._v(" "),a("div",{staticClass:"line-numbers-wrapper"},[a("span",{staticClass:"line-number"},[s._v("1")]),a("br"),a("span",{staticClass:"line-number"},[s._v("2")]),a("br"),a("span",{staticClass:"line-number"},[s._v("3")]),a("br")])]),a("p",[a("img",{attrs:{src:"/img/oracle/change-status.png",alt:"change-status"}})]),s._v(" "),a("div",{staticClass:"custom-block tip"},[a("p",{staticClass:"custom-block-title"},[s._v("修改数据文件")]),s._v(" "),a("p",[s._v("增加数据文件")]),s._v(" "),a("p",[s._v("删除数据文件")])]),s._v(" "),a("div",{staticClass:"language- line-numbers-mode"},[a("pre",{pre:!0,attrs:{class:"language-text"}},[a("code",[s._v("# 向tablespace_name中添加一个文件\nALTER TABLESPACE tablespace_name\nADD DATAFILE 'xx.dbf' SIZE xx;\n")])]),s._v(" "),a("div",{staticClass:"line-numbers-wrapper"},[a("span",{staticClass:"line-number"},[s._v("1")]),a("br"),a("span",{staticClass:"line-number"},[s._v("2")]),a("br"),a("span",{staticClass:"line-number"},[s._v("3")]),a("br")])]),a("p",[a("img",{attrs:{src:"/img/oracle/alter-tablespace-add.png",alt:"alter-tablespace-add"}})]),s._v(" "),a("div",{staticClass:"language- line-numbers-mode"},[a("pre",{pre:!0,attrs:{class:"language-text"}},[a("code",[s._v("# 删除数据文件\nALTER TABLESPACE tablespace_name\nDROP DATAFILE 'filename.dbf'\n")])]),s._v(" "),a("div",{staticClass:"line-numbers-wrapper"},[a("span",{staticClass:"line-number"},[s._v("1")]),a("br"),a("span",{staticClass:"line-number"},[s._v("2")]),a("br"),a("span",{staticClass:"line-number"},[s._v("3")]),a("br")])]),a("div",{staticClass:"custom-block warning"},[a("p",{staticClass:"custom-block-title"},[s._v("注意")]),s._v(" "),a("p",[s._v("不能删除表空间的第一个数据文件")]),s._v(" "),a("p",[s._v("如果需要删除第一个数据文件，则需将整个表空间删除。")])]),s._v(" "),a("h3",{attrs:{id:"删除表空间"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#删除表空间"}},[s._v("#")]),s._v(" 删除表空间")]),s._v(" "),a("div",{staticClass:"language- line-numbers-mode"},[a("pre",{pre:!0,attrs:{class:"language-text"}},[a("code",[s._v("DROP TABLESPACE\ntablespace_name [INCLUDING CONTENTS]\n# 只删除表空间，不删除数据文件 drop tablespace test1_tablespace\n# 删除表空间和文件 drop tablespace test1_tablespace including contents\n")])]),s._v(" "),a("div",{staticClass:"line-numbers-wrapper"},[a("span",{staticClass:"line-number"},[s._v("1")]),a("br"),a("span",{staticClass:"line-number"},[s._v("2")]),a("br"),a("span",{staticClass:"line-number"},[s._v("3")]),a("br"),a("span",{staticClass:"line-number"},[s._v("4")]),a("br")])])])}),[],!1,null,null,null);a.default=l.exports}}]);