package service;

import dao.UserDaoImp;
import entity.User;
import exception.NameAlreadyUseException;
import exception.NameOrPwdErrorException;
import util.DBUtil;
import util.DaoFactory;

/**
 * @author wangyong
 */
public class UserService implements UserServiceImp {

    private UserDaoImp dao = (UserDaoImp) DaoFactory.getInstance("userDao");

    @Override
    public void login(String name, String pwd) throws Exception {
        User user = dao.findByLoginname(name);
        if (user == null || !user.getPassword().equals(pwd)) {
            //�˺Ż��������
            DBUtil.close();
            throw new NameOrPwdErrorException();
        }
    }

    @Override
    public void regist(User user) throws Exception {
        //��ѯ�Ƿ��˺��Ѿ�����
        User dbUser = dao.findByLoginname(user.getLoginname());
        if (dbUser != null) {
            //�������
            DBUtil.close();
            throw new NameAlreadyUseException();
        }
        //��������������ע��
        dao.save(user);
        DBUtil.close();
    }
}
