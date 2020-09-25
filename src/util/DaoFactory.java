package util;

/**
 * dao����  ��������dao����ʵ��
 */
public class DaoFactory {

    public static Object getInstance(String type) {
        //ͨ��type ��ȡ�����ļ���ȡʵ��������
        String className = DaoConfig.getValue(type);

        //ͨ�����䴴�����󲢷���
        try {
            Class clazz = Class.forName(className);
            return clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
