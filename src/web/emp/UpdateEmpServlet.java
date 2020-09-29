package web.emp;

import entity.Emp;
import service.EmpServiceImp;
import service.EmpService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 处理updateEmp请求，更新员工信息
 *
 * @author wangyong
 */
public class UpdateEmpServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //获取请求参数  name salary age gender id
        String name = request.getParameter("name");
        String salary = request.getParameter("salary");
        String age = request.getParameter("age");
        String gender = request.getParameter("gender");
        String id = request.getParameter("id");
        Emp e = new Emp(Integer.parseInt(id), name, Double.parseDouble(salary), Integer.parseInt(age), gender);
        //执行jdbc  update语句
        EmpServiceImp service = new EmpService();
        try {
            service.updateEmp(e);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        //重定向到listEmp
        response.sendRedirect("listEmp");
    }
}



