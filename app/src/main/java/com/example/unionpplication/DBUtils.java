package com.example.unionpplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtils {

    private final static String driver = "com.mysql.jdbc.Driver";
    private final static String url = "jdbc:mysql://192.168.137.1:3306/photo?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
    private final static String username = "root";
    private final static String password = "a137032";

    Connection conn=null;
    Statement st=null;
    ResultSet rs=null;

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println("加载驱动错误");
        }
    }


    //2. 获取连接
    public static Connection getConnect() throws Exception {
        return DriverManager.getConnection(url, username, password);
    }

    //3. 释放连接资源

    public static void release(Connection conn, Statement st, ResultSet rs) throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (st != null) {
            st.close();
        }
        if (conn != null) {
            conn.close();
        }

    }

}

