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
 * ����updateEmp���󣬸���Ա����Ϣ
 *
 * @author wangyong
 */
public class UpdateEmpServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //����
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //��ȡ�������  name salary age gender id
        String name = request.getParameter("name");
        String salary = request.getParameter("salary");
        String age = request.getParameter("age");
        String gender = request.getParameter("gender");
        String id = request.getParameter("id");
        Emp e = new Emp(Integer.parseInt(id), name, Double.parseDouble(salary), Integer.parseInt(age), gender);
        //ִ��jdbc  update���
        EmpServiceImp service = new EmpService();
        try {
            service.updateEmp(e);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        //�ض���listEmp
        response.sendRedirect("listEmp");
    }
}



