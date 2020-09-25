package web;

import util.DBUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author wangyong
 */
public class WebInitListener implements ServletContextListener {

    public WebInitListener() {
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        String path = arg0.getServletContext().getRealPath("WEB-INF/ems.db");
        DBUtil.URL = path;
    }
}
