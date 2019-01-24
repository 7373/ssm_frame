package ssm.mybatis;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;

/**
 * @ClassName JdbcUtils
 * @Description
 * @Data 2018/12/6
 * @Author Yien
 */
@Slf4j
@Data
public class JDBCUtils {


    //    private  String driver="com.mysql.jdbc.Driver";
//    private  String url="jdbc:mysql://localhost:3306/test";
//    private  String user="root";
//    private  String password="qinliang";
    private static final String url = "jdbc:postgresql://localhost:5433/test?useUnicode=true&characterEncoding=utf-8"
            + "?useUnicode=true&characterEncoding=utf8";//防止中文读取乱码
    private static final String user = "postgres";
    private static final String password = "Abc12345";
    private static String driver = "org.postgresql.Driver";

    /*可以考虑用单例*/
    //    public static Connection conn = null;
    public JDBCUtils() {

    }


    /**
     * 获取 Connetion
     *
     * @return
     * @throws SQLException
     */
    public Connection getConnection() {
        /**
         * 驱动注册
         */
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError(e);
        }
        Connection connection = null;
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            log.error("无法取得数据库连接，请检查异常");
            e.printStackTrace();
        }
        return connection;

    }

    /**
     * 释放资源
     *
     * @param conn
     * @param st
     * @param rs
     */
    public static void colseResource(Connection conn, Statement st, ResultSet rs) {
        closeResultSet(rs);
        closeStatement(st);
        closeConnection(conn);
    }

    /**
     * 释放连接 Connection
     *
     * @param conn
     */
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //等待垃圾回收
        conn = null;
    }

    /**
     * 释放语句执行者 Statement
     *
     * @param st
     */
    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //等待垃圾回收
        st = null;
    }

    /**
     * 释放结果集 ResultSet
     *
     * @param rs
     */
    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //等待垃圾回收
        rs = null;
    }
}


