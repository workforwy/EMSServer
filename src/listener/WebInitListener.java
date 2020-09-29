package listener;

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
    public void contextInitialized(ServletContextEvent arg0) {

        DBUtil.URL = arg0.getServletContext().getRealPath("WEB-INF/ems.db");
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {

    }
}
