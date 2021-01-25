package web;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import entity.User;
import exception.NameAlreadyUseException;
import exception.NameOrPwdErrorException;
import service.UserServiceImp;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Random;

/**
 * ���ڴ����û���ص�����
 * @author wangyong
 */
public class UserInfo extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //����ͬһ����
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String uri = request.getRequestURI();
        uri = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf("."));
        //�ֶ��ַ�����
        switch (uri) {
            case "regist":
                regist(request, response);
                break;
            case "login":
                login(request, response);
                break;
            case "getCode":
                getCode(request, response);
                break;
            default:
                break;
        }
    }

    /**
     * ������֤��ͼƬ
     */
    public void getCode(HttpServletRequest request, HttpServletResponse resp) throws IOException, ServletException {
        //������Ӧ����������
        resp.setContentType("image/jpeg");
        //������֤��ͼƬ
        BufferedImage image = new BufferedImage(130, 50, BufferedImage.TYPE_INT_RGB);
        //��ȡ���ڻ��Ƹ�ͼƬ�Ļ��ʶ���
        Graphics g = image.getGraphics();
        //���Ʊ���
        g.setColor(randomColor());
        g.fillRect(0, 0, 130, 50);
        //��������
        String strs = "ABCDEFGHJKMNPQRSTWXY83";
        String str = "";
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            str += strs.charAt(r.nextInt(strs.length()));
        }
        //���ַ�������session
        HttpSession session = request.getSession();
        session.setAttribute("code", str);
        g.setColor(randomColor());
        g.setFont(new Font("����", Font.ITALIC, 45));
        g.drawString(str, 15, 30);
        //�Ѹ�ͼƬѹ����JPEG��ʽ
        //����������ͻ���
        OutputStream os = resp.getOutputStream();
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);
        encoder.encode(image);
    }

    /**
     * ������¼����
     */
    public void login(HttpServletRequest request, HttpServletResponse resp) throws IOException, ServletException {
        PrintWriter out = resp.getWriter();
        //1  ��ȡ�����������
        String name = request.getParameter("loginname");
        String pwd = request.getParameter("password");
        String code = request.getParameter("code");
        //�ж���֤���Ƿ���ȷ
        HttpSession session = request.getSession();
        String scode = (String) session.getAttribute("code");
        if (!code.equalsIgnoreCase(scode)) {
            out.println("{\"result\":\"error\", \"msg\":\"��֤���������,����������\"}");
            out.close();
            return;
        }
        //2  ����ҵ���ִ�е�¼ҵ��
        UserServiceImp service = new UserService();
        try {
            service.login(name, pwd);
            //3  ���ݲ�ͬ�ķ���ֵ ������Ӧjson
            out.println("{\"result\":\"ok\"}");
        } catch (NameOrPwdErrorException e) {
            out.println("{\"result\":\"error\", \"msg\":\"" + e.getMessage() + "\"}");
        } catch (Exception e) {
            e.printStackTrace();
            out.println("{\"result\":\"error\", \"msg\":\"ϵͳ��æ   �Ժ�����\"}");
        }
        out.close();
    }

    /**
     * ����ע������
     */
    public void regist(HttpServletRequest request, HttpServletResponse resp) throws IOException, ServletException {
        PrintWriter out = resp.getWriter();
        //1.��ȡ����
        String loginname = request.getParameter("loginname");
        String password = request.getParameter("password");
        String realname = request.getParameter("realname");
        String email = request.getParameter("email");
        entity.User user = new entity.User(0, loginname, password, realname, email);
        //2. ����ҵ��� ִ��ע��ҵ��
        UserServiceImp service = new UserService();
        try {
            service.regist(user);
            //3. ���ݲ�ͬ�ķ���ֵ ���ز�ͬ��json
            out.println("{\"result\":\"ok\"}");
        } catch (NameAlreadyUseException e) {
            out.println("{\"result\":\"error\", \"msg\":\"" + e.getMessage() + "\"}");
        } catch (Exception e) {
            e.printStackTrace();
            out.println("{\"result\":\"error\", \"msg\":\"ϵͳ��æ   �Ժ�����\"}");
        }
        out.close();
    }

    public Color randomColor() {
        Random r = new Random();
        return new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
    }
}

