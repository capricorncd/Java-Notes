package com.jspcommands.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
  // 数据库驱动
  // private static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
  private static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver"; //驱动
  // 连接数据库的URL地址
  // private static final String DB_URL = "jdbc:mysql://localhost:3306/shopping?useUnicode=true&charaterEncoding=UTF-8";
  private static final String DB_URL = "jdbc:oracle:thin:@//127.0.0.1:1521/orcl";
  // 数据库用户名
  private static final String USER_NAME = "system";
  // 数据库密码
  private static final String PASSWORD = "admin";
  // 
  private static Connection conn = null;
  
  // 静态代码块负责加载驱动
  static
  {
    try {
      Class.forName(ORACLE_DRIVER);
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  // 单列模式返回数据库连接对象
  public static Connection getConnection() {
    if (conn == null) {
      try {
        conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    return conn;
  }
  
  public static void main(String[] args) {
    try {
      Connection conn = DBHelper.getConnection();
      if (conn != null) {
        System.out.println("数据库连接成功!");
      } else {
        System.out.println("数据库连接失败!");
      }
    } catch(Exception e) {
      System.out.println("数据库连接失败，发生异常：");
      e.printStackTrace();
    }
  }
}
