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
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 获取请求参数name   pwd
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");

        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        System.out.println("name:" + name);
        System.out.println("pwd:" + pwd);
        //2. 判断登录是否成功
        //3. 根据判断的结果 输出不同的响应页面

        PrintWriter out = resp.getWriter();
        if ("wy".equals(name) && "1".equals(pwd)) {
            //成功
            out.println("success");
        } else {
            //失败
            out.println("error");
        }
        out.close();

        // 要重定向的新位置
        String site = "http://www.runoob.com";
        resp.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
        resp.setHeader("Location", site);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}


