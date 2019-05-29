package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener("/*")
public class MyApplicationListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  { 
         System.out.println("application销毁");
    }

    public void contextInitialized(ServletContextEvent sce)  { 
        System.out.println("application初始化");
    }
}	