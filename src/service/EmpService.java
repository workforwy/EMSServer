package service;

import dao.EmpDaoImp;
import entity.Emp;
import util.MySQLUtil;
import util.DaoFactory;
import util.MySQLUtil;

import java.util.List;

public class EmpService implements EmpServiceImp {

    private EmpDaoImp dao = (EmpDaoImp) DaoFactory.getInstance("empDao");

    @Override
    public Emp findById(int id) throws Exception {
        Emp e = dao.findById(id);
        MySQLUtil.close();
        return e;
    }

    @Override
    public List<Emp> findAll() throws Exception {
        List<Emp> emps = dao.findAll();
        MySQLUtil.close();
        return emps;
    }

    @Override
    public List<Emp> findAll(int index, int pagesize) throws Exception {
        List<Emp> emps = dao.findAll(index, pagesize);
        MySQLUtil.close();
        return emps;
    }

    @Override
    public void updateEmp(Emp e) throws Exception {
        MySQLUtil.openTransaction();
        dao.update(e);
        MySQLUtil.commit();
        MySQLUtil.close();
    }

    @Override
    public void removeEmp(int id) throws Exception {
        MySQLUtil.openTransaction();
        dao.delete(id);
        MySQLUtil.commit();
        MySQLUtil.close();
    }

    @Override
    public void addEmp(Emp e) throws Exception {
        MySQLUtil.openTransaction();
        dao.save(e);
        MySQLUtil.commit();
        MySQLUtil.close();
    }

}
