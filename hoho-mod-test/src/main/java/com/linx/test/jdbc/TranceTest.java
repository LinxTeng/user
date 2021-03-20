package com.linx.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TranceTest {

        public static void main(String[] args) {
            Connection conn = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "test", "test");
                conn.setAutoCommit(false);//设置为手动提交
                Statement stmt = conn.createStatement();
                stmt.execute("insert into test values (1, 'aa', 'bb')");
                conn.commit();//事务提交
                conn.setAutoCommit(true);
            } catch (SQLException e) {//异常处理
                try {
                    if (conn != null) {
                        conn.rollback();//事务回滚
                        conn.setAutoCommit(true);
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }

            catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                if(conn != null)  {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
}
