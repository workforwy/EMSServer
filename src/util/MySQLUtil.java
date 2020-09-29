package util;

import util.JDBCConfig;

import java.sql.*;

/**
 * @author wangyong
 */
public class MySQLUtil {

    private static ThreadLocal<Connection> conns = new ThreadLocal<Connection>();

    /**
     * 先去Threadlocal中寻找 当前线程是否已经创建过Connection对象，
     * 有，则直接返回。
     * 没有 在重新创建
     */
    public static Connection getConnection() throws Exception {
        Connection conn = conns.get();
        if (conn == null) {
            try {
                Class.forName(JDBCConfig.JDBC_DRIVER);
                conn = DriverManager.getConnection(JDBCConfig.DB_URL, JDBCConfig.USER, JDBCConfig.PASS);
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
            //存入ThreadLocal
            conns.set(conn);
        }
        return conn;
    }

    /**
     * 关闭连接对象
     *
     * @throws Exception
     */
    public static void close() throws Exception {
        Connection conn = conns.get();
        if (conn != null) {
            conn.close();
            //把ThreadLocal中的connection对象置null
            conns.set(null);
        }
    }

    /***
     * 开启数据库事务
     * @throws Exception
     */
    public static void openTransaction() throws Exception {
        Connection conn = getConnection();
        conn.setAutoCommit(false);
    }

    /**
     * 提交事务
     *
     * @throws Exception
     */
    public static void commit() throws Exception {
        Connection conn = conns.get();
        conn.commit();
    }
}
