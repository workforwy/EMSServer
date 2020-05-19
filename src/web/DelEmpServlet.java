package web;

import service.EmpService;
import service.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/** ����delEmp?id=1 ɾ������  ɾ��Ա�� */
public class DelEmpServlet extends HttpServlet {
	public void service(HttpServletRequest request,
                        HttpServletResponse response)
			throws ServletException, IOException {
		//����
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		//1. ��ȡ�������   id
		String id=request.getParameter("id");
		//2. ִ��jdbc ɾ��Ա������
		EmpService service=new EmpServiceImpl();
		try {
			service.removeEmp(Integer.parseInt(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		//3. �ض���listEmp
		response.sendRedirect("listEmp");
	}
}


