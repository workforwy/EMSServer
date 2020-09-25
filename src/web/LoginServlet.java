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
 * 接收/login.do请求， 判断登录是否成功
 *
 * @author wangyong
 */
public class LoginServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        super.service(request, response);
        //1. 获取请求参数name   pwd
        response.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        System.out.println("name:" + name);
        System.out.println("pwd:" + pwd);
        //2. 判断登录是否成功
        //3. 根据判断的结果 输出不同的响应页面
        response.setContentType("text/html; charset=utf-8");

        PrintWriter out = response.getWriter();
        //成功
        if ("zhangsan".equals(name) && "123456".equals(pwd)) {
            out.println("success");
        } else {//失败
            out.println("error");
        }
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        ServletConfig servletConfig = this.getServletConfig();
        System.out.println("name:" + servletConfig.getInitParameter("name"));
        req.getSession();
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


