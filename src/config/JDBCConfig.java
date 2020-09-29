package util;

import java.io.IOException;
import java.util.Properties;

/**
 * 用于读取properties配置文件
 */
public class JDBCConfig {

    private static Properties prop = new Properties();

    /* 静态代码块  类加载时执行1次*/
    static {
        try {
            prop.load(JDBCConfig.class.getClassLoader().getResourceAsStream("asset/jdbc.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key) {
        return prop.getProperty(key);
    }

    static final String JDBC_DRIVER = getValue("jdbc_driver");
    static final String DB_URL = getValue("url");

    /**
     * 数据库的用户名与密码，需要根据自己的设置
     */
    static final String USER = getValue("user");
    static final String PASS = getValue("password");


    public static void main(String[] args) {
        System.out.println(getValue("jdbc_driver"));
        System.out.println(getValue("url"));
        System.out.println(getValue("user"));
        System.out.println(getValue("password"));
    }
}




