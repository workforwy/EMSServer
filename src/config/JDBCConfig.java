package util;

import java.io.IOException;
import java.util.Properties;

/**
 * ���ڶ�ȡproperties�����ļ�
 */
public class JDBCConfig {

    private static Properties prop = new Properties();

    /* ��̬�����  �����ʱִ��1��*/
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
     * ���ݿ���û��������룬��Ҫ�����Լ�������
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




