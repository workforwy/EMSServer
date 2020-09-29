package dao;

import entity.Emp;
import util.DBUtil;
import util.MySQLUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmpDao implements EmpDaoImp {

    @Override
    public void update(Emp e) throws Exception {
        Connection conn = DBUtil.getConnection();
        String sql = "update emp set name=?, salary=?, age=?, gender=? where id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, e.getName());
        stmt.setDouble(2, e.getSalary());
        stmt.setInt(3, e.getAge());
        stmt.setString(4, e.getGender());
        stmt.setInt(5, e.getId());
        stmt.executeUpdate();
    }

    @Override
    public Emp findById(int id) throws Exception {
        Emp e = null;
        Connection conn = DBUtil.getConnection();
        String sql = "select * from emp where id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet res = stmt.executeQuery();
        if (res.next()) {
            e = new Emp(res.getInt("id"), res.getString("name"),
                    res.getDouble("salary"), res.getInt("age"),
                    res.getString("gender"));
        }
        return e;
    }

    @Override
    public List<Emp> findAll() throws Exception {
        List<Emp> emps = new ArrayList<Emp>();
        Connection conn = DBUtil.getConnection();
        String sql = "select * from emp";
        Statement stmt = conn.createStatement();
        ResultSet res = stmt.executeQuery(sql);
        while (res.next()) {
            Emp e = new Emp();
            e.setId(res.getInt("id"));
            e.setName(res.getString("name"));
            e.setAge(res.getInt("age"));
            e.setGender(res.getString("gender"));
            e.setSalary(res.getDouble("salary"));
            emps.add(e);
        }
        return emps;
    }


    @Override
    public List<Emp> findAll(int index, int pagesize) throws Exception {
        List<Emp> emps = new ArrayList<Emp>();
        Connection conn = DBUtil.getConnection();
        String sql = "select * from emp limit ?,?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, index);
        stmt.setInt(2, pagesize);
        ResultSet res = stmt.executeQuery();
        while (res.next()) {
            Emp e = new Emp();
            e.setId(res.getInt("id"));
            e.setName(res.getString("name"));
            e.setAge(res.getInt("age"));
            e.setGender(res.getString("gender"));
            e.setSalary(res.getDouble("salary"));
            emps.add(e);
        }
        return emps;
    }

    @Override
    public void delete(int id) throws Exception {
        Connection conn = DBUtil.getConnection();
        String sql = "delete from emp where id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }

    @Override
    public void save(Emp e) throws Exception {
        Connection conn = MySQLUtil.getConnection();
        String sql = "insert  into emp (name, salary, age, gender) values (?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, e.getName());
        stmt.setDouble(2, e.getSalary());
        stmt.setInt(3, e.getAge());
        stmt.setString(4, e.getGender());
        int status = stmt.executeUpdate();
        System.out.println(status);
    }

}
