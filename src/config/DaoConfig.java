package config;

import java.io.IOException;
import java.util.Properties;

/**
 * ���ڶ�ȡproperties�����ļ�
 * @author wangyong
 */
public class DaoConfig {

    private static Properties properties = new Properties();

    /* ��̬�����  �����ʱִ��1��*/
    static {
        try {
            properties.load(DaoConfig.class.getClassLoader().getResourceAsStream("asset/dao.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key) {
        return properties.getProperty(key);
    }

    public static void main(String[] args) {
        System.out.println(getValue("empDao"));
        System.out.println(getValue("userDao"));
    }
}




