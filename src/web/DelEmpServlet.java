package web;

import service.EmpServiceImp;
import service.EmpService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * ����delEmp?id=1 ɾ������  ɾ��Ա��
 */
public class DelEmpServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //����
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //1. ��ȡ�������   id
        String id = request.getParameter("id");
        //2. ִ��jdbc ɾ��Ա������
        EmpServiceImp service = new EmpService();
        try {
            service.removeEmp(Integer.parseInt(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //3. �ض���listEmp
        response.sendRedirect("listEmp");
    }
}


