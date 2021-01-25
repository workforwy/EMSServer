package web;

import java.io.*;
import java.net.URLEncoder;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * @author wangyong
 */
public class Mine extends HttpServlet {

    private String message;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        message = "Hello World MyServlet";
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void destroy() {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 为名字和姓氏创建 Cookie
        // 中文转码
        Cookie name = new Cookie("name", URLEncoder.encode(request.getParameter("name"), "UTF-8"));
        Cookie url = new Cookie("url", request.getParameter("url"));

        // 为两个 Cookie 设置过期日期为 24 小时后
        name.setMaxAge(60 * 60 * 24);
        url.setMaxAge(60 * 60 * 24);

        // 在响应头中添加两个 Cookie
        response.addCookie(name);
        response.addCookie(url);

        request.getSession();

        // 设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");

        // 数据回传
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
