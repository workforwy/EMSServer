package web;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * ����/login.do���� �жϵ�¼�Ƿ�ɹ�
 *
 * @author wangyong
 */
public class LoginServlet extends HttpServlet {

    public LoginServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. ��ȡ�������name   pwd
        resp.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        System.out.println("name:" + name);
        System.out.println("pwd:" + pwd);
        //2. �жϵ�¼�Ƿ�ɹ�
        //3. �����жϵĽ�� �����ͬ����Ӧҳ��
        resp.setContentType("text/html; charset=utf-8");





        PrintWriter out = resp.getWriter();
        //�ɹ�
        if ("wy".equals(name) && "1".equals(pwd)) {
            out.println("success");
        } else {//ʧ��
            out.println("error");
        }
        out.close();

        // Ҫ�ض������λ��
        String site ="http://www.runoob.com";
        resp.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
        resp.setHeader("Location", site);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}


