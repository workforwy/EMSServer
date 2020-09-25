package web;

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
 * 接收addEmp请求  接收参数后插入数据库
 * @author wangyong
 */
public class AddEmpServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //编码处理
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //1.接收请求参数  name salary age gender
        String name = request.getParameter("name");
        String salary = request.getParameter("salary");
        String age = request.getParameter("age");
        String gender = request.getParameter("gender");
        Emp e = new Emp(0, name, Double.parseDouble(salary), Integer.parseInt(age), gender);
        //2.把数据插入数据库
        EmpServiceImp service = new EmpService();
        try {
            service.addEmp(e);
        } catch (Exception e1) {
            e1.printStackTrace();
            //输出失败信息
            out.println("{\"result\": \"error\",  \"msg\":\"系统异常\"}");
            out.close();
            return;
        }
        //3.
        //response.sendRedirect("listEmp");
        //输出响应JSON字符串
        out.println("{\"result\": \"ok\"}");
        out.close();
    }
}


